<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banco de nimbly</title>
    <link rel="stylesheet" href="css/materialize.min.css">
    <script defer src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script defer src="js/bin/materialize.min.js"></script>
    <script defer src="js/bin/main.js"></script>
    <link rel="stylesheet" href="/vendors/formvalidation/dist/css/formValidation.min.css">
    <script  defer src="/vendors/formvalidation/dist/js/FormValidation.min.js"></script>
	<script defer src="/vendors/formvalidation/dist/js/plugins/Materialize.min.js"></script>
	
</head>
<body>

    <main>
        <section><!-- Grid Flex Box -->
            <div class="container">
                <h5>Enter Bank Account Details</h5>
                <form class="col s12" id="formValidate" action="compute.action" method="POST">
                    <div class="row">
                        <div class="input-field col s12">
                            <input placeholder="Enter Account Name" name="clientAccountName" required type="text">
                            <label for="accountName">Account Name</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input placeholder="Enter Desired Value" name="clientBalance" required type="number">
                            <label for="bankDeposit">Bank Deposit</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select name="clientAccountType" required>
                              <option value="" disabled selected>Choose your option</option>
                              <option value="Savings">Savings Account</option>
                              <option value="Current">Current Account</option>
                            </select>
                            <label>Account Type</label>
                          </div>
                    </div>
                    <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                        <i class="material-icons right">send</i>
                    </button>
                </form>
            </div>
        </section>
    </main>
    
</body>
</html>