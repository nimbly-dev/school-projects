package product.model.productType;

public class Candy extends ProductType{
	
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
}
