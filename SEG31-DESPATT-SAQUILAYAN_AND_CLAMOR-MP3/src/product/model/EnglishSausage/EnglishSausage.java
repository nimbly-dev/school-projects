package product.model.EnglishSausage;

import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;

public class EnglishSausage extends Product implements ProductPrototype{
	//Setters
	@Override
	public void setProductId(int productId) {
//		this.productId = 4;
		this.productId = productId;
	}
	
	@Override
	public void setProductName(String productName) {
//		this.productName = "English Sausage";
		this.productName = productName;
	}	
	@Override
	public void setProductPrice(double productPrice) {
//		 this.productPrice = 100;
		 this.productPrice = productPrice;
	}
	@Override
	public void setImgPath(String imgPath) {
//		this.imgPath = "images/products/English-Sausage.jpg";
		this.imgPath = imgPath;
	}
	@Override
	public void setAvailibility(boolean isAvailable) {
//		this.isAvailable = true;
		this.isAvailable = isAvailable;
	}
	@Override
	public void setProductInfo(String productInfo) {
//		this.productInfo = "Savory pork sausage wrapped in puff pastry, "
//				+ "baked to golden brown perfection. This sausage rolls recipe is the perfect "
//				+ "make-ahead appetizer, sausage rolls are delicious served hot or cold. ";
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
	public EnglishSausage clone() {
		return new EnglishSausage();
	}
	
}
