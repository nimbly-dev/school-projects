<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import="application.iterator.CartData" %>
<%@ page import="application.iterator.ProductIterator" %>
<%@ page import="java.util.Iterator" %>
<%!

	static CartData cartData;
	static ProductIterator iterCart;
	
	public static void initializeCart(ProductIterator newCartData) {
		iterCart = newCartData;
	}
%>
<%@ page import = "application.utility.SingletonDB" %>
<%@ page import="cart.model.CartItemBean"%>
<%
	cartData = new CartData();
	initializeCart(cartData);

	//Adds Iterator object
	Iterator<CartItemBean> cartIterator = iterCart.createIterator();
%>
       <section class="confirm-order">
            <div class="row d-flex justify-content-center">
                <div class="container fluid m-sm-5">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-wrap align-content-center">

                                <h4>Your order is as follows: </h4>
                                <table class="table table-borderless">
                                    <thead>
                                        <tr class="d-flex justify-content-between">
                                            <th scope="col" class="col-2"></th>
                                            <th scope="col" class="col-2">Product</th>
                                            <th scope="col" class="col-2">Price</th>
                                            <th scope="col" class="col-2">Count</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<%while(cartIterator.hasNext()){%>
                                    		<%
                                    		CartItemBean cartItem = (CartItemBean) cartIterator.next(); 
                                    		%>	
	                                        <tr class="d-flex justify-content-between">
	                                            <td>
	                                                <img src="<%=cartItem.getProductImgPath()%>" style="width: 7rem;
	                                                height: 7rem; margin-right: 3rem;" alt="NOT FOUND">
	                                            </td>
	                                            <th scope="row" class="col-2 align-self-center"><%=cartItem.getProductName()%></th>
	                                            <td scope="row" class="col-2 align-self-center">Php <%=cartItem.getProductPrice() %></td>
	                                            <td scope="row" class="col-2 align-self-center"><%=cartItem.getCount() %></td>
	                                        </tr>
                                        <%} %>
                                    </tbody>
                                </table>

                                <div class="row">
                                    <div class="col">
                                        <span style="margin-left: 45rem;">Total Price: P <%=session.getAttribute("totalPrice") %> </span>
                                    </div>
                                </div>
								
								
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col">
                                        	<button type="submit" class="btn btn-warning"
	                                                style="margin-left: 45rem;" 
                                             onclick="location.href='process-cart.action?clickedCancelOrder=true';shoppingCart.clearCart()">
	                                                Cancel
	                                         </button>
                                            <button type="button" class="btn btn-danger ml-3"
                                            onclick="location.href='payment-form.jsp'">Proceed
                                                Order</button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>