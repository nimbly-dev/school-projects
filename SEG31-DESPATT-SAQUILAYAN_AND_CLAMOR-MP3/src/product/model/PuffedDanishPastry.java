package product.model;

import product.model.productType.ProductType;
import product.utility.ProductClone;

public class PuffedDanishPastry extends Product implements ProductClone{
	
	//Setters
	@Override
	public void setProductId() {
		this.productId = 7;
	}
	
	@Override
	public void setProductName() {
		this.productName = "Puffed Pastry Cream Bread";
	}	
	@Override
	public void setProductPrice() {
		 this.productPrice = 105;
	}
	@Override
	public void setImgPath() {
		this.imgPath = "images/products/puff-sweetflatbread-pastry.jpg";
	}
	@Override
	public void setAvailibility() {
		this.isAvailable = true;
	}
	@Override
	public void setProductInfo() {
		this.productInfo = "These cream cheese danish are a light and flaky pastry topped "
				+ "with a sweet cream cheese filling and fruit."
				+ " An easy yet elegant breakfast option!";
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
	
	@Override
	public ProductClone clone() {
		return new PuffedDanishPastry();
	}
}
