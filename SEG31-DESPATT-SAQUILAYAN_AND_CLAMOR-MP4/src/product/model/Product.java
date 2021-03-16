package product.model;

import productType.model.ProductType;

public abstract class Product implements ProductItem{
	
	public abstract ProductType productType();
	
	public int count;

	public abstract void setCount(int count);
}
