<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
	String displayAllUrl = "display-products.action?selectedProductType=All";
%>

<%@page import = "application.utility.PdfGenerator" %>
<% PdfGenerator pdf = new PdfGenerator(); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheets/bootstrap4-bubblegum.min.css">
    <link rel="stylesheet" href="stylesheets/stylesheet.min.css">
    <link rel="icon" href="images/icon/favicon.png" type="image/png">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet">
    <title>Process Payment</title>
</head>

<body>
    <header>
        <nav class="navbar fixed-top navbar-expand-md ht-tm-element navbar-dark bg-danger">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <img src="images/icon/Sweetx.png">
            <a class="navbar-brand" href="#!">Sweetx</a>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-md-0">
                    <li class="nav-item active" id="home">
                        <a class="nav-link" href="index.jsp">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="submit nav-link" href="<%=displayAllUrl%>">Browse Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#!">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#!" data-toggle="modal" data-target="#product-cart">Cart</a>
                    </li>
                </ul>
                <form action='search-product.action' method="post" class="form-inline my-2 my-lg-0">
                    <div class="input-group ui-widget">
                        <input class="form-control mr-sm-2 typeahead tt-query" type="text" name="searchInput"
                            autocomplete="off" placeholder="Enter Something!">
                        <button type="submit" class="ht-tm-element btn btn-warning">Search</button>
                    </div>
                </form>
            </div>
        </nav>
    </header>

    <main>
        <section class="confirm-order">
            <div class="row" style="margin-left: 10rem;">
                <div class="container fluid m-sm-5">
                    <div class="card ">
                        <div class="card-body">
                            <h5 class="mt-4 mb-5">Please Enter Credentials</h5>

                            <form id="processPaymentForm">
                                <div class="form-group ml-3">
                                    <div class="row  mt-2 mb-2">
                                        <label for="fullName" class="mr-3 mt-2">Enter Name:
                                        </label>
                                        <input type="text" class="form-control" style="width: 30%;"
                                            data-error=".errorTxt1" id="fullName" name="fullName"
                                            placeholder="Enter Full Name" required>
                                        <div class="align-self-center text-danger errorTxt1 ml-1"></div>
                                    </div>

                                    <div class="row  mt-2 mb-2">
                                        <label for="creditCardNumber" class="mr-3 mt-2">Credit Card Number: </label>
                                        <input type="text" class="form-control" style="width: 24%;"
                                            id="creditCardNumber" data-error=".errorTxt2" name="creditCardNumber"
                                            placeholder="Enter Credit Card" required>
                                        <div class="align-self-center text-danger errorTxt2 ml-1"></div>
                                    </div>
                                    <div class="row  mt-2 mb-2">
                                        <label for="expirationDate" class="mr-2 mt-2">Expiration Date: </label>
                                        <input type="date" class="form-control w-25" name="expirationDate"
                                            id="expirationDate" data-error=".errorTxt3" required>
                                        <div class="align-self-center text-danger errorTxt3 ml-1"></div>
                                    </div>

                                    <div class="row mt-2 mb-2">
                                        <label for="securityNumber" class="mr-2 mt-2">Security Number: </label>
                                        <!--TODO NEED TO REMOVE INLINE JAVASCRIPTs -->
                                        <input type="number" class="form-control w-25" id="securityNumber"
                                            name="securityNumber" data-error=".errorTxt4" maxlength="4"
                                            placeholder="Enter Security Number" required>
                                        <div class="align-self-center text-danger errorTxt4 ml-1"></div>
                                    </div>


                                    <div class="row d-flex justify-content-end">
                                        <button type="submit" class="btn btn-success mt-4 mr-5">Submit</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
    <script src="javascript/assets/credit-card-checker.js"></script>
</body>

</html>