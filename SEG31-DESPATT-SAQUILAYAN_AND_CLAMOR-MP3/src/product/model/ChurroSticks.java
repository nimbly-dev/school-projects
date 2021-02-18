package product.model;

import product.model.productType.ProductType;
import product.utility.ProductClone;

public class ChurroSticks extends Product implements ProductClone{
	
	//Setters
	@Override
	public void setProductId() {
		this.productId = 3;
	}
	
	@Override
	public void setProductName() {
		this.productName = "Churro Sticks";
	}	
	@Override
	public void setProductPrice() {
		 this.productPrice = 50;
	}
	@Override
	public void setImgPath() {
		this.imgPath = "images/products/churro-sticks.jpg";
	}
	@Override
	public void setAvailibility() {
		this.isAvailable = false;
	}
	@Override
	public void setProductInfo() {
		this.productInfo ="A pastry originating in Spain, that is basically "
				+ "fried dough extruded through a fluted tube, resulting in a star "
				+ "shaped stick that is cut to a desired length. ";
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
		return new ChurroSticks();
	}
	
}
