package product.utility;

import java.util.HashMap;
import java.util.Map;

import product.exceptions.ProductNotFoundException;
import product.model.*;
import product.model.productType.ProductType;


public class Factory implements AbstractFactory{
	
	private static final Map<String, ProductClone> prototypes = new HashMap<>();
	
	//eager loading/instantiation
	static {
		System.out.println("Inside Factory Static");
		prototypes.put("AVOCADO CUPCAKE", new AvocadoCupcake());
		prototypes.put("CANDY CANE", new CandyCane());
		prototypes.put("CHURRO STICKS", new ChurroSticks());
		prototypes.put("ENGLISH SAUSAGE", new EnglishSausage());
		prototypes.put("JELLY BEANS", new JellyBeans());
		prototypes.put("PUFFED DANISH FRUIT PASTRY", new PuffedDanishPastry());
		prototypes.put("VALENTINE CUPCAKE", new ValentineCupcake());
		prototypes.put("STRAWBERRY CUPCAKE", new StrawberryCupcake());
	}


	public static ProductClone getProduct(String searchInput) {
		try {
			return prototypes.get(searchInput).clone();
		}catch(NullPointerException npe) {
			System.out.println("Prototype with name: " + searchInput +" ,does'nt exist");
			return null;
		}
	}
	

	@Override
	public ProductType getProductTypeName(String productInput) {
		return null;
	}


}
	