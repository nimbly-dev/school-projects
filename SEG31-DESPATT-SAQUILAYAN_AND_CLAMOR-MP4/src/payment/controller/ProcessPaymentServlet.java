package payment.controller; 

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.utility.HelperMethods;
import application.utility.PdfGenerator;
import application.utility.SingletonDB;
import cart.model.CartItemBean;
import product.model.Facade;


public class ProcessPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate currentDate = LocalDate.now();
		
		String fullName = request.getParameter("fullName");
		String expirationDate = request.getParameter("expirationDate");
		String securityNumber = request.getParameter("securityNumber");
		String creditCardNumber = request.getParameter("creditCardNumber");
		String shippingAddress = request.getParameter("shippingAddress");
		String emailAddress = request.getParameter("emailAddress");
		
		
		HelperMethods luhn = new HelperMethods();
		if(luhn.checkCardLuhn(creditCardNumber) == true && securityNumber.length() == 4 || securityNumber.length() == 3) {
			System.out.println("PAYMENT SUCCESFUL");
			System.out.println("NOW SENDING RECEIPT TO " + fullName);
			
			
			for(CartItemBean cartItem: SingletonDB.getCartItems()){
				int holder_originalProductCount = SingletonDB.getProductQuantity(cartItem.getProductName());//Original Count Product
				
				SingletonDB.deductQuantityCart(holder_originalProductCount, Integer.parseInt(cartItem.getCount()),
						cartItem.getProductName());
			}
			
			PdfGenerator generatePDF = new PdfGenerator();
			generatePDF.PDFfunctions(emailAddress, shippingAddress, fullName);
			System.out.println("DISPOSING CART ITEM");
			SingletonDB.disposeCartTableData();
			
			request.setAttribute("currentDate", currentDate);
			request.setAttribute("fullName", fullName);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("payment-successful.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
