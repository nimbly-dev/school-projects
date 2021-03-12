/**
 * JAVASCRIPT CLIENT-SIDE ADD TO CART FUNCTIONALITY HOTDOG
*/


/**
 * SWEETX SHOPPING CART API
 *
*/
let shoppingCart = (() => {
    //THIS IS FOR CART ITEMS STORAGE ARRAY
    cart = [];

    //Constructor
    class cartItem {
        constructor(productName, productPrice, productImgPath, count, maxQuantity) {
            this.productName = productName;
            this.productPrice = productPrice;
            this.productImgPath = productImgPath;
            this.count = count;
            this.maxQuantity = maxQuantity;
        }
    }

    //Save Cart on Session
    function saveCart() {
        sessionStorage.setItem('shoppingCart', JSON.stringify(cart));
    }

    //Load Cart
    function loadCart() {
        cart = JSON.parse(sessionStorage.getItem('shoppingCart'));
    }
    if (sessionStorage.getItem("shoppingCart") != null) {
        loadCart();
    }

    // =============================
    // Public methods and propeties
    // =============================
    var item = {};

    //Method for Add to Cart
    item.addItemToCart = (productName, productPrice, productImgPath, count, maxQuatity) => {
        for (var item in cart) {
            if (cart[item].productName === productName) {
                cart[item].count++;
                saveCart();
                return;
            }
        }
        var item = new cartItem(productName, productPrice, productImgPath, count, maxQuatity);
        cart.push(item);
        saveCart();
    };

    //Method for setting the number of items in the cart
    item.setQuantityForItem = (productName, count) => {
        for (var i in cart) {
            if (cart[i].productName === productName) {
                cart[i].count = count;
                break;
            }
        }
    };

    //Method for removing 1 quantity to cart item
    item.removeItemFromCart = (productName) => {
        for (var item in cart) {
            if (cart[item].productName === productName) {
                cart[item].count--;
                if (cart[item].count === 0) {
                    cart.splice(item, 1);
                }
                break;
            }
        }
        saveCart();
    };

    // Method for completing removing the cart item
    item.removeItemFromCartAll = (productName) => {
        for (var item in cart) {
            if (cart[item].productName === productName) {
                cart.splice(item, 1);
                break;
            }
        }
        saveCart();
    }

    // Method for clearing cart of all items 
    item.clearCart = () => {
        cart = [];
        saveCart();
    }

    // Method for counting items on Cart
    item.totalCount = function () {
        var totalCount = 0;
        for (var item in cart) {
            totalCount += cart[item].count;
        }
        return totalCount;
    }

    // Method for counting the total number of items in the cart
    item.totalCart = () => {
        var totalCart = 0;
        for (var item in cart) {
            totalCart += cart[item].productPrice * cart[item].count;
        }
        return Number(totalCart.toFixed(2));
    }

    // Method for listing all items on cart
    item.listCart = () => {
        var cartCopy = [];
        for (i in cart) {
            item = cart[i];
            itemCopy = {};
            for (p in item) {
                itemCopy[p] = item[p];

            }
            itemCopy.total = Number(item.productPrice * item.count).toFixed(2);
            cartCopy.push(itemCopy)
        }
        return cartCopy;

    };
    return item;
})();

/*EVENT LISTENERS*/
//ADD TO CART LISTENER
function addToCart(obj) {
    console.log("PRODUCT NAME: " + $(obj).attr('data-productname'));
    var productName = $(obj).attr('data-productname');
    var productPrice = (Number)($(obj).attr('data-productprice'));
    var productImgPath = $(obj).attr('data-productimgpath');
    var productMaxQuantity = $(obj).attr('data-productmaxquantity');
    shoppingCart.addItemToCart(productName, productPrice, productImgPath, 1, productMaxQuantity);
    displayCart();
};

//CLEAR CART LISTENER
$('.clear-cart').click(event => {
    shoppingCart.clearCart();
    displayCart();
})
//DELETE ITEM LISTENER
function deleteItem(obj) {
    console.log("DELETED " + $(obj).attr('data-productname'));
    var productName = $(obj).attr('data-productname');
    shoppingCart.removeItemFromCartAll(productName);
    displayCart();
}

// INCREMENT ITEM COUNT TO +1 
function addOneItem(obj) {
    var productname = $(obj).attr('data-productname');
    shoppingCart.addItemToCart(productname);
    displayCart();
}

