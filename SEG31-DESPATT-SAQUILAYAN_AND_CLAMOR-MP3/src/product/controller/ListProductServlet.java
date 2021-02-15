package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedTypeOfProduct = request.getParameter("selectedProductType");
		System.out.println(selectedTypeOfProduct);
		try {
			if(selectedTypeOfProduct.equals("Candy")){
				System.out.println("Inside Candy If-block");
//				response.sendRedirect("product-list.jsp?selectedProductType=Candy");
				RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
				dispatcher.forward(request, response);
			}else if(selectedTypeOfProduct.equals("Cupcake")){
				System.out.println("Inside Cupcake If-block");
//				response.sendRedirect("product-list.jsp?selectedProductType=Cupcake");
				RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp?selectedProductType=Cupcake");
				dispatcher.forward(request, response);
			}else if(selectedTypeOfProduct.equals("Pastry")){
				System.out.println("Inside Pastry If-block");
//				response.sendRedirect("product-list.jsp?selectedProductType=Pastry");
				RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp?selectedProductType=Pastry");
				dispatcher.forward(request, response);
			}else {
				System.out.println("Inside All If-block");
//				response.sendRedirect("product-list.jsp?selectedProductType=All");
				RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp?selectedProductType=All");
				dispatcher.forward(request, response);
			}
		}catch(Exception npe) {
			npe.getStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
