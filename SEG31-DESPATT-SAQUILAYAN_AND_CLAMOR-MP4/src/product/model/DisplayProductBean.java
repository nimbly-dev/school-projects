package product.model;

import application.utility.ProductPrototype;
import productType.model.ProductType;

public class DisplayProductBean extends Product implements ProductPrototype{
	
	//CLONING
	@Override
	public DisplayProductBean clone() {
		return new DisplayProductBean();
	}

	@Override
	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public void setAvailibility(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	@Override
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

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

	//GET AND SET PRODUCT TYPE ID
	public void setProductTypeID(int productTypeID) {
		this.productTypeID = productTypeID;
	}
	
	public int getProductTypeID() {
		return productTypeID;
	}
	
}
