package product.builder;

import java.util.ArrayList;
import java.util.List;

import application.utility.SingletonDB;
import product.model.ProductItem;

public class Order {
	private List<ProductItem> items = new ArrayList<ProductItem>();	
	
	public void addItem(ProductItem item) {
		items.add(item);
	}
	
	public double getProductCosts() {
		double cost = 0;
		
		for (ProductItem item : items) {
			cost += item.productPrice();
		}		
		
		return cost;
	}
	
	public int getProductCount() {
		int count = 0;
		
		for (ProductItem item : items) {
			count += item.quantity();
		}	
		
		return count;
	}
	
	public String getProductNames() {
		String productName = "";
		
		for (ProductItem item : items) {
			productName += item.productName();
		}	
		
		return productName;
	}
	
	public String getProductImgPaths() {
		String productImgPath = "";
		
		for (ProductItem item : items) {
			productImgPath += item.imgPath();
		}	
		
		return productImgPath;
	}
	
	public void insertBundledOrderToDB() {
		//Default is 1 needs to be fixed
		for (ProductItem item : items) {
			SingletonDB.insertCartProduct(item.productName(), item.productPrice() , item.imgPath(), item.quantity(), 1);
	    }		
	}
	
	
	
}
