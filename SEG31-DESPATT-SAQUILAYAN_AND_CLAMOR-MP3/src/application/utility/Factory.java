package application.utility;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


import application.strings.ProductNames;
import productType.model.DisplayProductTypeBean;
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

	public static Connection getConnectionObject(String searchInput){
		switch(searchInput) {
			case avocadoCupcake:
				System.out.println("CONNECTION (AVOCADO CUPCAKE): " +  ConnectionPrototype.get(avocadoCupcake));
				return ConnectionPrototype.get(avocadoCupcake);
			case candyCane:
				System.out.println("CONNECTION (CANDY CANE): " +  ConnectionPrototype.get(candyCane));
				return ConnectionPrototype.get(candyCane);
			case churroSticks:
				System.out.println("CONNECTION (CHURRO STICKS): " +  ConnectionPrototype.get(churroSticks));
				return ConnectionPrototype.get(churroSticks);	
			case "English Sausage":
				System.out.println("CONNECTION (ENGLISH SAUSAGE): " +  ConnectionPrototype.get(englishSausage));
				return ConnectionPrototype.get(englishSausage);
			case "Jelly Beans":
				System.out.println("CONNECTION (JELLY BEANS): " +  ConnectionPrototype.get(jellyBeans));
				return ConnectionPrototype.get(jellyBeans);
			case "Puffed Pastry Cream Bread":
				System.out.println("CONNECTION (PUFFED PASTRY CREAM BREAD): " +  ConnectionPrototype.get(PuffedDanishPastry));
				return ConnectionPrototype.get(PuffedDanishPastry);
			case "Valentine Cupcake":
				System.out.println("CONNECTION (VALENTINE CUPCAKE): " +  ConnectionPrototype.get(valentineCupcake));
				return ConnectionPrototype.get(valentineCupcake);
			case "Strawberry Cupcake":
				System.out.println("CONNECTION (VALENTINE CUPCAKE): " +  ConnectionPrototype.get(valentineCupcake));
				return ConnectionPrototype.get(valentineCupcake);
			default:
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
	