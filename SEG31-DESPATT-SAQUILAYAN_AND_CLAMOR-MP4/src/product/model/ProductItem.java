package product.model;

import productType.model.ProductType;

public interface ProductItem {
	//FOR SQL QUERY
	public int productTypeID();
	
	public int productId();
	public String productName();
	public String imgPath();
	public String productInfo();
	public double productPrice();
	public int quantity();
	
	public ProductType productType();
	
}
