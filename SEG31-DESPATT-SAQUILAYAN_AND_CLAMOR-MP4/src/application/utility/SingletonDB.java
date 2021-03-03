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

public class SingletonDB implements DBOperations{
	
	//this is defaulted to null
	private static Connection connection; 
	
	
	
	SingletonDB() {
	
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
			
			//ADD FOREIGN KEY CONSTRAINTs
			PreparedStatement ptstAddForeignKeyProductTypeID = conn.prepareStatement(ADD_FOREIGN_KEY_PRODUCT_TYPE_ID);
			ptstAddForeignKeyProductTypeID.executeUpdate();
			ptstAddForeignKeyProductTypeID.close();
			
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
				
				product.setAvailibility(rs.getBoolean("isAvailable"));
				product.setImgPath(rs.getString("imgPath"));
				product.setProductId(rs.getInt("productID"));
				product.setProductInfo(rs.getString("productInfo"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getDouble("productPrice"));
				
				product.getProductType().setProductTypeId(rs.getInt("productTypeID"));
				
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
				
				product.setAvailibility(rs.getBoolean("isAvailable"));
				product.setImgPath(rs.getString("imgPath"));
				product.setProductId(rs.getInt("productID"));
				product.setProductInfo(rs.getString("productInfo"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getDouble("productPrice"));
				
				product.getProductType().setProductTypeId(rs.getInt("productTypeID"));
				
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
					product.setImgPath(rs.getString("imgPath"));
					product.setProductPrice(rs.getDouble("productPrice"));
					product.setAvailibility(rs.getBoolean("isAvailable"));
					
					//FOR SQL QUERIES
					product.setProductTypeID(rs.getInt("productTypeID"));
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
			boolean isAvailable,int productTypeID) {
		try {
			Connection conn  = getConnection();
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(INSERT_PRODUCTS);
				
				ptst.setInt(1, productTypeID);
				ptst.setString(2, productName);
				ptst.setString(3, imgPath);
				ptst.setString(4, productInfo);
				ptst.setDouble(5, productPrice);
				ptst.setBoolean(6, isAvailable);

				ptst.executeUpdate();
				ptst.close();
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//SingletonDB Method for Inserting Product Types to DB
	public static void insertProductTypes(int ProductTypeID, String productTypeName) {
		try {
			Connection conn = getConnection();
			
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(INSERT_PRODUCT_TYPES);
				
				ptst.setInt(1, ProductTypeID);
				ptst.setString(2, productTypeName);
				ptst.executeUpdate();
				ptst.close();
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SingletonDB Method for Inserting Cart Items to DB
	public static void insertCartProduct(String productName, String productPrice, String productImgPath, String productCount) {
		Connection conn = getConnection();
		try {
			
			if(conn!=null) {
				PreparedStatement ptst = conn.prepareStatement(INSERT_CART_ITEMS);
				
				ptst.setString(1, productName);
				ptst.setString(2, productPrice);
				ptst.setString(3, productImgPath);
				ptst.setString(4, productCount);
				ptst.executeUpdate();
				ptst.close();
				
			}
			conn.close();
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
		Candy candyProductType = new Candy();
		candyProductType.setProductTypeName("Candy");
		candyProductType.setProductTypeId(1);
		
		insertProductTypes(candyProductType.getProductTypeId(), candyProductType.getProductTypeName());
		
		//INSERTING CUPCAKE DATATYPE TO DATABASE -- ID 2
		ProductType cupcakeProductType = new Cupcake().clone();
		cupcakeProductType.setProductTypeName("Cupcake");
		cupcakeProductType.setProductTypeId(2);
		
		insertProductTypes(cupcakeProductType.getProductTypeId() ,cupcakeProductType.getProductTypeName());
		
		//INSERTING PASTRY DATATYPE TO DATABASE -- ID 3
		Pastry pastryProductType = new Pastry();
		pastryProductType.setProductTypeName("Pastry");
		pastryProductType.setProductTypeId(3);
		
		insertProductTypes(pastryProductType.getProductTypeId(), pastryProductType.getProductTypeName());
		
		/**END OF PRODUCT TYPE INSERTION*/
		
		/**
		CODE BLOCK TO POPULATEDB WITH PREDEFINED PRODUCTS DATA
		 */
		
		//INSERTING AVOCADO CUPCAKE TO DATABASE
		Product avocadoCupcake = new AvocadoCupcake().clone();
		
		avocadoCupcake.setProductName("Avocado Cupcake");
		avocadoCupcake.setProductPrice(500.00);
		avocadoCupcake.setImgPath("images/products/avocado-biscuit-cupcake.PNG");
		avocadoCupcake.setAvailibility(true);
		avocadoCupcake.setProductInfo("Avocado and coconut oil give these simple and "
				+ "delicious Avocado Cupcakes with Whipped Avocado "
				+ "Cream a healthier upgrade – making them perfect for "
				+ "a celebratory dessert AND breakfast – or maybe that’s just for me?!");
		
					
		insertProducts(avocadoCupcake.getProductName(), avocadoCupcake.getImgPath(), 
				avocadoCupcake.getProductInfo(), avocadoCupcake.getProductPrice(), 
				avocadoCupcake.getAvailibility(), cupcakeProductType.getProductTypeId());
		
			
//		//INSERTING CHURRO STICKS TO DATABASE
		Product churroSticks = new ChurroSticks().clone();
		churroSticks.setProductName("Churro Sticks");
		churroSticks.setProductPrice(50.00);
		churroSticks.setImgPath("images/products/churro-sticks.jpg");
		churroSticks.setAvailibility(false);
		churroSticks.setProductInfo("A pastry originating in Spain, that is basically "
				+ "fried dough extruded through a fluted tube, resulting in a star "
				+ "shaped stick that is cut to a desired length. ");
		
		insertProducts(churroSticks.getProductName(), churroSticks.getImgPath(), 
				churroSticks.getProductInfo(), churroSticks.getProductPrice(), 
				churroSticks.getAvailibility(), pastryProductType.getProductTypeId());

		
//		//INSERTING CANDY CANE TO DATABASE
		Product candyCane = new CandyCane().clone();
		candyCane.setProductName("Candy Cane");
		candyCane.setProductPrice(500.00);
		candyCane.setImgPath("images/products/candy-cane.jpg");
		candyCane.setAvailibility(false);
		candyCane.setProductInfo( "A candy cane is a cane-shaped stick candy often "
				+ "associated with Christmastide, as well as Saint Nicholas Day. "
				+ "It is traditionally white with red stripes and flavored with peppermint, "
				+ "but they also come in a variety of other flavors and colors.");
		
		insertProducts(candyCane.getProductName(), candyCane.getImgPath(), 
				candyCane.getProductInfo(), candyCane.getProductPrice(), 
				candyCane.getAvailibility(), candyProductType.getProductTypeId());
		
//		//INSERTING VALENTINE CUPCAKE TO DATABASE
		Product valentineCupcake = new ValentineCupcake().clone();
		valentineCupcake.setProductName("Valentine Cupcake");
		valentineCupcake.setProductPrice(123.00);
		valentineCupcake.setImgPath("images/products/valentine-cupcake.jpg");
		valentineCupcake.setAvailibility(false);
		valentineCupcake.setProductInfo("Valentine themed Cupcake for loved ones!");
				
		insertProducts(valentineCupcake.getProductName(), valentineCupcake.getImgPath(), 
				valentineCupcake.getProductInfo(), valentineCupcake.getProductPrice(), 
				valentineCupcake.getAvailibility(), cupcakeProductType.getProductTypeId());
		
		
		//INSERTING JELLY BEANS TO DATABASE
		Product jellyBeans = new JellyBeans().clone();
		jellyBeans.setProductName("Jelly Beans");
		jellyBeans.setProductPrice(105.00);
		jellyBeans.setImgPath("images/products/jelly-beans.jpg");
		jellyBeans.setAvailibility(true);
		jellyBeans.setProductInfo("Jelly beans are small bean-shaped sugar candies with soft candy shells and thick gel interiors "
				+ ". The confection is primarily made of "
				+ "sugar and sold in a wide variety of colors and flavors.");
						
		insertProducts(jellyBeans.getProductName(), jellyBeans.getImgPath(), 
				jellyBeans.getProductInfo(), jellyBeans.getProductPrice(), 
				jellyBeans.getAvailibility(), candyProductType.getProductTypeId());
		
		//INSERTING Puffed Danish Pastry TO DATABASE
		Product puffedDanishPastry = new PuffedDanishPastry().clone();
		puffedDanishPastry.setProductName("Puffed Pastry Cream Bread");
		puffedDanishPastry.setProductPrice(105.00);
		puffedDanishPastry.setImgPath("images/products/puff-sweetflatbread-pastry.jpg");
		puffedDanishPastry.setAvailibility(true);
		puffedDanishPastry.setProductInfo("These cream cheese danish are a light and flaky pastry topped "
				+ "with a sweet cream cheese filling and fruit."
				+ " An easy yet elegant breakfast option!");
						
		insertProducts(puffedDanishPastry.getProductName(), puffedDanishPastry.getImgPath(), 
				puffedDanishPastry.getProductInfo(), puffedDanishPastry.getProductPrice(), 
				puffedDanishPastry.getAvailibility(), pastryProductType.getProductTypeId());
		
		
		//INSERTING STRAWBERRY CUPCAKE TO DATABASE
		Product strawberryCupcake = new StrawberryCupcake().clone();
		strawberryCupcake.setProductName("Strawberry Cupcake");
		strawberryCupcake.setProductPrice(115.00);
		strawberryCupcake.setImgPath("images/products/strawberry-cupcake.jpg");
		strawberryCupcake.setAvailibility(true);
		strawberryCupcake.setProductInfo("Strawberry Cupcake for everyone!");
						
		insertProducts(strawberryCupcake.getProductName(), strawberryCupcake.getImgPath(), 
				strawberryCupcake.getProductInfo(), strawberryCupcake.getProductPrice(), 
				strawberryCupcake.getAvailibility(), pastryProductType.getProductTypeId());
		
//		//INSERTING ENGLISH SAUSAGE TO DATABASE
		Product englishSausage = new EnglishSausage().clone();
		englishSausage.setProductName("English Sausage");
		englishSausage.setProductPrice(100.00);
		englishSausage.setImgPath( "images/products/English-Sausage.jpg");
		englishSausage.setAvailibility(true);
		englishSausage.setProductInfo( "Savory pork sausage wrapped in puff pastry, "
				+ "baked to golden brown perfection. This sausage rolls recipe is the perfect"
				+ "make-ahead appetizer, sausage rolls are delicious served hot or cold. ");
						
		insertProducts(englishSausage.getProductName(), englishSausage.getImgPath(), 
				englishSausage.getProductInfo(), englishSausage.getProductPrice(), 
				englishSausage.getAvailibility(), pastryProductType.getProductTypeId());
		
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
	
}
