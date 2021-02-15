package product.utility;

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

import product.model.*;
import product.model.productType.*;
import product.view.DisplayProductBean;
import product.view.DisplayProductTypeBean;

public class SingletonDB {
	
	//this is defaulted to null
	private static Connection connection; 
	
	private final static String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS `products` "
			+ "(`productID` int(50) NOT NULL AUTO_INCREMENT,"
			+ "`productTypeID` int(50) NOT NULL,"
			+ "`productName` varchar(150) NOT NULL,"
			+ "`imgPath` varchar(500) NOT NULL,"
			+ "`productInfo` varchar(300) NOT NULL,"
			+ "`productPrice` double NOT NULL, "
			+ "`isAvailable` tinyint(1) NOT NULL,"
			+ "PRIMARY KEY (`productID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	private final static String CREATE_PRODUCT_TYPES_TABLE = "CREATE TABLE IF NOT EXISTS `product_types`"
			+ "(`productTypeID` int(50) NOT NULL AUTO_INCREMENT,"
			+ "`productTypeName` varchar(255) NOT NULL,"
			+ "PRIMARY KEY (`productTypeID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	
	private final static String ADD_FOREIGN_KEY_PRODUCT_TYPE_ID = "ALTER TABLE `products` ADD CONSTRAINT `products_ibfk_1` "
			+ "FOREIGN KEY (`productTypeID`) "
			+ "REFERENCES `product_types` (`productTypeID`) ON UPDATE CASCADE";
	
	private final static String INSERT_PRODUCTS = "INSERT INTO `products`"
			+ "(productTypeID,productName,imgPath,productInfo,productPrice,isAvailable)"
			+ "VALUES (?,?,?,?,?,?)";
	
	private final static String INSERT_PRODUCT_TYPES = "INSERT INTO `product_types`"
			+ "(productTypeID,productTypeName)"
			+ "VALUES (?,?)";
	
	private final static String DISPLAY_ALL_PRODUCTS = "SELECT * FROM `products` ";
	
	private final static String DISPLAY_CANDY = "SELECT * FROM `products` WHERE productTypeID=1";
	
	private final static String DISPLAY_CUPCAKES = "SELECT * FROM `products` WHERE productTypeID=2";
	
