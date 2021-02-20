package product.model;


import application.utility.ProductPrototype;
import product.model.AvocadoCupcake.AvocadoCupcake;
import productType.model.ProductType;


public abstract class Product{
	
	//FOR SQL QUERY
	protected int productTypeID;

	protected int productId;
	protected String productName;
	protected String imgPath;
	protected String productInfo;
	protected double productPrice;
	protected boolean isAvailable;
	
    protected ProductType productType;
    
	
	//SETTERS
    public abstract void setProductId(int productId);
    public abstract void setProductName(String productName);
    public abstract void setProductPrice(double productPrice);
    public abstract void setImgPath(String imgPath);
    public abstract void setAvailibility(boolean isAvailable);
    public abstract void setProductInfo(String productInfo);
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
