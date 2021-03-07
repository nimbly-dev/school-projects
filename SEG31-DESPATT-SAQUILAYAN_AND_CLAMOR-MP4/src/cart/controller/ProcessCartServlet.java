package cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.utility.SingletonDB;
import payment.controller.paymentInfoBean;

public class ProcessCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isCancelConfirmOrder = request.getParameter("clickedCancelOrder");
		//Parameter Value Names
		String[] productNames = request.getParameterValues("productName");
		String[] productImgPath = request.getParameterValues("productImgPath");
		String[] productCount = request.getParameterValues("count");
		String[] productPrice = request.getParameterValues("productPrice");
		
		String totalPrice = request.getParameter("totalPrice");
		
		//If Cancel Button is clicked on confirm-order.jsp 
		if(isCancelConfirmOrder.contentEquals("true")) {
			System.out.println("DISPOSING CART DATA NOW");
			SingletonDB.disposeCartTableData();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		//User is coming outside of confirm-order.jsp where submit button on the cart-modal was clicked.
		else if(productNames != null) {
			HttpSession session = request.getSession();
			
			//Inserting Cart Data to database
			for(int i=0; i<productNames.length; i++){
				System.out.println("PRODUCT NAME: " + productNames[i]);
				
				String holder_productName = productNames[i];
				String holder_productImgPath = productImgPath[i];
				String holder_productCount = productCount[i];
				String holder_productPrice = productPrice[i];
				System.out.println("TEST");
				SingletonDB.insertCartProduct(holder_productName, holder_productPrice, holder_productImgPath, holder_productCount);
				
				/*INEFFICIENT NEED TO BE FIXED*/
				//Checker if Quantity is 0
				if(Integer.parseInt(holder_productCount) <= 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
					dispatcher.forward(request, response);
				}
			}
			
			session.setAttribute("totalPrice", totalPrice);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("confirm-order.jsp");
			dispatcher.forward(request, response);
		}
		
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
	}
	

}
