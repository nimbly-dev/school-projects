package product.model.productType;

public class Pastry extends ProductType{
	
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
}
