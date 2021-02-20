package application.utility;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.DenyAll;

import com.sun.org.glassfish.gmbal.Description;

import application.strings.*;
import product.model.Product;
import productType.model.*;
import productType.model.Candy.Candy;
import productType.model.Cupcake.Cupcake;
import productType.model.Pastry.Pastry;

public class ProductTypeFactory implements AbstractFactory, ProductNames{

	
	public ProductType getProductTypeName(String productInput) {
		ProductType productType = null;
		
		//Product Type is Cupcake
		if(productInput.equalsIgnoreCase(valentineCupcake) ||
		   productInput.equalsIgnoreCase(strawberryCupcake) ||
		   productInput.equalsIgnoreCase(avocadoCupcake)) {
			System.out.println("FOUND PRODUCT TYPE");
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

	@Deprecated
	public Connection getConnectionObject(String searchInput) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
