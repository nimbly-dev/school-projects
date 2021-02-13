package product.utility;

import product.model.productType.*;

import java.util.HashMap;
import java.util.Map;

import product.model.Product;
import product.strings.*;

public class ProductTypeFactory implements AbstractFactory, ProductName{

	private static final Map<String, ProductClone> prototypes = new HashMap<>();
	
	static {
		prototypes.put(avocadoCupcake, new Cupcake());
	}
	
	public static ProductClone getProductType(String productInput) {
		System.out.println("Inside get Product");
		try {
			return prototypes.get(productInput).clone();
		}catch(NullPointerException npe) {
			System.out.println("Prototype with name: " + productInput +" ,does'nt exist");
			return null;
		}
	}
	
	@Override
	public ProductType getProductTypeName(String productInput) {
		ProductType productType = null;
		
		//Product Type is Cupcake
		if(productInput.equalsIgnoreCase(valentineCupcake) ||
		   productInput.equalsIgnoreCase(strawberryCupcake) ||
		   productInput.equalsIgnoreCase(avocadoCupcake)) {
			
		   productType = new Cupcake();
				
		}
		//Product Type is Pastry
		else if(productInput.equalsIgnoreCase(englishSausage) ||
				productInput.equalsIgnoreCase(churroSticks) ||
				productInput.equalsIgnoreCase(PuffedDanishPastry) 
				){
			
		   productType = new Pastry();
		}
		//Product Type is Candy
		else if(productInput.equalsIgnoreCase(candyCane) || 
				productInput.equalsIgnoreCase(jellyBeans)) {
			productType = new Candy();
		}

		return productType;
	}
	
	
//	UNUSED METHODS
	@Deprecated
	public Product searchProduct(String searchInput) {
		return null;
	}

}
