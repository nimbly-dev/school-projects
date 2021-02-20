package product.model.JellyBeans;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;

public class JellyBeans extends Product implements ProductPrototype{
	
	//Setters
	@Override
	public void setProductId(int productId) {
//		this.productId = 5;
		this.productId = productId;
	}
	
	@Override
	public void setProductName(String productName) {
//		this.productName = "Jelly Beans";
		this.productName = productName;
	}
	
	@Override
	public void setProductPrice(double productPrice) {
//		 this.productPrice = 105;
		 this.productPrice = productPrice;
	}
	@Override
	public void setImgPath(String imgPath) {
//		this.imgPath = "images/products/jelly-beans.jpg";
		this.imgPath = imgPath;
	}
	@Override
	public void setAvailibility(boolean isAvailable) {
//		this.isAvailable = true;
		this.isAvailable = isAvailable;
	}
	@Override
	public void setProductInfo(String productInfo) {
//		this.productInfo = "Jelly beans are small bean-shaped sugar candies with soft candy shells and thick gel interiors "
//				+ ". The confection is primarily made of "
//				+ "sugar and sold in a wide variety of colors and flavors.";
		this.productInfo = productInfo;
	}
	@Override
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	//Getters
	//Getters
	@Override
	public int getProductId() {
		return productId;
	}
	
	@Override
	public String getProductName() {
		return productName;	
	}
	@Override
	public double getProductPrice() {
		return productPrice;
	}
	@Override
	public String getImgPath() {
		return imgPath;
	}
	@Override
	public boolean getAvailibility() {
		return isAvailable;
	}
	@Override
	public String getProductInfo() {
		return productInfo;
	}
	@Override
	public ProductType getProductType() {
		return productType;
	}
	
	//CLONING
	@Override
	public JellyBeans clone() {
		return new JellyBeans();
	}

}
