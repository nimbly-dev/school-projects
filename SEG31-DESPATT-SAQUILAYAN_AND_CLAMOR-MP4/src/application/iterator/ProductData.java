package application.iterator;

import java.util.ArrayList;
import java.util.Iterator;

import product.model.DisplayProductBean;
import product.model.Product;
import product.model.AvocadoCupcake.AvocadoCupcake;
import product.model.CandyCane.CandyCane;
import product.model.ChurroSticks.ChurroSticks;
import product.model.EnglishSausage.EnglishSausage;
import product.model.JellyBeans.JellyBeans;
import product.model.PuffedDanishPastry.PuffedDanishPastry;
import product.model.StrawberryCupcake.StrawberryCupcake;
import product.model.ValentineCupcake.ValentineCupcake;
import productType.model.Candy.Candy;
import productType.model.Cupcake.Cupcake;
import productType.model.Pastry.Pastry;

public class ProductData implements ProductIterator{
	
	ArrayList<DisplayProductBean> productData;
	
	public void addProduct(String productName,String imgPath,String productInfo,
			double productPrice,int quantity,int productTypeID) {
		DisplayProductBean product = new DisplayProductBean(productName,imgPath,productInfo,productPrice,quantity,productTypeID);
		productData.add(product);
	}
	
	public ProductData() {
		productData = new ArrayList<DisplayProductBean>();
		
		//Declaration of Product and ProductType Class
		Candy candyProductType = new Candy().clone();
		Cupcake cupcakeProductType = new Cupcake().clone();
		Pastry pastryProductType = new Pastry().clone();
		
		Product avocadoCupcake = new AvocadoCupcake().clone();
		Product churroSticks = new ChurroSticks().clone();
		Product candyCane = new CandyCane().clone();
		Product valentineCupcake = new ValentineCupcake().clone();
		Product jellyBeans = new JellyBeans().clone();
		Product puffedDanishPastry = new PuffedDanishPastry().clone();
		Product strawberryCupcake = new StrawberryCupcake().clone();
		Product englishSausage = new EnglishSausage().clone();
		
		addProduct(avocadoCupcake.productName(), avocadoCupcake.imgPath(), avocadoCupcake.productInfo(), 
				avocadoCupcake.productPrice(), avocadoCupcake.quantity(), cupcakeProductType.productTypeId());

		addProduct(churroSticks.productName(), churroSticks.imgPath(), churroSticks.productInfo(), 
				churroSticks.productPrice(), churroSticks.quantity(), pastryProductType.productTypeId());
		
		addProduct(candyCane.productName(), candyCane.imgPath(), candyCane.productInfo(), 
				candyCane.productPrice(), candyCane.quantity(), candyProductType.productTypeId());
		
		addProduct(valentineCupcake.productName(), valentineCupcake.imgPath(), valentineCupcake.productInfo(), 
				valentineCupcake.productPrice(), valentineCupcake.quantity(), cupcakeProductType.productTypeId());
		
		addProduct(jellyBeans.productName(), jellyBeans.imgPath(), jellyBeans.productInfo(), 
				jellyBeans.productPrice(), jellyBeans.quantity(), candyProductType.productTypeId());
		
		addProduct(puffedDanishPastry.productName(), puffedDanishPastry.imgPath(), puffedDanishPastry.productInfo(), 
				puffedDanishPastry.productPrice(), puffedDanishPastry.quantity(), pastryProductType.productTypeId());
		
		addProduct(strawberryCupcake.productName(), strawberryCupcake.imgPath(), strawberryCupcake.productInfo(), 
				strawberryCupcake.productPrice(), strawberryCupcake.quantity(), pastryProductType.productTypeId());
		
		addProduct(englishSausage.productName(), englishSausage.imgPath(), englishSausage.productInfo(), 
				englishSausage.productPrice(), englishSausage.quantity(), pastryProductType.productTypeId());
	}
	
	//GOOD: the new way
	public Iterator createIterator() {
		return productData.iterator();
	}
	
	
}
