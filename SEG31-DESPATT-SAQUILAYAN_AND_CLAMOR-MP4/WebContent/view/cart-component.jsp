<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- CART Modal -->
<section class="product-cart">
    <div class="modal" id="product-cart" tabindex="-1" role="dialog" aria-labelledby="product-cart"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenteredLabel">
                    You have <span class="total-items-count"> </span> items on your cart
                    </h5>
                    <button type="button" class="clear-cart btn btn-primary ml-5">Clear</button>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">x</span>
                    </button>
                </div>
                
                <form action="process-cart.action" method="POST">
                	<input type="hidden" id="totalPrice" value="" name="totalPrice">
	                <div class="modal-body">
	                    <div class="row">
	                        <div class="col d-inline-flex">
	                            <h5 class="ml-2">Product </h5>
	                            <h5 style="margin-left: 15rem;">Quantity </h5>
	                            <h5 style="margin-left: 7rem;">Price </h5>
	                        </div>
	                    </div>
	                    
	                    <div class="row">
	
	                    	<!-- USER CART DATA IS HERE -->
	                    	<span class="display-cart-items">
	                    	
	                    	</span>
	                    </div>
	                    
	                    
	                    <div class="modal-footer">
	                        <div class="row">
	                            <div class="col d-inline-flex">
	                                <h5 class="cart-price-total d-flex flex-wrap align-content-start">
	                                P <span class="total-items-cart"></span>
	                                </h5>
	                                <button type="button" class="btn btn-secondary mr-1"
	                                    data-dismiss="modal">Close</button>
	                                <button type="submit" class="btn btn-primary ml-1">Submit</button>
	                            </div>
	                        </div>
	                    </div>
	
	                </div>
                </form>
                
            </div>
        </div>
    </div>
</section>