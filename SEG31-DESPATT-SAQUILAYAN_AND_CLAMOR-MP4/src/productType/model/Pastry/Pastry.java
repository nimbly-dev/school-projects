package productType.model.Pastry;

import application.utility.ProductPrototype;
import productType.model.ProductType;
import productType.model.Cupcake.Cupcake;

public class Pastry extends ProductType implements ProductPrototype{
	
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
//		this.productTypeName = "Pastry";
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
