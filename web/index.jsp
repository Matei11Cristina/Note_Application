<%-- 
    Document   : index
    Created on : 07-Apr-2019, 18:29:21
    Author     : cristina
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <link rel="stylesheet" href="style.css" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
       <body>
        <div class="container">  
  <form id="contact" action="LoginController" method="post">
    <h3>Login</h3>
    
    <input placeholder="Username" name="uname" type="text" tabindex="1" required autofocus>
    
      <input placeholder="Password" name="password" type="password" tabindex="2" required> <br><br>
   
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Login</button><br><br>
    
      <p> Not a member? <a href="register.jsp">Register</a></p>
      
 
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
