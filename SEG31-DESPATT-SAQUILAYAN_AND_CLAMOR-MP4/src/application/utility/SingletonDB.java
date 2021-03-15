package application.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cart.model.CartItemBean;

import product.exceptions.ProductNotFoundException;
import product.model.*;

import productType.model.*;
import application.iterator.*;

public class SingletonDB implements DBOperations{
	
	static ProductData productData;
	static ProductTypeData productTypeData;
	
	static ProductIterator iterProduct;
	static ProductIterator iterProductType;
	
	//this is defaulted to null
	private static Connection connection; 

	
	private SingletonDB() {	
	}
	
	public static Connection getDBConnection() {
		Connection connection = null;
		try {
			
			try {
				connection = ( (DataSource)InitialContext.doLookup("java:/comp/env/jdbc/MP3_DESPATT")).getConnection();
				
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}catch (NullPointerException npe) {
			npe.printStackTrace();
		}
		return connection;
	}
	
	public static Connection getConnection() {
		return (( connection !=null )
			? connection
			: getDBConnection());		
	}
	
	//INITIALIZE TABLE AND FOREIGN KEY CONSTRAINTS
	
	//SingletonDB method that will initialize tables and constraints
	public static boolean initializeTablesAndConstraints() {
		try {
			Connection conn = getConnection();
			
			//Create Product and Product Types Table
			PreparedStatement ptstCreateProductTable = conn.prepareStatement(CREATE_PRODUCT_TABLE);
			ptstCreateProductTable.executeUpdate();
			ptstCreateProductTable.close();
			
			PreparedStatement ptstCreateProductTypeTable = conn.prepareStatement(CREATE_PRODUCT_TYPES_TABLE);
			ptstCreateProductTypeTable.executeUpdate();
			ptstCreateProductTypeTable.close();
			
			//Create Cart Table
			PreparedStatement ptstCreateCartTable = conn.prepareStatement(CREATE_CART_TABLE);
			ptstCreateCartTable.executeUpdate();
			ptstCreateCartTable.close();
			
			//Create Order Cart Table
			PreparedStatement ptstCreateOrderTable = conn.prepareStatement(CREATE_CART_ORDER);
			ptstCreateOrderTable.executeUpdate();
			ptstCreateOrderTable.close();
			
			//ADD FOREIGN KEY CONSTRAINTS
			PreparedStatement ptstAddForeignKeyProductTypeID = conn.prepareStatement(ADD_FOREIGN_KEY_PRODUCT_TYPE_ID);
			ptstAddForeignKeyProductTypeID.executeUpdate();
			ptstAddForeignKeyProductTypeID.close();
			
			PreparedStatement ptstAddForeignKeyOrderID = conn.prepareStatement(ADD_FOREIGN_KEY_ORDER_ID);
			ptstAddForeignKeyOrderID.executeUpdate();
			ptstAddForeignKeyOrderID.close();
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			//Initialization Failed
			return false;
		}
		//Initialization Successful
		return true;
	}
	
	/**PRODUCT SORT METHOD*/
	//SingletonDB method that will get Product list based on user input
	public static List<DisplayProductBean> getProductList(String selectedTypeOfProduct){
		//Initialize Iterator
		productData = new ProductData();
		productTypeData = new ProductTypeData();
		
		initialize(productData,productTypeData);
		
		//Calls data from the Database and creates an Array List
		List<DisplayProductBean> products = new ArrayList<DisplayProductBean>();
		try {
			Connection conn = getConnection();
			PreparedStatement st = null;
			
			//Adds Product data to DB
			Iterator<DisplayProductBean> productIterator = iterProduct.createIterator();
			//Iterator<DisplayProductTypeBean> productTypeIterator = iterProductType.createIterator();
			
			if(selectedTypeOfProduct.equalsIgnoreCase("Candy")) {
				st = conn.prepareStatement(DISPLAY_CANDY);
			}else if(selectedTypeOfProduct.equalsIgnoreCase("Cupcake")){
			    st = conn.prepareStatement(DISPLAY_CUPCAKES);
			}else if(selectedTypeOfProduct.equalsIgnoreCase("Pastry")) {
			    st = conn.prepareStatement(DISPLAY_PASTRY);
			}else if(selectedTypeOfProduct.equalsIgnoreCase("All")) {
			    st = conn.prepareStatement(DISPLAY_ALL_PRODUCTS);
			}
			ResultSet rs = st.executeQuery();
			while(rs.next() && productIterator.hasNext()/* && productTypeIterator.haxNext()*/) {
				DisplayProductBean product = (DisplayProductBean) productIterator.next();
				//Initialize ProductType in order to avoid Null Pointer Exception 
				//ITERATOR PRODUCT TYPECURRENTLY NOT WORKING: POSSIBLE PROBLEM IS THAT ITERATOR IS SEQUENTIAL
				//DisplayProductTypeBean productType = (DisplayProductTypeBean) productTypeIterator.next();
				DisplayProductTypeBean productType = new DisplayProductTypeBean();
				
				product.setProductType(productType);
				
				product.setProductImgPath(rs.getString("imgPath"));
				product.setProductId(rs.getInt("productID"));
				product.setProductInfo(rs.getString("productInfo"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getDouble("productPrice"));
				product.setQuantity(rs.getInt("quantity"));
				
				( (DisplayProductTypeBean) product.getProductType()).setProductTypeId(rs.getInt("productTypeID"));
				
				products.add(product);
			}	
			
		}catch(SQLException sqlException) {
			sqlException.getStackTrace();
		}catch(NullPointerException npe) {
			npe.getStackTrace();
		}
		return products;
	}
	
	//SingletonDB Method for Getting Product
	public static DisplayProductBean getProduct(String searchInput) throws ProductNotFoundException {
		//Initialize Iterator
		productData = new ProductData();
		productTypeData = new ProductTypeData();
		
		initialize(productData,productTypeData);
		
		Factory factory = new Factory();
		try {
			Connection conn = factory.getConnectionObject(searchInput);
			if(conn !=null) {
				PreparedStatement ptst = conn.prepareStatement(RETRIEVE_PRODUCT);
				ptst.setString(1, searchInput);
				ResultSet rs = ptst.executeQuery();
				
				//Adds Product data to DB
				Iterator<DisplayProductBean> productIterator = iterProduct.createIterator();

				while(rs.next() && productIterator.hasNext()) {
					DisplayProductBean product = (DisplayProductBean) productIterator.next();
					
					//MAIN DATA
					product.setProductName(rs.getString("productName"));
					product.setProductInfo(rs.getString("productInfo"));
					product.setProductImgPath(rs.getString("imgPath"));
					product.setProductPrice(rs.getDouble("productPrice"));
					product.setQuantity(rs.getInt("quantity"));
					
					//FOR SQL QUERIES
					product.setProductTypeId(rs.getInt("productTypeID"));
					return product;
				}
				conn.close();
			}
		}catch(SQLException sqle) {
			sqle.getStackTrace();
		}
		return null;
	}
	
	//SingletonDB Method for Getting Product Type
	public static DisplayProductTypeBean getProductType(int productTypeID) {
		try {
			Connection conn = getConnection();
			if(conn != null) {
				PreparedStatement ptst = conn.prepareStatement(RETRIEVE_PRODUCT_TYPE);
				ptst.setInt(1, productTypeID);
				ResultSet rs = ptst.executeQuery();
				
				DisplayProductTypeBean productType = new DisplayProductTypeBean();
				while(rs.next()) {
					//MAIN DATA
					productType.setProductTypeId(rs.getInt("productTypeID"));
					productType.setProductTypeName(rs.getString("productTypeName"));
				}
				conn.close();
				return productType;
			}
		}catch(SQLException sqle) {
			sqle.getStackTrace();
		}
		return null;
	}
	
	//SingletonDB Method for Getting Cart-Item
	public static List<CartItemBean> getCartItems() {
		try {
			Connection conn = getConnection();
			List<CartItemBean> cartItems = new ArrayList<CartItemBean>();
			if(conn != null) {
				PreparedStatement ptst = conn.prepareStatement(DISPLAY_CART);
				ResultSet rs = ptst.executeQuery();
				while(rs.next()) {
					CartItemBean cart = new CartItemBean();
					
					cart.setProductName(rs.getString("productName"));
					cart.setProductImgPath(rs.getString("productImgPath"));
					cart.setProductPrice(rs.getString("productPrice"));
					cart.setCount(rs.getString("productCount"));
					
					cartItems.add(cart);
				}
			}
			return cartItems;
			
		}catch(SQLException sqle) {
			sqle.getStackTrace();
		}
		return null;
	}
	
	//SingletonDB Method for Inserting Products to DB
	public static void insertProducts(
			String productName, String imgPath,
			String productInfo,double productPrice,
			 int quantity,
			int productTypeID) {
		try {
			Connection conn  = getConnection();
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(INSERT_PRODUCTS);
				
				ptst.setInt(1, productTypeID);
				ptst.setString(2, productName);
				ptst.setString(3, imgPath);
				ptst.setString(4, productInfo);
				ptst.setDouble(5, productPrice);
				ptst.setInt(6, quantity);

				ptst.executeUpdate();
				ptst.close();
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//SingletonDB Method for Inserting Product Types to DB
	public static void insertProductTypes(int ProductTypeID, String productTypeName,String wrapper) {
		try {
			Connection conn = getConnection();
			
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(INSERT_PRODUCT_TYPES);
				
				ptst.setInt(1, ProductTypeID);
				ptst.setString(2, productTypeName);
				ptst.setString(3, wrapper);
				ptst.executeUpdate();
				ptst.close();
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SingletonDB Method for Inserting Cart Items to DB
	public static void insertCartProduct(String productName, double productPrice, String productImgPath, int productCount,
			int orderID) {
		Connection conn = getConnection();
		try {
			
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(INSERT_CART_ITEMS);
				
				ptst.setString(1, productName);
				ptst.setDouble(2, productPrice);
				ptst.setString(3, productImgPath);
				ptst.setInt(4, productCount);
				ptst.setInt(5, orderID);
				
				ptst.executeUpdate();
				ptst.close();
				
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SingletonDB Method for generating an cart-order row to DB
	public static void generateOrder(int orderID, boolean isBoxed) {
		Connection conn = getConnection();
		try {
			if(conn!= null) {
				PreparedStatement ptst = conn.prepareStatement(GENERATE_ORDER);
				
				ptst.setInt(1, orderID);
				ptst.setBoolean(2, isBoxed);
				
				ptst.executeUpdate();
				ptst.close();
			}
			System.out.println("CART ORDER ROW GENERATED");
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SingletonDB Method for Getting Product Quantity of Cart Product
	public static int getCartProductQuantity(String productName) {
		Connection conn = getConnection();	
		try {
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(RETRIEVE_PRODUCT_QUANTITY);
				
				ptst.setString(1, productName);
				ResultSet rs = ptst.executeQuery();
				
				if(rs.next()) {
					return rs.getInt(1);
				}else {
					System.out.println("FAILED");
					return 0;
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//SingletonDB Method for Getting Quantity of Specified Product
	public static int getProductQuantity(String productName) {
		Connection conn = getConnection();	
		try {
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(RETRIEVE_PRODUCT_QUANTITY);
				
				ptst.setString(1, productName);
				ResultSet rs = ptst.executeQuery();
				
				if(rs.next()) {
					return rs.getInt(1);
				}else {
					System.out.println("FAILED");
					return 0;
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//SingletonDB Method for deducting the original product quantity based on the quantity on the cart
	public static void deductQuantityCart(int originalQuantity, int orderQuantity, String productName) {
		Connection conn = getConnection();
		try {
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(DEDUCT_QUANTITY);
				
				ptst.setInt(1, originalQuantity - orderQuantity);//Cart Quantity
				ptst.setString(2, productName);
				int rs = ptst.executeUpdate();
				
				if(rs > 0) {
					System.out.println("PRODUCT QUANTITY HAS BEEN UPDATED");
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	//SingletonDB Method that will dispose cart table data
	public static void disposeCartTableData() {
		Connection conn = getConnection();
		try {
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(CART_DATA_DISPOSAL);
				
				ptst.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PopulateDB with pre-defined products and product types
	public static void populateDb() {
		productData = new ProductData();
		productTypeData = new ProductTypeData();
		
		initialize(productData,productTypeData);
		
		
		//Adds Product Type Data to DB
		Iterator<DisplayProductTypeBean> productTypeIterator = iterProductType.createIterator();
		
		while(productTypeIterator.hasNext()) {
			DisplayProductTypeBean productType = (DisplayProductTypeBean) productTypeIterator.next();
			
			insertProductTypes(productType.getProductTypeId(), productType.getProductTypeName(), productType.getWrapper());
		}
		
		
		//Adds Product data to DB
		Iterator<DisplayProductBean> productIterator = iterProduct.createIterator();
		
		
		while(productIterator.hasNext()) {
			DisplayProductBean product = (DisplayProductBean) productIterator.next();
			
			insertProducts(product.getProductName(),product.getProductImgPath(),
					product.getProductInfo(),product.getProductPrice(),product.getQuantity(), product.getProductTypeId());
		}
		
	}
	
	//FOR TESTING
	public static void disposeDb() {
		String dropDb = "DROP DATABASE `seg31_despatt`";
		try {
			Connection conn = getConnection();
			PreparedStatement ptst = conn.prepareStatement(dropDb);
			
			ptst.executeQuery();
			ptst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	//INSIDE SINGLETONDB METHOD FUNCTIONS
	public static void initialize(ProductIterator newProductData, ProductIterator newProductType) {
		iterProduct = newProductData;
		iterProductType = newProductType;
	}
	
	
}
