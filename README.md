school-projects
Repository for Ent Jav 2 Project

TODO:

  1. BUG: on confirm-order.jsp where reloading the page will cause to insert again the cart-items data to db.
  2. BUG: Time Out Connection when deploying Application to Apache Tomcat
  3. BUG: Only 1 quantity added per item from cart modal when using bundle add to cart (should be +3 everytime)
  4. BUG: Deduction parse causes a floating point error
  5. DESIGN: Cart Modal Spacing Fix
  6. DESIGN: PDF Receipt Fix
  7. DESIGN: Navbar Highlighting Fix
  8. DESIGN: Checkbox isBoxed boolean input Fix
  9. DESIGN: Remove Clear button on cart modal
  10. REQUIRED: UML Class Diagram for all design patterns used
  11. REQUIRED (CLASS BUILDER SOLUTION): Modify Order Builder to accept the boolean value of isPackedWithBox
  12. REQUIRED (CLASS BUILDER SOLUTION): Implement Menu Order Builder to cart-modal
  13. REQUIRED (CLASS BUILDER SOULUTION): Implement Menu Order Builder to ProcessCartServlet

0.50: 
  * Added menu-page.jsp

  * cart-order table and its reference constraints are added

  * isBoxed boolean attribute is added on input-form on modal

  * Generation of cart-order data row for the cart-items reference
  
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
