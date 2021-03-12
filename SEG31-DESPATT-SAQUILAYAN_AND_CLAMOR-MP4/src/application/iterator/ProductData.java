package application.iterator;

import java.util.ArrayList;

import product.model.DisplayProductBean;

public class ProductData {
	
	ArrayList<DisplayProductBean> productData;
	
	public void addProduct(String productName,String imgPath,String productInfo,
			double productPrice,int quantity,int productTypeID) {
		DisplayProductBean product = new DisplayProductBean(productName,imgPath,productInfo,productPrice,quantity,productTypeID);
		productData.add(product);
	}
	
	public ProductData() {
		productData = new ArrayList<DisplayProductBean>();
		
		
	}
	
	
}
