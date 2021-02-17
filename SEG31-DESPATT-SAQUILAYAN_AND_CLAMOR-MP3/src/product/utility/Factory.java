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
		System.out.println("Inside get Product");
		try {
			return prototypes.get(searchInput).clone();
		}catch(NullPointerException npe) {
			System.out.println("Prototype with name: " + searchInput +" ,does'nt exist");
			return null;
		}
	}
	
//	@Override
//	public Product searchProduct(String searchInput)throws ProductNotFoundException{
//		
//		switch(searchInput) {
//			case "AVOCADO CUPCAKE":
//				return(new AvocadoCupcake());
//			case "CANDY CANE":
//				return(new CandyCane());
//			case "CHURRO STICKS":
//				return(new ChurroSticks());
//			case "ENGLISH SAUSAGE":
//				return(new EnglishSausage());
//			case "JELLY BEANS":
//				return(new JellyBeans());
//			case "PUFFED DANISH FRUIT PASTRY":
//				return(new PuffedDanishPastry());
//			case "VALENTINE CUPCAKE":
//				return(new ValentineCupcake());
//			case "STRAWBERRY CUPCAKE":
//				return(new StrawberryCupcake());
//			default:
//				throw new ProductNotFoundException("Product Not Found");
//		}
//	}

	@Override
	public ProductType getProductTypeName(String productInput) {
		return null;
	}


}
	