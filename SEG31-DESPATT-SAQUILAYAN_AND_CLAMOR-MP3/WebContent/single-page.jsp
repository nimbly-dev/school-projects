<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>${requestScope.displayDetails.getProductName()}</title>
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
                    <li class="nav-item" id="home">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="product-list.jsp">Browse Products <span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#!">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#!">Cart</a>
                    </li>
                </ul>
                <form action='search-product.action' method="post" class="form-inline my-2 my-lg-0">
                    <div class="input-group">
                        <input class="form-control mr-sm-2 typeahead tt-query" autocomplete="off" type="text"
                            name="searchInput" placeholder="Find some sweets!">
                        <button type="submit" class="ht-tm-element btn btn-warning">Search</button>
                    </div>
                </form>
            </div>
        </nav>
    </header>

    <main>
        <section class="single-product">

            <div class="container-fluid m-sm-3">
                <div class="row">
                    <div class="col mt-1">
                        <h1 class="display-4 ht-tm-element">${requestScope.displayDetails.getProductName()}</h1>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <p class="col mt-3">
                        A ${requestScope.displayDetails.getProductType().getProductTypeName()}
                    </p>
                </div>

                <div class="row">
                    <div class="col mt-3">
                        <img src="${requestScope.displayDetails.getImgPath()}" alt="...">
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class='container-fluid d-flex w-50 p-3'>
                        <p class="col mt-3">
                            ${requestScope.displayDetails.getProductInfo()}
                        </p>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <h5>Php ${requestScope.displayDetails.getProductPrice()}</h5>
                </div>

                <div class="row justify-content-center">
                    <a href="search-result.html" class="mt-4 ht-tm-element btn btn-warning">Add to Cart</a>
                </div>

            </div>
        </section>
    </main>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/bloodhound.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/typeahead.jquery.min.js"></script>
    <script src="javascript/assets/autocomplete.js"></script>
</body>

</html>