package application.utility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.spi.ServiceRegistry;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cart.model.CartItemBean;
import product.exceptions.ProductNotFoundException;
import product.model.*;
import product.model.AvocadoCupcake.AvocadoCupcake;
import product.model.CandyCane.CandyCane;
import product.model.ChurroSticks.ChurroSticks;
import product.model.EnglishSausage.EnglishSausage;
import product.model.JellyBeans.JellyBeans;
import product.model.PuffedDanishPastry.PuffedDanishPastry;
import product.model.StrawberryCupcake.StrawberryCupcake;
import product.model.ValentineCupcake.ValentineCupcake;
import productType.model.*;
import productType.model.Candy.Candy;
import productType.model.Cupcake.Cupcake;
import productType.model.Pastry.Pastry;
import application.iterator.*;

public class SingletonDB implements DBOperations, Iterator{
	
	//this is defaulted to null
	private static Connection connection; 
	
	
	ArrayList<DisplayProductBean> productData;
	ArrayList<DisplayProductTypeBean> productTypeData;
	
	
	private SingletonDB() {
		productTypeData =  new ArrayList<DisplayProductTypeBean>();
		productData = new ArrayList<DisplayProductBean>();
		
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
	
	/*PRINT PRODUCTS*/
	public static List<DisplayProductBean> getAllProducts(){
		//Calls data from the Database and creates an Array List
		List<DisplayProductBean> products = new ArrayList<DisplayProductBean>();
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn.prepareStatement(DISPLAY_ALL_PRODUCTS);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DisplayProductBean product = new DisplayProductBean();
				//Initialize ProductType in order to avoid Null Pointer Exception
				DisplayProductTypeBean productType = new DisplayProductTypeBean();
				product.setProductType(productType);
				
				product.setProductImgPath(rs.getString("imgPath"));
				product.setProductId(rs.getInt("productID"));
				product.setProductInfo(rs.getString("productInfo"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getDouble("productPrice"));
				
				((DisplayProductTypeBean) product.getProductType()).setProductTypeId(rs.getInt("productTypeID"));
				
				products.add(product);
			}
		}catch(SQLException sqlException){
			sqlException.getStackTrace();
		}
		return products;
	}
	
