school-projects
Repository for Ent Jav 2 Project

TODO:

  1. BUG: on confirm-order.jsp where reloading the page will cause to insert again the cart-items data to db.
  2. BUG: Time Out Connection when deploying Application to Apache Tomcat
  3. DESIGN: Cart Modal Spacing Fix
  4. DESIGN: PDF Receipt Fix
  5. DESIGN: Navbar Highlighting Fix
  6. REQUIRED: Menu jsp page for selecting what predefined order will be selected by the user
  7. REQUIRED: UML Class Diagram for Class Builder Design of Products
  8. REQUIRED (CLASS BUILDER SOLUTION): Add packWithBox checkbox on cart-modal
  9. REQUIRED (CLASS BUILDER SOLUTION): Add isPackedWithBox boolean attribute to cart-items table
  10. REQUIRED (CLASS BUILDER SOLUTION): Modify Order Builder to accept the boolean value of isPackedWithBox
  11. REQUIRED (CLASS BUILDER SOLUTION): Modify insertToCart() singletonDB method to accept boolean value, if checkbox is checked then it is true and if 
      it is not checked then it is false.
  
0.48:

  * Completely removed isAvailable variable on Product Table and replace it with quantity

  * PDF format is fixed

  * Added Quantity max-limit on cart modal: 

  * Added Quantity on Product Table
  
0.47:

  * Added Shipping Address input box on payment-form.jsp

  * Fixed Validation of cvv length must be equal to 3 or 4

  * Added Item Interface on Product and ProductType Class

  * Added JAVA email

  * Added PDF Generator

  * Added Facade Design pattern

0.46:

  * Disposal of Cart Items Data upon cancel order or succesful payment

0.45:

  * Fixed Cart Design Spacing

  * Fixed confirm-page.jsp design Spacing

0.44:

  * Added Error Page to All Servlets
  
0.43:

  * Added payment-successful.jsp page

  * Added Product Payment Servlet

  * Added server-side creditcard and security number validation

  * Added Error Page for Process Payment Servlet

0.42:

  * Added process-payment.jsp

  * Implemented Credit Card Validation using JQuery Validation library on process-payment.jsp form

0.41:

  * Added Confirm Page.jsp
  
0.40:

  * Replaced MP3 with MP4

  * Added Cart Functionality

0.30:

  * Added MP3 Project
  
0.20:

  * Added MP2 Project
  
0.10:

  * Added MP1 Project
