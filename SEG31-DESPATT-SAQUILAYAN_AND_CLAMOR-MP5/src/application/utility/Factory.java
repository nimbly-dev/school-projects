package application.utility;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


import application.strings.ProductNames;
import product.exceptions.ProductNotFoundException;

import product.model.Product;

import productType.model.ProductType;


public class Factory implements AbstractFactory, ProductNames{
	
	private static final Map<String, Connection> ConnectionPrototype = new HashMap<>();
	
	//REMVOED DUE TO MAX CONNECTION POOL ISSUE
//	static {
//		ConnectionPrototype.put(avocadoCupcake, SingletonDB.getConnection());
//		ConnectionPrototype.put(candyCane, SingletonDB.getConnection());
//		ConnectionPrototype.put(churroSticks, SingletonDB.getConnection());
//		ConnectionPrototype.put(englishSausage, SingletonDB.getConnection());
//		ConnectionPrototype.put(jellyBeans, SingletonDB.getConnection());
//		ConnectionPrototype.put(PuffedDanishPastry, SingletonDB.getConnection());
//		ConnectionPrototype.put(valentineCupcake, SingletonDB.getConnection());
//		ConnectionPrototype.put(strawberryCupcake,SingletonDB.getConnection());
//	}
	
	//IMPLEMENTED SWITCH CASE CONNECTION ASSIGNING OBJECT TO FIX MAX CONNECTION POOL ISSUE
	public Connection getConnectionObject(String searchInput)throws ProductNotFoundException{
			switch(searchInput) {
				case avocadoCupcake:
					ConnectionPrototype.put(avocadoCupcake, SingletonDB.getConnection());
					return ConnectionPrototype.get(avocadoCupcake);
				case candyCane:
					ConnectionPrototype.put(candyCane, SingletonDB.getConnection());
					return ConnectionPrototype.get(candyCane);
				case churroSticks:
					ConnectionPrototype.put(churroSticks, SingletonDB.getConnection());
					return ConnectionPrototype.get(churroSticks);
				case englishSausage:
					ConnectionPrototype.put(englishSausage, SingletonDB.getConnection());
					return ConnectionPrototype.get(englishSausage);
				case jellyBeans:
					ConnectionPrototype.put(jellyBeans, SingletonDB.getConnection());
					return ConnectionPrototype.get(jellyBeans);
				case PuffedDanishPastry:
					ConnectionPrototype.put(PuffedDanishPastry, SingletonDB.getConnection());
					return ConnectionPrototype.get(PuffedDanishPastry);
				case valentineCupcake:
					ConnectionPrototype.put(valentineCupcake, SingletonDB.getConnection());
					return ConnectionPrototype.get(valentineCupcake);
				case strawberryCupcake:
					ConnectionPrototype.put(strawberryCupcake,SingletonDB.getConnection());
					return ConnectionPrototype.get(strawberryCupcake);
				default:
					throw new ProductNotFoundException("Product Not Found");
			}
		}
	
//    public static Connection getConnectionObject(String searchInput) {
//    	try {
//            return ConnectionPrototype.get(searchInput);
//        } catch (NullPointerException ex) {
//        	System.out.println("CONNECTION OBJECt");
//            return null;
//        }
//    }

	@Deprecated
	@Override
	public ProductType getProductTypeName(String productInput) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
	