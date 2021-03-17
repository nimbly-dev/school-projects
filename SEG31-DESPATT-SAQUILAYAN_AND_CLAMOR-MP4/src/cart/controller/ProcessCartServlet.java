package cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.utility.SingletonDB;

public class ProcessCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isCancelConfirmOrder = request.getParameter("clickedCancelOrder");
		String[] productNames = request.getParameterValues("productName");
		
		
		//If Cancel Button is clicked on confirm-order.jsp 
		if(isCancelConfirmOrder.contentEquals("true")) {
			System.out.println("DISPOSING CART DATA AND GENERATED ORDER");
			SingletonDB.disposeCartTableData();
			SingletonDB.disposeGeneratedOrder();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		//User is coming outside of confirm-order.jsp where submit button on the cart-modal was clicked.
		else if(productNames != null) {
			String[] productImgPath = request.getParameterValues("productImgPath");
			String[] productPrice = request.getParameterValues("productPrice");
			String totalPrice = request.getParameter("totalPrice");
			
			String[] productCount = request.getParameterValues("count");
			
			/*Code Block to Convert String[] productCount to integer array named countArray[]*/
			int size = productCount.length;
			int [] countArray = new int[size];
			for(int i = 0; i<size; i++) {
				countArray[i] = Integer.parseInt(productCount[i]);
			}
			
			int totalQuantity = Integer.parseInt(request.getParameter("totalQuantity"));
			HttpSession session = request.getSession();
			
			//Total Quantity is greater or equal to 8 then order of the user will be boxed
	    	if(totalQuantity >= 8) {
	    		System.out.println("TOTAL QUANTITY IS GREATER OR EQUAL TO 8, NEED TO BE BOXED");
	    		SingletonDB.generateOrder(1, true);
	    	}
	    	//Total Quantity is greater or equal to 8 then order of the user will not be boxed
	    	else {
	    		System.out.println("TOTAL QUANTITY IS LESS THAN 8, NO NEED TO BE BOXED");
	    		SingletonDB.generateOrder(1, false);
	    	}
	    	
			//Inserting Cart Data to database
			for(int i=0; i<productNames.length; i++){
				System.out.println("PRODUCT NAME: " + productNames[i]);
				
				String holder_productName = productNames[i];
				String holder_productImgPath = productImgPath[i];
				int holder_productCount = countArray[i];
				double holder_productPrice = Double.parseDouble(productPrice[i]);
				
				/*TEMPORARY ID IS 1*/
				SingletonDB.insertCartProduct(holder_productName, holder_productPrice, holder_productImgPath, holder_productCount, 1);
				
				/*INEFFICIENT NEED TO BE FIXED*/
				//Checker if Quantity is 0
				if(holder_productCount <= 0) {
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
