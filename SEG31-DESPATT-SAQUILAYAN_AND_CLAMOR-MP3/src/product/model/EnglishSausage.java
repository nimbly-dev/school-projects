package product.model;

import product.model.productType.ProductType;

public class EnglishSausage extends Product{
	//Setters
	@Override
	public void setProductId() {
		this.productId = 4;
	}
	
	@Override
	public void setProductName() {
		this.productName = "English Sausage";
	}	
	@Override
	public void setProductPrice() {
		 this.productPrice = 100;
	}
	@Override
	public void setImgPath() {
		this.imgPath = "images/products/English-Sausage.jpg";
	}
	@Override
	public void setAvailibility() {
		this.isAvailable = true;
	}
	@Override
	public void setProductInfo() {
		this.productInfo = "Savory pork sausage wrapped in puff pastry, "
				+ "baked to golden brown perfection. This sausage rolls recipe is the perfect "
				+ "make-ahead appetizer, sausage rolls are delicious served hot or cold. ";
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
	
}
