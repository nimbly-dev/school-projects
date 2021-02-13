/**
 * JAVASCRIPT CLIENT SIDE FILE TO PRINT PRODUCTS 
 */
// AJAX CALLING FOR products.json
$(document).ready(() => {
    let productList = [];
    let counter = 0;


    console.log("Page Loaded");
    $.getJSON("SEG31-DESPATT-SAQUILAYAN_ALTHEO-MP1/../javascript/data/products.json", (result) => {
        $.each(result, (key, val) => {
            console.log(val);
            productList.push(printProducts(val));

            ++counter;
        });
    });

});

// Print data based on products.json file
let printProducts = (productList) => {
    let printProductsList = [];//Array List for Generated content
    let product;

    //Variable for sorting
    //let display = document.getElementById("sortProducts").elements[0].value;
    //console.log(display)

    for (var index in productList) { //Iterate in every JSON strings


        // //TODO Product Type Sorting
        // if (display == "All") { //If Display value is sort is All
        //     if (productList[index].isAvailable == true) {
        //         //Set Product Content Object
        //         product =
        //             `
        //         <div class="col mt-5">
        //             <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
        //             <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
        //             <div class="card-body">
        //                 <h5 class="card-title">${productList[index].productName}</h5>
        //                 <span class='ht-tm-element badge badge-pill badge-primary'>Available</span>
        //                 </span>
        //                 <h4>Price: ${productList[index].productPrice}</h4>
        //                 <form action='display-single-product.action' method='POST'>
        //                     <input type="hidden" name="selectedProduct" value="${productList[index].productName.toUpperCase()}" >
        //                     <button type="submit" class="btn btn-danger mt-2">Take a look</button>
        //                 </form>
        //             </div>
        //         </div>
        //         `;
        //     } else {
        //         product =
        //             `
        //         <div class="col mt-5">
        //             <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
        //             <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
        //             <div class="card-body">
        //                 <h5 class="card-title">${productList[index].productName}</h5>
        //                 <span class='ht-tm-element badge badge-pill badge-warning'> Not Available </span>
        //                 </span>
        //                 <h4>Price: ${productList[index].productPrice}</h4>
        //                 <form action='display-single-product.action' method='POST'>
        //                     <input type="hidden"  name='selectedProduct' value='${productList[index].productName.toUpperCase()}' >
        //                     <button disabled type="submit" class="btn btn-danger mt-2">Take a look</button>
        //                 </form>
        //             </div>
        //         </div>
        //         `;
        //     }
        // } else if (display == "Cupcake") {//If Display value is Cupcake

        //     if (productList[index].productTypeName.productTypeName == "Cupcake") {//Only of type Cupcake Product Type will be displayed
        //         if (productList[index].isAvailable == true) {
        //             //Set Product Content Object
        //             product =
        //                 `
        //             <div class="col mt-5">
        //                 <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
        //                 <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
        //                 <div class="card-body">
        //                     <h5 class="card-title">${productList[index].productName}</h5>
        //                     <span class='ht-tm-element badge badge-pill badge-primary'>Available</span>
        //                     </span>
        //                     <h4>Price: ${productList[index].productPrice}</h4>
        //                     <form action='display-single-product.action' method='POST'>
        //                         <input type="hidden" name="selectedProduct" value="${productList[index].productName.toUpperCase()}" >
        //                         <button type="submit" class="btn btn-danger mt-2">Take a look</button>
        //                     </form>
        //                 </div>
        //             </div>
        //             `;
        //         } else {
        //             product =
        //                 `
        //             <div class="col mt-5">
        //                 <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
        //                 <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
        //                 <div class="card-body">
        //                     <h5 class="card-title">${productList[index].productName}</h5>
        //                     <span class='ht-tm-element badge badge-pill badge-warning'> Not Available </span>
        //                     </span>
        //                     <h4>Price: ${productList[index].productPrice}</h4>
        //                     <form action='display-single-product.action' method='POST'>
        //                         <input type="hidden"  name='selectedProduct' value='${productList[index].productName.toUpperCase()}' >
        //                         <button disabled type="submit" class="btn btn-danger mt-2">Take a look</button>
        //                     </form>
        //                 </div>
        //             </div>
        //             `;
        //         }
        //     }

        // } else if (display == "Pastry") {//If Display value is Pastry
        //     if (productType[index].productType.productTypeName == "Pastry") {//Only of type Pastry Product Type will be displayed
        //         if (productList[index].isAvailable == true) {
        //             //Set Product Content Object
        //             product =
        //                 `
        //             <div class="col mt-5">
        //                 <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
        //                 <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
        //                 <div class="card-body">
        //                     <h5 class="card-title">${productList[index].productName}</h5>
        //                     <span class='ht-tm-element badge badge-pill badge-primary'>Available</span>
        //                     </span>
        //                     <h4>Price: ${productList[index].productPrice}</h4>
        //                     <form action='display-single-product.action' method='POST'>
        //                         <input type="hidden" name="selectedProduct" value="${productList[index].productName.toUpperCase()}" >
        //                         <button type="submit" class="btn btn-danger mt-2">Take a look</button>
        //                     </form>
        //                 </div>
        //             </div>
        //             `;
        //         } else {
        //             product =
        //                 `
        //             <div class="col mt-5">
        //                 <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
        //                 <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
        //                 <div class="card-body">
        //                     <h5 class="card-title">${productList[index].productName}</h5>
        //                     <span class='ht-tm-element badge badge-pill badge-warning'> Not Available </span>
        //                     </span>
        //                     <h4>Price: ${productList[index].productPrice}</h4>
        //                     <form action='display-single-product.action' method='POST'>
        //                         <input type="hidden"  name='selectedProduct' value='${productList[index].productName.toUpperCase()}' >
        //                         <button disabled type="submit" class="btn btn-danger mt-2">Take a look</button>
        //                     </form>
        //                 </div>
        //             </div>
        //             `;
        //         }
        //     }
        // } else if (display == "Candy") {//If Display value is Candy
        //     if (productList[index].productType.productTypeName) {
        //         //Set Product Content Object
        //         if (productList[index].isAvailable == true) {
        //             product =
        //                 `
        //             <div class="col mt-5">
        //                 <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
        //                 <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
        //                 <div class="card-body">
        //                     <h5 class="card-title">${productList[index].productName}</h5>
        //                     <span class='ht-tm-element badge badge-pill badge-primary'>Available</span>
        //                     </span>
        //                     <h4>Price: ${productList[index].productPrice}</h4>
        //                     <form action='display-single-product.action' method='POST'>
        //                         <input type="hidden" name="selectedProduct" value="${productList[index].productName.toUpperCase()}" >
        //                         <button type="submit" class="btn btn-danger mt-2">Take a look</button>
        //                     </form>
        //                 </div>
        //             </div>
        //             `;
        //         } else {
        //             product =
        //                 `
        //             <div class="col mt-5">
        //                 <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
        //                 <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
        //                 <div class="card-body">
        //                     <h5 class="card-title">${productList[index].productName}</h5>
        //                     <span class='ht-tm-element badge badge-pill badge-warning'> Not Available </span>
        //                     </span>
        //                     <h4>Price: ${productList[index].productPrice}</h4>
        //                     <form action='display-single-product.action' method='POST'>
        //                         <input type="hidden"  name='selectedProduct' value='${productList[index].productName.toUpperCase()}' >
        //                         <button disabled type="submit" class="btn btn-danger mt-2">Take a look</button>
        //                     </form>
        //                 </div>
        //             </div>
        //             `;
        //         }
        //     }
        // } else { //Display sort not working, throw error
        //     product =
        //         `
        //     <p>DIsplay sort not working</p>
        //     `
        // }

        //Set Product Content Object
        if (productList[index].isAvailable == true) {
            product =
                `
                    <div class="col mt-5">
                        <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
                        <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${productList[index].productName}</h5>
                            <span class='ht-tm-element badge badge-pill badge-primary'>Available</span>
                            </span>
                            <h4>Price: ${productList[index].productPrice}</h4>
                            <form action='display-single-product.action' method='POST'>
                                <input type="hidden" name="selectedProduct" value="${productList[index].productName.toUpperCase()}" >
                                <button type="submit" class="btn btn-danger mt-2">Take a look</button>
                            </form>
                        </div>
                    </div>
                    `;
        } else {
            product =
                `
                    <div class="col mt-5">
                        <div class="card" style="width: 18rem;" data-productType ="${productList[index].productType.productTypeName}">
                        <img src="${productList[index].imgPath}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${productList[index].productName}</h5>
                            <span class='ht-tm-element badge badge-pill badge-warning'> Not Available </span>
                            </span>
                            <h4>Price: ${productList[index].productPrice}</h4>
                            <form action='display-single-product.action' method='POST'>
                                <input type="hidden"  name='selectedProduct' value='${productList[index].productName.toUpperCase()}' >
                                <button disabled type="submit" class="btn btn-danger mt-2">Take a look</button>
                            </form>
                        </div>
                    </div>
                    `;
        }

        $(".print_products").append(product);

    }

    return printProductsList; //Returns an generated book content array

}


