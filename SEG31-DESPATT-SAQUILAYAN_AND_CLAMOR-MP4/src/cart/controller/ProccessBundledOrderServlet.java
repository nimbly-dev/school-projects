package cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.utility.SingletonDB;
import product.builder.Order;
import product.builder.OrderBuilder;


public class ProccessBundledOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedBundle = request.getParameter("selectedBundle");
		String isCancelConfirmOrder = request.getParameter("clickedCancelOrder");
		String totalPrice = request.getParameter("totalPrice");
		
		//If Cancel Button is clicked on confirm-order.jsp 
		if(isCancelConfirmOrder.contentEquals("true")) {
			System.out.println("DISPOSING CART DATA NOW");
			SingletonDB.disposeCartTableData();
			SingletonDB.disposeGeneratedOrder();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		//User is coming outside of confirm-order.jsp where submit button on the cart-modal was clicked.
		else if(isCancelConfirmOrder.contentEquals("false")) {
			int totalQuantity = Integer.parseInt(request.getParameter("totalQuantity"));
			OrderBuilder orderBuilder = new OrderBuilder();
			
			//Selected Bundle is AllCupcakeBundle
			if(selectedBundle.contentEquals("orderAllCupcakeBundle")) {
				
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
				
				Order orderAllCupcakeBundle = orderBuilder.prepareAllCupcakeOrder();
				
				orderAllCupcakeBundle.insertBundledOrderToDB();
				
				HttpSession session = request.getSession();
				session.setAttribute("totalPrice", totalPrice);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("confirm-order.jsp");
				dispatcher.forward(request, response);
			}
			else if(selectedBundle.contentEquals("orderAllPastryBundle")) {
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
				
				Order orderAllPastryBundle = orderBuilder.prepareAllPastryOrder();
				
				orderAllPastryBundle.insertBundledOrderToDB();
				
				HttpSession session = request.getSession();
				session.setAttribute("totalPrice", totalPrice);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("confirm-order.jsp");
				dispatcher.forward(request, response);
			}else if(selectedBundle.contentEquals("jellyBeansMania")) {
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
				
				Order jellyBeansBundle = orderBuilder.prepareAllPastryOrder();
				
				jellyBeansBundle.insertBundledOrderToDB();
				
				HttpSession session = request.getSession();
				session.setAttribute("totalPrice", totalPrice);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("confirm-order.jsp");
				dispatcher.forward(request, response);
			}
			//String selectBundle is null, redirrect to error page.
			else {
				System.out.println("SELECT BUNDLE IS NULL");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
