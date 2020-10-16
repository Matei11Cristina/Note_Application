<%-- 
    Document   : plans
    Created on : 12-May-2019, 12:32:54
    Author     : cristina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="plans.css" type="text/css"/>

     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Plans</title>

    </head>
    <body>
        
       <div class="w3-top">
  <div class="w3-bar w3-black w3-card w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-black" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="page.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Home</a>
    <a href="page2.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">MyNotebook</a>

 
    
    <!--<div class="w3-bar w3-black w3-card w3-right-align w3-large"> -->
    <a href="index.jsp" style="float:right;" class=" w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white ">Login</a>
    <a href="register.jsp" style="float:right;" class=" w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white ">Register</a>
    
  </div>


</div>
            
        <div id="pricing-table" class="clear">
            <p>Choose a plan that fits for you </p>

    <div class="plan">
        
        <h3>Basic<span>FREE</span></h3>
		<a class="signup" href="register.jsp">Sign up</a>
        <ul>
            <li><b>60MB</b> Monthly upload limit</li>
            <li><b>25MB</b> Maximum note size</li>
            <li><b>Limited</b> Take great notes for free</li>
			
        </ul>
    </div>
    <div class="plan">
        <h3>Premium<span>$3</span></h3>
        <a class="signup" href="https://www.paypal.com/signin?returnUri=https%3A%2F%2Fwww.paypal.com%2Fcgi-bin%2Fwebscr%3fcmd%3d_account">Check out</a>		
        <ul>
            <li><b>10GB</b> Monthly upload limit</li>
            <li><b>200MB</b> Maximum note size</li>

            <li><b>Unlimited</b> Share the notes with your friends</li>
        </ul>
    </div> 	
</div>
</body
</html>

