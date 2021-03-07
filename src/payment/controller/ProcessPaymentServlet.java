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
import product.model.Facade;


public class ProcessPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LocalDate currentDate = LocalDate.now();
		paymentInfoBean infoData = new paymentInfoBean();
		
		String fullName = request.getParameter("fullName");
		
		String expirationDate = request.getParameter("expirationDate");
		String securityNumber = request.getParameter("securityNumber");
		String creditCardNumber = request.getParameter("creditCardNumber");
		String shippingAddress = request.getParameter("shippingAddress");
		String emailAddress = request.getParameter("emailAddress");
		infoData.setEmail(emailAddress);
		
		
		HelperMethods luhn = new HelperMethods();
		if(luhn.checkCardLuhn(creditCardNumber) == true && securityNumber.length() == 4 || securityNumber.length() == 3) {
			System.out.println("PAYMENT SUCCESFUL");
			System.out.println("NOW SENDING RECEIPT TO " + fullName);
			System.out.println(infoData.getEmail());
			System.out.println("DISPOSING CART ITEM");
			
			
			infoData.setShipping(shippingAddress);
			infoData.setName(fullName);
			
			PdfGenerator pdf = new PdfGenerator();
			
			pdf.PDFfunctions(emailAddress);
			
			SingletonDB.disposeCartTableData();
			
			request.setAttribute("currentDate", currentDate);
			request.setAttribute("fullName", fullName);
			request.setAttribute("emailAdddress", emailAddress);
			
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("payment-successful.jsp");
			dispatcher.forward(request, response);
			
			
			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
