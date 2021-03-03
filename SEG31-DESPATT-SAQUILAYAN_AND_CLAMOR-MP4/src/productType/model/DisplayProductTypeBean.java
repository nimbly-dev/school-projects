package productType.model;

import application.utility.ProductPrototype;

public class DisplayProductTypeBean extends ProductType{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3106175797721867166L;

	@Override
	public int getProductTypeId() {
		return productTypeId;
	}

	@Override
	public String getProductTypeName() {
		return productTypeName;
	}

	@Override
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	@Override
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	
	
}
