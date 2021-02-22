<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- CART Modal -->
<section class="product-cart">
    <div class="modal" id="product-cart" tabindex="-1" role="dialog" aria-labelledby="product-cart"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalCenteredLabel">TODO CART</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col d-inline-flex">
                            <h5 class="ml-2">Product </h5>
                            <h5 style="margin-left: 13rem;">Quantity </h5>
                            <h5 style="margin-left: 3rem;">Price </h5>
                        </div>
                    </div>
                    <div class="row">
                        <!-- USER CART DATA IS HERE -->
                        <div class="col mt-1 mb-2 d-inline-flex">
                            <img src="images/products/puff-sweetflatbread-pastry.jpg" class="img-thumbnail cart-img"
                                alt="...">
                            <h6 class="d-flex align-self-end ml-3 font-weight-bold">Puffed Danish Pastry</h6>
                            <input class="d-flex align-self-end ml-3" min="1" type="number" style="width: 5rem;">
                            <h6 class="d-flex align-self-end ml-5">P 200</h6>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="row">
                            <div class="col d-inline-flex">
                                <h5 style="margin-right: 10rem;">TOTAL: P 600</h5>
                                <button type="button" class="btn btn-secondary mr-1"
                                    data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary ml-1">Submit</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>