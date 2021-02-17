package product.model.productType;

import product.utility.ProductClone;

public class Pastry extends ProductType implements ProductClone{
	
	@Override
	public int getProductTypeId() {
		return productTypeId;
	}
	
	@Override
	public String getProductTypeName() {
		return productTypeName;
	}

	@Override
	public void setProductTypeName() {
		this.productTypeName = "Pastry";
	}
	
	@Override
	public void setProductTypeId() {
		this.productTypeId = 3;
	}
	
	@Override
	public ProductClone clone() {
		return new Pastry();
	}
}
