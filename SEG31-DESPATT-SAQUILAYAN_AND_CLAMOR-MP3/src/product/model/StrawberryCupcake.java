package product.model;


import product.model.productType.ProductType;
import product.utility.ProductClone;

public class StrawberryCupcake extends Product implements ProductClone{
	
	
	//Setters
	@Override
	public void setProductId() {
		this.productId = 7;
	}
	
	@Override
	public void setProductName() {
		this.productName = "Strawberry Cupcake";
	}	
	@Override
	public void setProductPrice() {
		 this.productPrice = 115;
	}
	@Override
	public void setImgPath() {
		this.imgPath = "images/products/strawberry-cupcake.jpg";
	}
	@Override
	public void setAvailibility() {
		this.isAvailable = true;
	}
	@Override
	public void setProductInfo() {
		this.productInfo = "Strawberry Cupcake for everyone!";
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
	public ProductClone clone() {
		return new StrawberryCupcake();
	}
}
