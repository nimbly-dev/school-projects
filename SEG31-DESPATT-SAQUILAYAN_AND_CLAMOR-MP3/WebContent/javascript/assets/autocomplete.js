/**
 * JAVASCRIPT CLIENT SIDE FOR AUTOCOMPLETE SEARCHBAR
 */
$(document).ready(function () {
    // Defining the local dataset
    var products = [
        "Avocado Cupcake",
        "Candy Cane",
        "Churro Sticks",
        "English Sausage",
        "Jelly Beans",
        "Puffed Pastry Cream Bread",
        "Strawberry Cupcake",
        "Valentine Cupcake"
    ];
    
    // Constructing the suggestion engine
    var products = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.whitespace,
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        local: products
    });

    // Initializing the typeahead
    $('.typeahead').typeahead({
        hint: true,
        highlight: true, /* Enable substring highlighting */
        minLength: 1 /* Specify minimum characters required for showing suggestions */
    },
        {
            name: 'products',
            source: products
        });
});
