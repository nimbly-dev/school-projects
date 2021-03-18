package product.model;


public interface Facade {
	
	//generate and Mail PDF receipt
	public void PDFfunctions(String emailPDF, String shippingAddressPDF, String fullNamePDF);
	
	
	//check if card is valid
	public boolean checkCardLuhn(String cardNo);
	
}
