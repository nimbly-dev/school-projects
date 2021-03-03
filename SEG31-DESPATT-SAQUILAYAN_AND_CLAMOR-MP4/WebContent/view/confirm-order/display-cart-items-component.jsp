<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import = "application.utility.SingletonDB" %>
<%@ page import="cart.model.CartItemBean"%>
       <section class="confirm-order">
            <div class="row d-flex justify-content-center">
                <div class="container fluid m-sm-5">
                    <div class="card ">
                        <div class="card-body">
                            <div class="d-flex flex-wrap align-content-center">

                                <h4>Your order is as follows: </h4>
								
                                <table class="table table-borderless">
                                    <thead>
                                        <tr class="d-flex flex-wrap align-content-start">
                                            <th style="margin-right: 16rem;"></th>
                                            <th style="margin-right: 9rem;">Product</th>
                                            <th style="margin-left: 5rem;">Price</th>
                                            <th style="margin-left: 10rem;">Count</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<%for(CartItemBean cartItem: SingletonDB.getCartItems()){ %>
                                        <tr class="d-flex align-items-center">
                                            <th>
                                                <img src="<%=cartItem.getProductImgPath()%>" style="width: 8rem;
                                                height: 8rem;" alt="NOT FOUND">
                                            </th>
                                            <th scope="row" style="margin-left: 5rem;"><%=cartItem.getProductName() %></th>
                                            <td style="margin-left: 12rem;"><%=cartItem.getProductPrice() %></td>
                                            <td style="margin-left: 9rem;"><%=cartItem.getCount() %></td>
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
                                            <button type="button" class="btn btn-warning"
                                                style="margin-left: 45rem;">Cancel
                                            </button>
                                            <button type="button" class="btn btn-danger ml-3">Proceed
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