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
		String isCancelConfirmOrder = request.getParameter("clickedCancelOrder");
		String totalPrice = request.getParameter("totalPrice");
		
		//If Cancel Button is clicked on confirm-order.jsp 
		if(isCancelConfirmOrder.contentEquals("true")) {
			System.out.println("DISPOSING CART DATA NOW");
			SingletonDB.disposeCartTableData();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		//User is coming outside of confirm-order.jsp where submit button on the cart-modal was clicked.
		else if(isCancelConfirmOrder.contentEquals("false")) {
			OrderBuilder orderBuilder = new OrderBuilder();
			
			//Insert IF statements
			Order orderCupcake = orderBuilder.prepareAllCupcakeOrder();
			
			orderCupcake.insertBundledOrderToDB();
			
			HttpSession session = request.getSession();
			
			session.setAttribute("totalPrice", totalPrice);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("confirm-order.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
