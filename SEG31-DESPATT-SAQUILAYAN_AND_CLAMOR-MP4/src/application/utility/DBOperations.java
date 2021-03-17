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
			+ "`quantity` int NOT NULL,"
			+ "PRIMARY KEY (`productID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	final static String CREATE_PRODUCT_TYPES_TABLE = "CREATE TABLE IF NOT EXISTS `product_types`"
			+ "(`productTypeID` int(50) NOT NULL AUTO_INCREMENT,"
			+ "`productTypeName` varchar(255) NOT NULL,"
			+ "`wrapperName` varchar(255) NOT NULL,"
			+ "PRIMARY KEY (`productTypeID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	final static String CREATE_CART_TABLE = "CREATE TABLE IF NOT EXISTS `cart_items`"
			+ "(`cartItemID` int(50) NOT NULL AUTO_INCREMENT,"
			+ "`orderID` int(50) NOT NULL,"
			+ "`productName` varchar(150) NOT NULL,"
			+ "`productPrice` double NOT NULL,"
			+ "`productImgPath` varchar(150) NOT NULL,"
			+ "`productCount` int NOT NULL,"
			+ "PRIMARY KEY (`cartItemID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	final static String CREATE_CART_ORDER = "CREATE TABLE IF NOT EXISTS `cart_order`"
			+ "(`orderID` int(50) NOT NULL AUTO_INCREMENT,"
			+ "`isBoxed` tinyint(1),"
			+ "PRIMARY KEY (`orderID`) )"
			+ "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	
	final static String ADD_FOREIGN_KEY_PRODUCT_TYPE_ID = "ALTER TABLE `products` ADD CONSTRAINT `products_ibfk_1` "
			+ "FOREIGN KEY (`productTypeID`) "
			+ "REFERENCES `product_types` (`productTypeID`) ON UPDATE CASCADE";
	
	final static String ADD_FOREIGN_KEY_ORDER_ID = "ALTER TABLE `cart_items` ADD CONSTRAINT `cart_items_ibfk_1` "
			+ "FOREIGN KEY (`orderID`) "
			+ "REFERENCES `cart_order` (`orderID`) ON UPDATE CASCADE";
	
	//INSERT OPERATIONS
	final static String INSERT_PRODUCTS = "INSERT INTO `products`"
			+ "(productTypeID,productName,imgPath,productInfo,productPrice,quantity)"
			+ "VALUES (?,?,?,?,?,?)";
	
	final static String INSERT_PRODUCT_TYPES = "INSERT INTO `product_types`"
			+ "(productTypeID,productTypeName,wrapperName)"
			+ "VALUES (?,?,?)";
	
	final static String INSERT_CART_ITEMS = "INSERT INTO `cart_items`"
			+"(productName,productPrice,productImgPath,productCount,orderID)"
			+"VALUES (?,?,?,?,?)";
	
	//GENERATE OPERATIONS
	final static String GENERATE_ORDER = "INSERT INTO `cart_order`"
			+"(orderID,isBoxed)"
			+"VALUES (?,?)";
	
	//UPDATE OPERATIONS
	final static String DEDUCT_QUANTITY = "UPDATE products SET quantity = ? WHERE productName = ?";
	
	//DISPLAY OPERATIONS
	final static String DISPLAY_ALL_PRODUCTS = "SELECT * FROM `products` ";
	
	final static String DISPLAY_CANDY = "SELECT * FROM `products` WHERE productTypeID=1";
	
	final static String DISPLAY_CUPCAKES = "SELECT * FROM `products` WHERE productTypeID=2";
	
	final static String DISPLAY_PASTRY = "SELECT * FROM `products` WHERE productTypeID=3";
	
	final static String DISPLAY_CART = "SELECT * FROM `cart_items`";
	
	final static String DISPLAY_CART_ITEMS = "SELECT * FROM `cart_items`";
	
	//RETRIEVE OPERATIONS
	final static String RETRIEVE_PRODUCT = "SELECT * FROM `products`" 
			+ "WHERE `productName` = ?";
	
	final static String RETRIEVE_PRODUCT_TYPE = "SELECT * FROM `product_types`"
			+ " WHERE `productTypeID` = ?";
	
	final static String RETRIEVE_PRODUCT_QUANTITY = "SELECT `quantity` FROM `products` "
			+ "WHERE `productName` = ?";
	
	final static String RETRIEVE_CART_PRODUCT_QUANTITY = "SELECT `productCount` FROM `cart_items` "
			+ "WHERE `productName` = ?";
		
	//DATA DISPOSAL OPERATIONS
	final static String CART_DATA_DISPOSAL = "TRUNCATE TABLE `cart_items`";
	
	final static String ORDER_GENERATED_DISPOSAL = "DELETE FROM `cart_order` WHERE orderID=?";
	
}
