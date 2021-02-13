package product.model.productType;

import product.model.AvocadoCupcake;
import product.utility.ProductClone;

public class Cupcake extends ProductType implements ProductClone{

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
		this.productTypeName = "Cupcake";
	}
	
	@Override
	public void setProductTypeId() {
		this.productTypeId = 2;
	}
	
	//CLONING
	@Override
	public ProductClone clone() {
		return new Cupcake();
	}

}
