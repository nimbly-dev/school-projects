package product.model.StrawberryCupcake;


import application.utility.ProductPrototype;
import product.model.Product;
import productType.model.ProductType;

public class StrawberryCupcake extends Product implements ProductPrototype{
	
	
	//Setters
	@Override
	public void setProductId(int productId) {
//		this.productId = 7;
		this.productId = productId;
	}
	
	@Override
	public void setProductName(String productName) {
//		this.productName = "Strawberry Cupcake";
		this.productName = productName;
	}	
	@Override
	public void setProductPrice(double productPrice) {
//		 this.productPrice = 115;
		this.productPrice = productPrice;
	}
	@Override
	public void setImgPath(String imgPath) {
//		this.imgPath = "images/products/strawberry-cupcake.jpg";
		this.imgPath = imgPath;
	}
	@Override
	public void setAvailibility(boolean isAvailable) {
//		this.isAvailable = true;
		this.isAvailable = isAvailable;
	}
	@Override
	public void setProductInfo(String productInfo) {
//		this.productInfo = "Strawberry Cupcake for everyone!";
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
	public StrawberryCupcake clone() {
		return new StrawberryCupcake();
	}
}