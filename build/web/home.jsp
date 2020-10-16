<%-- 
    Document   : home
    Created on : 07-Apr-2019, 18:45:24
    Author     : cristina
--%>

<%@page import="controllers.Notes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.Exists"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            //String username = (String)session.getAttribute("username");
            //out.print("Welcome " + username);
            //out.print(session.getId());
            String username = request.getParameter("uname");
            session.setAttribute("username", username);
            
            Exists exists = new Exists();
            ArrayList<Notes> notesView= new ArrayList<Notes>();
            ServletContext ctx = request.getServletContext();
            notesView=(ArrayList<Notes>)ctx.getAttribute("DbProducts");
boolean logged=false;
String user = (String) request.getSession().getAttribute("USER");
String  password = (String) request.getSession().getAttribute("PASSWORD");
if(request.getSession(false) != null && user!=null && exists.isUser(user, password)){
//user=(String)request.getSession().getAttribute("USER");
logged=true;}
for (int i=0; i<notesView.size(); i++){
            if(logged==true){
                out.println("<h1>Name</h1>");
              out.println("<p>"+notesView.get(i).getName()+"</p>");
                out.println("</div>");
                out.println("<div>");
               out.println("<h1>Description</h1>");  
                out.println("<p>"+notesView.get(i).getDescription()+"</p>");
                out.println("</div>");
                 out.println("<h1>Date</h1>");
              out.println("<p>"+notesView.get(i).getDate()+"</p>");
            }
            else out.println("<h1>Pls log in</h1>");  
}
            %>
      <a href ="LogoutController">Logout</a>
    </body>
</html>
