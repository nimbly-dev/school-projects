package productType.model.Cupcake;

import application.utility.ProductPrototype;
import product.model.AvocadoCupcake.AvocadoCupcake;
import productType.model.ProductType;

public class Cupcake extends ProductType implements ProductPrototype{

	@Override
	public int getProductTypeId() {
		return productTypeId;
	}
	
	
	@Override
	public String getProductTypeName() {
		return productTypeName;
	}

	@Override
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	
	@Override
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	
    @Override
    public Cupcake clone() {
        return new Cupcake();
    }
}
