<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<style>
.modal-body{
    max-height: calc(100vh - 200px);
    overflow-y: auto;
}
</style>
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
                    <div class="row mr-2">
                    	<a href="#cleared" class="clear-cart d-flex align-items-center">Clear</a>
	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">x</span>
	                    </button>
                    </div>
                </div>
                
              <form action="process-cart.action?clickedCancelOrder=placeholder" method="POST">
                	<input type="hidden" id="totalPrice" value="" name="totalPrice">
	                <div class="modal-body">
	                   <table class="table table-borderless">
	                        <thead>
	                        	<tr class="d-flex flex-wrap align-content-start	">
	                        		<th scope="col" class="col-2"></th>
	                        		<th scope="col" class="col ml-3">Product </th>
		                            <th scope="col" class="col">Quantity </th>
		                            <th scope="col" class="col-3 ml-5">Price </th>
	                        	</tr>
	                        </thead>
	                     <!-- USER CART DATA IS HERE -->
	                    <tbody class="display-cart-items"/>                   		
	                 </table>   
	                    <div class="modal-footer">
	                        <div class="row">
	                            <div class="col d-inline-flex">
	                            	<div class="custom-control custom-checkbox ml-5 d-flex flex-column align-content-start">
									  <input type="checkbox" class="custom-control-input" id="isBoxed" name="isBoxed" value="true">
									  <label class="custom-control-label" for="isBoxed" class="text-left">
									  	Would you like to place orders in a box?
									  </label>
									</div>
	                                <h5 class="cart-price-total d-flex flex-wrap align-content-start">
	                                Total: P &nbsp;<span class="total-items-cart ml-5 mr-3"></span>
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