// DECREMENT ITEM COUNT TO -1 
function removeOneItem(obj) {
    var productname = $(obj).attr('data-productname');
    shoppingCart.removeItemFromCart(productname);
    displayCart();
}

// ITEM COUNT INPUT
$('.display-cart-items').on("change", ".item-count", () => {
    var productname = $(this).attr('data-productname');
    var count = Number($(this).val());
    shoppingCart.setCountForItem(productname, count);
    displayCart();
});


/*TODO DISPLAY CART METHODS*/
function displayCart() {
    var cartArray = shoppingCart.listCart();
    var displayCartArray = [];
    var output = "";
    for (var i in cartArray) {
        output =
            `
        <tr class="d-flex align-items-center">
            <!-- DATA TO BE TRANSFERED TO SERVLET ARE HERE -->
            <input type="hidden" value="${cartArray[i].productName}" name="productName">
            <input type="hidden" value="${cartArray[i].productImgPath}" name="productImgPath">
            <input type="hidden" value="${cartArray[i].count}" name="count">
            <input type="hidden" value="${cartArray[i].productPrice}" name="productPrice">
            <th scope="row">
                <img src="${cartArray[i].productImgPath}" class="img-thumbnail cart-img" alt="...">
            </th>
            <td class="col-md-2">
                <h6 class="d-flex align-self-end ml-2 font-weight-bold">${cartArray[i].productName}</h6>
            </td>
            <td>
                <div class="d-flex align-self-end ml-5">
                    <button type="button" class="plus-item btn btn-secondary btn-sm mr-2 ml-2" onclick="addOneItem(this)"
                    data-productname="${cartArray[i].productName}">+
                    </button>
                    <input class="ml-2 mr-1" style="width: 30%;" min="1" max="${cartArray[i].maxQuantity}" type="number" value="${cartArray[i].count}">
                    <button type="button" class="minus-item btn btn-danger btn-sm ml-1" onclick="removeOneItem(this)"
                    data-productname="${cartArray[i].productName}">
                    -
                    </button>
                </div>
            </td>
            <td class="col-sm-2 d-inline-flex">
                <h6 class="d-flex align-self-end " style="margin-right: 5rem;">${cartArray[i].total}</h6>
            </td>
            <td class="col-sm-1">
                <a class="delete-item d-flex align-self-end"  href="#delete" onclick='deleteItem(this)'
                data-productname="${cartArray[i].productName}">Delete</a>
            </td>
        </tr>
        `;
        displayCartArray.push(output);
    }
    $('.display-cart-items').html(displayCartArray); //Cart-Items
    $('.total-items-cart').html(shoppingCart.totalCart()); //Total Price
    $('.total-items-count').html(shoppingCart.totalCount());//Total Quantity
    document.getElementById('totalPrice').value = shoppingCart.totalCart();//Total Price
}


//3x Avocado Cupcake, 3x Strawberry Cupcake, and 3x Valentine Cupcake
function orderMenuAllCupcake() {
    shoppingCart.addItemToCart("Avocado Cupcake", 25.00, "images/products/avocado-biscuit-cupcake.PNG", 3, 20);
    displayCart();
    shoppingCart.addItemToCart("Strawberry Cupcake", 20.00, "images/products/strawberry-cupcake.jpg", 3, 20);
    displayCart();
    shoppingCart.addItemToCart("Valentine Cupcake", 30.00, "images/products/images/products/valentine-cupcake.jpg", 3, 20);
    displayCart();
}

//5x CandyCane and 5x JellyBeans
function orderMenuAllCandy() {
    shoppingCart.addItemToCart("Candy Cane", 10.00, "images/products/candy-cane.jpg", 5, 20);
    shoppingCart.addItemToCart("Jelly Beans", 15.00, "images/products/jelly-beans.jpg", 5, 20);
    displayCart();
}

//3x English Sausage, 3x Puffed Danish Pastry, 
function orderMenuAllPastry() {
    shoppingCart.addItemToCart("Puffed Danish Pastry", 75.00, "images/products/puff-sweetflatbread-pastry.jpg", 3, 20);
    shoppingCart.addItemToCart("English Sausage", 60.00, "images/products/English-Sausage.jpg", 3, 20);
    shoppingCart.addItemToCart("Churro Sticks", 15.00, "images/products/churro-sticks.jpg", 3, 20);
    displayCart();
}



displayCart();

