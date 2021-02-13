package product.model;

import product.model.productType.ProductType;

public class JellyBeans extends Product{
	
	//Setters
	@Override
	public void setProductId() {
		this.productId = 6;
	}
	
	@Override
	public void setProductName() {
		this.productName = "Jelly Beans";
	}
	
	@Override
	public void setProductPrice() {
		 this.productPrice = 105;
	}
	@Override
	public void setImgPath() {
		this.imgPath = "images/products/jelly-beans.jpg";
	}
	@Override
	public void setAvailibility() {
		this.isAvailable = true;
	}
	@Override
	public void setProductInfo() {
		this.productInfo = "Jelly beans are small bean-shaped sugar candies with soft candy shells and thick gel interiors "
				+ ". The confection is primarily made of "
				+ "sugar and sold in a wide variety of colors and flavors.";
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
	
	

}