	/**PRODUCT SORT METHOD*/
	public static List<DisplayProductBean> getProductList(String selectedTypeOfProduct){
		//Calls data from the Database and creates an Array List
		List<DisplayProductBean> products = new ArrayList<DisplayProductBean>();
		try {
			Connection conn = getConnection();
			PreparedStatement st = null;
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
			while(rs.next()) {
				DisplayProductBean product = new DisplayProductBean();
				//Initialize ProductType in order to avoid Null Pointer Exception
				DisplayProductTypeBean productType = new DisplayProductTypeBean();
				product.setProductType(productType);
				
				product.setProductImgPath(rs.getString("imgPath"));
				product.setProductId(rs.getInt("productID"));
				product.setProductInfo(rs.getString("productInfo"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getDouble("productPrice"));
				product.setQuantity(rs.getInt("quantity"));
				
				((DisplayProductTypeBean) product.getProductType()).setProductTypeId(rs.getInt("productTypeID"));
				
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
		Factory factory = new Factory();
		try {
			Connection conn = factory.getConnectionObject(searchInput);
			if(conn !=null) {
				PreparedStatement ptst = conn.prepareStatement(RETRIEVE_PRODUCT);
				ptst.setString(1, searchInput);
				ResultSet rs = ptst.executeQuery();
				
				DisplayProductBean product = new DisplayProductBean();
				while(rs.next()) {
					//MAIN DATA
					product.setProductName(rs.getString("productName"));
					product.setProductInfo(rs.getString("productInfo"));
					product.setProductImgPath(rs.getString("imgPath"));
					product.setProductPrice(rs.getDouble("productPrice"));
					product.setQuantity(rs.getInt("quantity"));
					
					//FOR SQL QUERIES
					product.setProductTypeId(rs.getInt("productTypeID"));
				}
				conn.close();
				return product;
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
	public static void insertCartProduct(String productName, String productPrice, String productImgPath, String productCount,
			int orderID) {
		Connection conn = getConnection();
		try {
			
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(INSERT_CART_ITEMS);
				
				ptst.setString(1, productName);
				ptst.setString(2, productPrice);
				ptst.setString(3, productImgPath);
				ptst.setString(4, productCount);
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
	
	//SingletonDB Method for Deducting Cart 
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
	
	//SingletonDB Method for Dispoting Cart Table Data
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
		/**
			CODE BLOCK TO POPULATEDB WITH PREDEFINED PRODUCT TYPES DATA
		 */
		
		
		
		//INSERTING CANDY DATATYPE TO DATABASE  -- ID 1
		Candy candyProductType = new Candy().clone();
		
		insertProductTypes(candyProductType.productTypeId(), candyProductType.productTypeName(), candyProductType.wrapper().wrap() );
		
		//INSERTING CUPCAKE DATATYPE TO DATABASE -- ID 2
		Cupcake cupcakeProductType = new Cupcake().clone();
		
		insertProductTypes(cupcakeProductType.productTypeId(), cupcakeProductType.productTypeName(), cupcakeProductType.wrapper().wrap());
		
		//INSERTING PASTRY DATATYPE TO DATABASE -- ID 3
		Pastry pastryProductType = new Pastry().clone();
		
		insertProductTypes(pastryProductType.productTypeId(), pastryProductType.productTypeName(), pastryProductType.wrapper().wrap());
		
		/**END OF PRODUCT TYPE INSERTION*/
		
		/**
		CODE BLOCK TO POPULATEDB WITH PREDEFINED PRODUCTS DATA
		 */
		
		//INSERTING AVOCADO CUPCAKE TO DATABASE
		Product avocadoCupcake = new AvocadoCupcake().clone();
		
					
		insertProducts(avocadoCupcake.productName(), avocadoCupcake.imgPath(), 
				avocadoCupcake.productInfo(), avocadoCupcake.productPrice(), 
				 avocadoCupcake.quantity() ,cupcakeProductType.productTypeId());
		
			
		//INSERTING CHURRO STICKS TO DATABASE
		Product churroSticks = new ChurroSticks().clone();
		
		insertProducts(churroSticks.productName(), churroSticks.imgPath(), 
				churroSticks.productInfo(), churroSticks.productPrice(), 
				churroSticks.quantity() ,pastryProductType.productTypeId());

		
		//INSERTING CANDY CANE TO DATABASE
		Product candyCane = new CandyCane().clone();
		
		insertProducts(candyCane.productName(), candyCane.imgPath(), 
				candyCane.productInfo(), candyCane.productPrice(), 
				candyCane.quantity() ,candyProductType.productTypeId());
		
		//INSERTING VALENTINE CUPCAKE TO DATABASE
		Product valentineCupcake = new ValentineCupcake().clone();
				
		insertProducts(valentineCupcake.productName(), valentineCupcake.imgPath(), 
				valentineCupcake.productInfo(), valentineCupcake.productPrice(), 
				valentineCupcake.quantity() ,cupcakeProductType.productTypeId());
		
		
		//INSERTING JELLY BEANS TO DATABASE
		Product jellyBeans = new JellyBeans().clone();
						
		insertProducts(jellyBeans.productName(), jellyBeans.imgPath(), 
				jellyBeans.productInfo(), jellyBeans.productPrice(), 
				 jellyBeans.quantity() ,candyProductType.productTypeId());
		
		//INSERTING Puffed Danish Pastry TO DATABASE
		Product puffedDanishPastry = new PuffedDanishPastry().clone();
						
		insertProducts(puffedDanishPastry.productName(), puffedDanishPastry.imgPath(), 
				puffedDanishPastry.productInfo(), puffedDanishPastry.productPrice(), 
				 puffedDanishPastry.quantity() ,pastryProductType.productTypeId());
		
		
		//INSERTING STRAWBERRY CUPCAKE TO DATABASE
		Product strawberryCupcake = new StrawberryCupcake().clone();
						
		insertProducts(strawberryCupcake.productName(), strawberryCupcake.imgPath(), 
				strawberryCupcake.productInfo(), strawberryCupcake.productPrice(), 
				 strawberryCupcake.quantity() ,pastryProductType.productTypeId());
		
		//INSERTING ENGLISH SAUSAGE TO DATABASE
		Product englishSausage = new EnglishSausage().clone();
					
		insertProducts(englishSausage.productName(), englishSausage.imgPath(), 
				englishSausage.productInfo(), englishSausage.productPrice(), 
				 englishSausage.quantity() ,pastryProductType.productTypeId());
		
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

	@Override
	public Iterator createIterator() {
		return null;
	}
	
}
