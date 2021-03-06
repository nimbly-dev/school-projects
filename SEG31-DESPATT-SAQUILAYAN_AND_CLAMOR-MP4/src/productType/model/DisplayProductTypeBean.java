package productType.model;

import packaging.model.Wrapper;

public class DisplayProductTypeBean extends ProductType{

	protected int productTypeId;
	protected String productTypeName;
	protected String wrapper;
	
	
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
	public String getWrapper() {
		return wrapper;
	}
	public void setWrapper(String wrapper) {
		this.wrapper = wrapper;
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
