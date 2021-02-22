package application.utility;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


import application.strings.ProductNames;
import productType.model.ProductType;


public class Factory implements AbstractFactory, ProductNames{
	
	private static final Map<String, Connection> ConnectionPrototype = new HashMap<>();
	
	//eager loading/instantiation
	static {
		ConnectionPrototype.put(avocadoCupcake, SingletonDB.getConnection());
		ConnectionPrototype.put(candyCane, SingletonDB.getConnection());
		ConnectionPrototype.put(churroSticks, SingletonDB.getConnection());
		ConnectionPrototype.put(englishSausage, SingletonDB.getConnection());
		ConnectionPrototype.put(jellyBeans, SingletonDB.getConnection());
		ConnectionPrototype.put(PuffedDanishPastry, SingletonDB.getConnection());
		ConnectionPrototype.put(valentineCupcake, SingletonDB.getConnection());
		ConnectionPrototype.put(strawberryCupcake,SingletonDB.getConnection());
	}
	
    public static Connection getConnectionObject(String searchInput) {
    	try {
            return ConnectionPrototype.get(searchInput);
        } catch (NullPointerException ex) {
        	System.out.println("CONNECTION OBJECt");
            return null;
        }
    }

	@Deprecated
	@Override
	public ProductType getProductTypeName(String productInput) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
	