	private final static String DISPLAY_PASTRY = "SELECT * FROM `products` WHERE productTypeID=3";
	
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
		}catch (Exception npe) {
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
	
	//Calls data from the Database and creates an Array List
	public static List<DisplayProductBean> displayAllProducts(){
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
				
				product.setAvailable(rs.getBoolean("isAvailable"));;
				product.setImgPath(rs.getString("imgPath"));
				product.setProductId(rs.getInt("productID"));
				product.setProductInfo(rs.getString("productInfo"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getDouble("productPrice"));
				
			
				product.getProductType().setProductTypeId(rs.getInt("productTypeID"));
				
				
				products.add(product);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return products;
	}
	
	
	/**WORK IN PROGRESS*/
	//Sorts Products based on user input
	public static List<DisplayProductBean> sortProducts(String selectedTypeOfProduct){
		List<DisplayProductBean> products = new ArrayList<DisplayProductBean>();
		System.out.println("SELECTED IS: " + selectedTypeOfProduct);
		try {
			System.out.println("INSIDE TRY BLOCK");
			//Print Candy Products Only
			if(selectedTypeOfProduct.equalsIgnoreCase("Candy") == true) {
				System.out.println("Inside If candy");
				Connection conn = getConnection();
				System.out.println("CONNECTION LOADED");
				PreparedStatement st = conn.prepareStatement(DISPLAY_CANDY);
				System.out.println("STATEMENT PREPARED");
				ResultSet rs = st.executeQuery();
				System.out.println("EXECUTED QUERY");
				while(rs.next()) {
					System.out.println("PROCESSING PRODUCTS");
					DisplayProductBean product = new DisplayProductBean();
					//Initialize ProductType in order to avoid Null Pointer Exception
					DisplayProductTypeBean productType = new DisplayProductTypeBean();
					product.setProductType(productType);
					
					
					product.setAvailable(rs.getBoolean("isAvailable"));;
					product.setImgPath(rs.getString("imgPath"));
					product.setProductId(rs.getInt("productID"));
					product.setProductInfo(rs.getString("productInfo"));
					product.setProductName(rs.getString("productName"));
					product.setProductPrice(rs.getDouble("productPrice"));
					
					product.getProductType().setProductTypeId(rs.getInt("productTypeID"));
					
					System.out.println("An Product was added");
					products.add(product);
				}
				return products;
			}
			//Print Cupcake Products Only
			else if(selectedTypeOfProduct.equalsIgnoreCase("Cupcakes") == true) {
				System.out.println("Inside If cupcake");
				Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement(DISPLAY_CUPCAKES);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					DisplayProductBean product = new DisplayProductBean();
					//Initialize ProductType in order to avoid Null Pointer Exception
					DisplayProductTypeBean productType = new DisplayProductTypeBean();
					product.setProductType(productType);
					
					product.setAvailable(rs.getBoolean("isAvailable"));;
					product.setImgPath(rs.getString("imgPath"));
					product.setProductId(rs.getInt("productID"));
					product.setProductInfo(rs.getString("productInfo"));
					product.setProductName(rs.getString("productName"));
					product.setProductPrice(rs.getDouble("productPrice"));
					
					product.getProductType().setProductTypeId(rs.getInt("productTypeID"));
					
					products.add(product);
				}
				return products;
			}
			//Print Pastry Products Only
			else if(selectedTypeOfProduct.equals("Pastry")) {
				System.out.println("Inside If pastry");
				Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement(DISPLAY_PASTRY);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					DisplayProductBean product = new DisplayProductBean();
					//Initialize ProductType in order to avoid Null Pointer Exception
					DisplayProductTypeBean productType = new DisplayProductTypeBean();
					product.setProductType(productType);
					
					product.setAvailable(rs.getBoolean("isAvailable"));;
					product.setImgPath(rs.getString("imgPath"));
					product.setProductId(rs.getInt("productID"));
					product.setProductInfo(rs.getString("productInfo"));
					product.setProductName(rs.getString("productName"));
					product.setProductPrice(rs.getDouble("productPrice"));
					
					product.getProductType().setProductTypeId(rs.getInt("productTypeID"));
					
					products.add(product);
				}
				return products;
			}
			//Print All Products
			else if(selectedTypeOfProduct.equals("All")) {
				System.out.println("Inside If all");
				Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement(DISPLAY_ALL_PRODUCTS);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					DisplayProductBean product = new DisplayProductBean();
					//Initialize ProductType in order to avoid Null Pointer Exception
					DisplayProductTypeBean productType = new DisplayProductTypeBean();
					product.setProductType(productType);
					
					product.setAvailable(rs.getBoolean("isAvailable"));;
					product.setImgPath(rs.getString("imgPath"));
					product.setProductId(rs.getInt("productID"));
					product.setProductInfo(rs.getString("productInfo"));
					product.setProductName(rs.getString("productName"));
					product.setProductPrice(rs.getDouble("productPrice"));
					
					product.getProductType().setProductTypeId(rs.getInt("productTypeID"));
					
					products.add(product);
				}
				return products;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("FAILED TO SORT");
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
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//PopulateDB with pre-defined products and product types
	public static void populateDb(
			//Products Parameters
//			AvocadoCupcake avodcadoCupcake, CandyCane candyCane,
//			ChurroSticks churroSticks, EnglishSausage englishSausage,
//			JellyBeans jellyBeans, PuffedDanishPastry puffedDanishPastry,
//			ValentineCupcake valentineCupcake, StrawberryCupcake strawberryCupcake,
//			//Product Types Parameters
//			Cupcake cupcakeProductType, Candy candyProductType, Pastry pastryProductType
			) {
		
		
		/**
		CODE BLOCK TO POPULATEDB WITH PREDEFINED PRODUCT TYPES DATA
		 */
		//INSERTING CANDY DATATYPE TO DATABASE  -- ID 1
		Candy candyProductType = new Candy();
		candyProductType.setProductTypeName();
		candyProductType.setProductTypeId();
		
		insertProductTypes(candyProductType.getProductTypeId(), candyProductType.getProductTypeName());
		
		//INSERTING CUPCAKE DATATYPE TO DATABASE -- ID 2
		Cupcake cupcakeProductType = new Cupcake();
		cupcakeProductType.setProductTypeName();
		cupcakeProductType.setProductTypeId();
		
		insertProductTypes(cupcakeProductType.getProductTypeId() ,cupcakeProductType.getProductTypeName());
		
		//INSERTING PASTRY DATATYPE TO DATABASE -- ID 3
		Pastry pastryProductType = new Pastry();
		pastryProductType.setProductTypeName();
		pastryProductType.setProductTypeId();
		
		insertProductTypes(pastryProductType.getProductTypeId(), pastryProductType.getProductTypeName());
		
		/**END OF PRODUCT TYPE INSERTION*/
		
		
		/**
		CODE BLOCK TO POPULATEDB WITH PREDEFINED PRODUCTS DATA
		 */
		
		
		//INSERTING AVOCADO CUPCAKE TO DATABASE
		AvocadoCupcake avocadoCupcake = new AvocadoCupcake();
		avocadoCupcake.setProductName();
		avocadoCupcake.setProductPrice();
		avocadoCupcake.setImgPath();
		avocadoCupcake.setAvailibility();
		avocadoCupcake.setProductInfo();
		
					
		insertProducts(avocadoCupcake.getProductName(), avocadoCupcake.getImgPath(), 
				avocadoCupcake.getProductInfo(), avocadoCupcake.getProductPrice(), 
				avocadoCupcake.getAvailibility(), cupcakeProductType.getProductTypeId());
		
			
		//INSERTING CHURRO STICKS TO DATABASE
		ChurroSticks churroSticks = new ChurroSticks();
		churroSticks.setProductName();
		churroSticks.setProductPrice();
		churroSticks.setImgPath();
		churroSticks.setAvailibility();
		churroSticks.setProductInfo();
		
		insertProducts(churroSticks.getProductName(), churroSticks.getImgPath(), 
				churroSticks.getProductInfo(), churroSticks.getProductPrice(), 
				churroSticks.getAvailibility(), pastryProductType.getProductTypeId());
	
		
		//INSERTING CANDT CANE TO DATABASE
		CandyCane candyCane = new CandyCane();
		candyCane.setProductName();
		candyCane.setProductPrice();
		candyCane.setImgPath();
		candyCane.setAvailibility();
		candyCane.setProductInfo();
		
		insertProducts(candyCane.getProductName(), candyCane.getImgPath(), 
				candyCane.getProductInfo(), candyCane.getProductPrice(), 
				candyCane.getAvailibility(), candyProductType.getProductTypeId());
		
		/**END OF PRODUCT TYPE INSERTION*/
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
