package productType.model;

import packaging.model.Wrapper;

public class DisplayProductTypeBean extends ProductType{

	protected int productTypeId;
	protected String productTypeName;
	protected String wrapper;
	
	public Wrapper wrapperType;
	
	public DisplayProductTypeBean() {

	}
	
	public DisplayProductTypeBean(int productTypeID, String productTypeName, String wrapper) {
		this.productTypeId = productTypeID;
		this.productTypeName = productTypeName;
		this.wrapper = wrapper;
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

	public String getWrapper() {
		return wrapper;
	}

	public void setWrapper(String wrapper) {
		this.wrapper = wrapper;
	}

	@Override
	public int productTypeId() {
		// TODO Auto-generated method stub
		return productTypeId;
	}

	@Override
	public String productTypeName() {
		// TODO Auto-generated method stub
		return productTypeName;
	}

	@Override
	public Wrapper wrapper() {
		// TODO Auto-generated method stub
		return wrapperType;
	}

	

	
	
	
	
}
