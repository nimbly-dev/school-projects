package product.model.productType;

import product.utility.ProductClone;

public class Candy extends ProductType implements ProductClone {
	
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
		this.productTypeName = "Candy";
	}
	
	@Override
	public void setProductTypeId() {
		this.productTypeId = 1;
	}
	
	@Override
	public ProductClone clone() {
		return new Candy();
	}
}
