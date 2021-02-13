package product.model;


import product.model.productType.ProductType;


public abstract class Product{
		

	int productId;
	String productName;
	String imgPath;
	String productInfo;
	double productPrice;
	boolean isAvailable;


    ProductType productType;
	
	//SETTERS
    public abstract void setProductId();
	public abstract void setProductName();
	public abstract void setProductPrice();
	public abstract void setImgPath();
	public abstract void setAvailibility();
	public abstract void setProductInfo();
	public abstract void setProductType(ProductType productType);
	
	//GETTERS
	public abstract int getProductId();
	public abstract String getProductName();
	public abstract double getProductPrice();
	public abstract String getImgPath();
	public abstract boolean getAvailibility();
	public abstract String getProductInfo();
	public abstract ProductType getProductType();
	
	
}
