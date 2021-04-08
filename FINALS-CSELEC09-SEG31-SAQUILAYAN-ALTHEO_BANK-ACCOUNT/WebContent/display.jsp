<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banko de nimbly</title>

    <link rel="stylesheet" href="css/materialize.min.css">
    <script defer src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script defer src="js/bin/materialize.min.js"></script>
    <!-- Incase of using javascript -->
    <script defer src="js/bin/main.js"></script>
    <link rel="stylesheet" href="/vendors/formvalidation/dist/css/formValidation.min.css">
    <script defer src="/vendors/formvalidation/dist/js/FormValidation.min.js"></script>
<script defer src="/vendors/formvalidation/dist/js/plugins/Materialize.min.js"></script>
</head>
<body>

    <main>
        <section><!-- Grid Flex Box -->
            <div class="container">
                <h4><span class="cyan-text text-darken-2">${clientAccountName}</span> Details: </h4>
                <p>Bank Account Type is <span class="cyan-text text-darken-2">${clientAccountType}</span>.</p>
                
                <s:if test='%{clientBalance lte 2000 && clientAccountType == "Savings"}'>
                <p>		Your balance is below the minimum of Php2000.00. The deduction is <span class="cyan-text text-darken-2"> 
                		${clientCurrentDeductionValue} </span> 
                </p>
                <p>		Your new balance is <span class="cyan-text text-darken-2"> ${newBalance} </span>				</p>
               	</s:if>
               		
               	<s:elseif test='%{clientBalance lte 5000 && clientAccountType == "Current" }'>
                <p>		Your balance is below the minimum of Php5000.00. The deduction is <span class="cyan-text text-darken-2"> 
                		${clientCurrentDeductionValue} </span> 
                </p>
                <p>		Your new balance is <span class="cyan-text text-darken-2"> ${newBalance} </span>				</p>
               	</s:elseif>

               	<s:else>
            	<p>		Account Balance: <span class="cyan-text text-darken-2"> ${clientBalance}</span></p>
                <p>		You do not have any deductions.</p>
                </s:else>
 
                <form action="index.jsp">
                
                	<button class="btn waves-effect waves-light" type="submit" name="action">Go Back
                   	 <i class="material-icons left">arrow_back</i>
                	</button>
                </form>
            </div>
        </section>
    </main>
    
    
</body>
</html>