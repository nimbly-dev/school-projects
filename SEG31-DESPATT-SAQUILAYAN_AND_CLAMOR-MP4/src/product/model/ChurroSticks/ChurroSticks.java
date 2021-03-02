package product.model.ChurroSticks;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;

public class ChurroSticks extends Product implements ProductPrototype{
	
	//Setters
	@Override
	public void setProductId(int productId) {
//		this.productId = 3;
		this.productId = productId;
	}
	
	@Override
	public void setProductName(String productName) {
//		this.productName = "Churro Sticks";
		this.productName = productName;
	}	
	@Override
	public void setProductPrice(double Price) {
//		 this.productPrice = 50;
		 this.productPrice = Price;
	}
	@Override
	public void setImgPath(String imgPath) {
//		this.imgPath = "images/products/churro-sticks.jpg";
		this.imgPath = imgPath;
	}
	@Override
	public void setAvailibility(boolean isAvailalable){
//		this.isAvailable = false;
		this.isAvailable = isAvailalable;
	}
	@Override
	public void setProductInfo(String productInfo) {
//		this.productInfo ="A pastry originating in Spain, that is basically "
//				+ "fried dough extruded through a fluted tube, resulting in a star "
//				+ "shaped stick that is cut to a desired length. ";
		this.productInfo = productInfo;
	}
	@Override
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
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
	public ChurroSticks clone() {
		return new ChurroSticks();
	}
	
}
