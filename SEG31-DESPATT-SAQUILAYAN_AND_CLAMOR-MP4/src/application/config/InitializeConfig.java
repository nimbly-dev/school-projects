package application.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import application.utility.HelperMethods;
import application.utility.SingletonDB;

public class InitializeConfig implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
    	String userPath = event.getServletContext().getRealPath("/javascript/data/product-list.json");
    	
        // Do stuff during webapp's startup.
    	System.out.println("Initializing Sweetx Data.....");
    	
    	//CREATE TABLE AND ADD CONSTRAINTS
    	SingletonDB.initializeTablesAndConstraints();
    	System.out.println("Table and Constraints created");
    	
    	//POPULATE DB
    	SingletonDB.populateDb();
    	System.out.println("Database Populated");
    
    	//GENERATING CLIENT-SIDE JSON PRODUCT LIST
    	System.out.println("Now generating Product List JSON");
    	System.out.println("TEST USER PATH: " + userPath);
    	HelperMethods.productListToJson(userPath);
    	
    	System.out.println("Sweetx Data has been loaded");
    }
    
    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    	SingletonDB.disposeDb();
    }
}
