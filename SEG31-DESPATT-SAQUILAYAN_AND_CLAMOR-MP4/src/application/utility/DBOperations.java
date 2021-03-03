package application.utility;

public interface DBOperations {
	
	//DB INITIALIZER OPERATIONS
	final static String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS `products` "
			+ "(`productID` int(50) NOT NULL AUTO_INCREMENT,"
			+ "`productTypeID` int(50) NOT NULL,"
			+ "`productName` varchar(150) NOT NULL,"
			+ "`imgPath` varchar(500) NOT NULL,"
			+ "`productInfo` varchar(300) NOT NULL,"
			+ "`productPrice` double NOT NULL, "
			+ "`isAvailable` tinyint(1) NOT NULL,"
			+ "PRIMARY KEY (`productID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	final static String CREATE_PRODUCT_TYPES_TABLE = "CREATE TABLE IF NOT EXISTS `product_types`"
			+ "(`productTypeID` int(50) NOT NULL AUTO_INCREMENT,"
			+ "`productTypeName` varchar(255) NOT NULL,"
			+ "PRIMARY KEY (`productTypeID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	final static String CREATE_CART_TABLE = "CREATE TABLE IF NOT EXISTS `cart_items`"
			+ "(`cartItemID` int(50) NOT NULL AUTO_INCREMENT,"
			+ "`productName` varchar(150) NOT NULL,"
			+ "`productPrice` varchar(150) NOT NULL,"
			+ "`productImgPath` varchar(150) NOT NULL,"
			+ "`productCount` varchar(150) NOT NULL,"
			+ "PRIMARY KEY (`cartItemID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	final static String ADD_FOREIGN_KEY_PRODUCT_TYPE_ID = "ALTER TABLE `products` ADD CONSTRAINT `products_ibfk_1` "
			+ "FOREIGN KEY (`productTypeID`) "
			+ "REFERENCES `product_types` (`productTypeID`) ON UPDATE CASCADE";
	
	//INSERT OPERATIONS
	final static String INSERT_PRODUCTS = "INSERT INTO `products`"
			+ "(productTypeID,productName,imgPath,productInfo,productPrice,isAvailable)"
			+ "VALUES (?,?,?,?,?,?)";
	
	final static String INSERT_PRODUCT_TYPES = "INSERT INTO `product_types`"
			+ "(productTypeID,productTypeName)"
			+ "VALUES (?,?)";
	
	final static String INSERT_CART_ITEMS = "INSERT INTO `cart_items`"
			+"(productName,productPrice,productImgPath,productCount)"
			+"VALUES (?,?,?,?)";
	
	//DISPLAY OPERATIONS
	final static String DISPLAY_ALL_PRODUCTS = "SELECT * FROM `products` ";
	
	final static String DISPLAY_CANDY = "SELECT * FROM `products` WHERE productTypeID=1";
	
	final static String DISPLAY_CUPCAKES = "SELECT * FROM `products` WHERE productTypeID=2";
	
	final static String DISPLAY_PASTRY = "SELECT * FROM `products` WHERE productTypeID=3";
	
	final static String DISPLAY_CART = "SELECT * FROM `cart_items`";
	
	final static String RETRIEVE_PRODUCT = "SELECT * FROM `products`" 
			+ "WHERE `productName` = ?";
	
	final static String RETRIEVE_PRODUCT_TYPE = "SELECT * FROM `product_types`"
			+ " WHERE `productTypeID` = ?";
	
	//DATA DISPOSAL OPERATIONS
	final static String CART_DATA_DISPOSAL = "TRUNCATE TABLE `cart_items`";
}
