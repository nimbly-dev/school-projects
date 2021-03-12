package productType.model;

import packaging.model.Wrapper;

public class DisplayProductTypeBean extends ProductType{

	protected int productTypeId;
	protected String productTypeName;
	protected String wrapper;
	
	public DisplayProductTypeBean() {

	}
	
	public DisplayProductTypeBean(int productTypeID, String productTypeName, String wrap) {
		this.productTypeId = productTypeID;
		this.productTypeName = productTypeName;
		this.wrapper = wrap;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	
	@Deprecated
	@Override
	public int productTypeId() {
		return 0;
	}
	@Deprecated
	@Override
	public String productTypeName() {
		return null;
	}
	@Deprecated
	@Override
	public Wrapper wrapper() {
		return null;
	}
	
	
	
	
}
