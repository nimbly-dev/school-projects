package product.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import product.utility.SingletonDB;

public class InitializeConfig implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        // Do stuff during webapp's startup.
    	
    	System.out.println("Initializing Sweetx Data.....");
    	
    	//CREATE TABLE AND ADD CONSTRAINTS
    	SingletonDB.initializeTablesAndConstraints();
    	System.out.println("Table and Constraints created");
    	
    	//POPULATE DB
    	SingletonDB.populateDb();
    	System.out.println("Database Populated");
    	
    	System.out.println("Sweetx Data has been loaded");

    }
    
    
    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    	SingletonDB.disposeDb();
    }
}
