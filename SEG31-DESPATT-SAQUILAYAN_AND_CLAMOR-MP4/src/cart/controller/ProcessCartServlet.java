package cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.utility.SingletonDB;
import cart.model.CartItemBean;

public class ProcessCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] productNames = request.getParameterValues("productName");
		String[] productImgPath = request.getParameterValues("productImgPath");
		String[] productCount = request.getParameterValues("count");
		String[] productPrice = request.getParameterValues("productPrice");
		
		String totalPrice = request.getParameter("totalPrice");
		
		HttpSession session = request.getSession();
		
		//Inserting Cart Data to database
		for(int i=0; i<productNames.length; i++){
			System.out.println("PRODUCT NAME: " + productNames[i]);
			
			String holder_productName = productNames[i];
			String holder_productImgPath = productImgPath[i];
			String holder_productCount = productCount[i];
			String holder_productPrice = productPrice[i];
			
			SingletonDB.insertCartProduct(holder_productName, holder_productPrice, holder_productImgPath, holder_productCount);
		}
		
		session.setAttribute("totalPrice", totalPrice);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("confirm-order.jsp");
		dispatcher.forward(request, response);
		
	}

}
