/**
 * SWEETX SHOPPING CART API
 *
*/
var shoppingCart = () => {

    //THIS IS FOR CART ITEMS STORAGE ARRAY
    cart = [];

    //Constructor
    class cartItem {
        constructor(productName, productPrice, count) {
            this.productName = productName;
            this.productPrice = productPrice;
            this.count = count;
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
    item.addItemToCart = (productName, productPrice, count) => {
        for (var item in cart) {
            if (cart[item].productName === productName) {
                cart[item].count++;
                saveCart();
                return;
            }
        }
        var item = new cartItem(productName, productPrice, count);
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

}