package productType.model.Candy;

import application.utility.ProductPrototype;
import productType.model.ProductType;
import productType.model.Cupcake.Cupcake;

public class Candy extends ProductType implements ProductPrototype{
	
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
//		this.productTypeName = "Candy";
		this.productTypeName = productTypeName;
	}
	
	@Override
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	
    @Override
    public Candy clone() {
        return new Candy();
    }
}
