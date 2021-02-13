package product.view;

import product.model.*;

import product.model.productType.*;

public class DisplayProducts {
	public static void viewProductDetails(Product product) {
		if(product instanceof AvocadoCupcake) {
			AvocadoCupcake avocadoCupcake = (AvocadoCupcake) product;
			avocadoCupcake.setProductName();
			avocadoCupcake.setProductPrice();
			avocadoCupcake.setImgPath();
			avocadoCupcake.setAvailibility();
			avocadoCupcake.setProductInfo();
			
			
			Cupcake productType = (Cupcake) product.getProductType();
			System.out.println(productType);
			productType.setProductTypeName();
			
		}else if(product instanceof CandyCane) {
			CandyCane candyCane = (CandyCane) product;
			candyCane.setProductName();
			candyCane.setProductPrice();
			candyCane.setImgPath();
			candyCane.setAvailibility();
			candyCane.setProductInfo();
			
			Candy productType = (Candy) product.getProductType();
			productType.setProductTypeName();
			
		}else if(product instanceof ChurroSticks) {
			ChurroSticks churroSticks = (ChurroSticks) product;
			churroSticks.setProductName();
			churroSticks.setProductPrice();
			churroSticks.setImgPath();
			churroSticks.setAvailibility();
			churroSticks.setProductInfo();
			
			Pastry productType = (Pastry) product.getProductType();
			productType.setProductTypeName();
			
		}else if(product instanceof EnglishSausage) {
			EnglishSausage englishSausage = (EnglishSausage) product;
			englishSausage.setProductName();
			englishSausage.setProductPrice();
			englishSausage.setImgPath();
			englishSausage.setAvailibility();
			englishSausage.setProductInfo();
			
			Pastry productType = (Pastry) product.getProductType();
			productType.setProductTypeName();
			
		}else if(product instanceof JellyBeans) {
			JellyBeans jellyBeans = (JellyBeans) product;
			jellyBeans.setProductName();
			jellyBeans.setProductPrice();
			jellyBeans.setImgPath();
			jellyBeans.setAvailibility();
			jellyBeans.setProductInfo();
			
			Candy productType = (Candy) product.getProductType();
			productType.setProductTypeName();
			
		}else if(product instanceof PuffedDanishPastry) {
			PuffedDanishPastry puffedDanishPastry = (PuffedDanishPastry) product;
			puffedDanishPastry.setProductName();
			puffedDanishPastry.setProductPrice();
			puffedDanishPastry.setImgPath();
			puffedDanishPastry.setAvailibility();
			puffedDanishPastry.setProductInfo();
			
			Candy productType = (Candy) product.getProductType();
			productType.setProductTypeName();
			
		}else if(product instanceof ValentineCupcake) {
			ValentineCupcake valentineCupcake = (ValentineCupcake) product;
			valentineCupcake.setProductName();
			valentineCupcake.setProductPrice();
			valentineCupcake.setImgPath();
			valentineCupcake.setAvailibility();
			valentineCupcake.setProductInfo();
			
			Cupcake productType = (Cupcake) product.getProductType();
			productType.setProductTypeName();
			
		}else if(product instanceof StrawberryCupcake) {
			StrawberryCupcake strawberryCupcake = (StrawberryCupcake) product;
			strawberryCupcake.setProductName();
			strawberryCupcake.setProductPrice();
			strawberryCupcake.setImgPath();
			strawberryCupcake.setAvailibility();
			strawberryCupcake.setProductInfo();
			
			Cupcake productType = (Cupcake) product.getProductType();
			productType.setProductTypeName();
			
		}
	}
}
