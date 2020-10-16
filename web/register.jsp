<%-- 
    Document   : register
    Created on : 07-Apr-2019, 18:29:38
    Author     : cristina
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <div class="container">  
  <form id="contact" method="post" action="RegistrationController">
    <h3>REGISTER</h3>
    
      <input placeholder="Username" name="username" type="text" tabindex="1" required autofocus>
    
      <input placeholder="Password" name="password" type="password" tabindex="2" required>
      
      <input placeholder="Confirm Password" name="repassword" type="password" tabindex="2" required>
   
      <input placeholder="Email" name="email" type="text" tabindex="3" required><br><br>
   
      <button name="submit" type="submit" id="contact-submit">Register</button> <br><br>
    
      <p> Already a member? <a href="index.jsp">Login</a></p>
 
<% List<String> errors=(List<String>)
request.getAttribute("errors");
if(errors!=null && !errors.isEmpty()){
for(String error : errors)
out.println(error+"</br>");
} %>

  </form>
</div>
    </body>
</html>
