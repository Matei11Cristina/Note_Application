<%-- 
    Document   : view
    Created on : 22-Apr-2019, 15:23:02
    Author     : cristina
--%>

<%@page import="controllers.Tag"%>
<%@page import="controllers.TagDAO"%>
<%@page import="controllers.NoteDAO"%>
<%@page import="java.util.List"%>
<%@page import="controllers.Notes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="style2.css" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title> View note</title>

        
    </head>
    <body><!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    <a href="page.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Home</a>
    <a href="page2.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">MyNotebook</a>
     <a href ="LogoutController" style="float:right;" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Logout</a>

  </div>


<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <a class="w3-bar-item w3-button w3-hover-black" href="addNote.jsp">Add a Note</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="page2.jsp">All notes</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="sharedWithMe.jsp">Shared with me</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="tags.jsp">Tags</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="trash.jsp">Trash</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="plans.jsp">Upgrade</a>
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">

  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
        <h2>View note</h2>
        <%String id=request.getParameter("id");
        List<Notes> notes=NoteDAO.getInstance().getNoteId(id);
        for(Notes note : notes){%>
    <form method="POST">
        <div class="form">
            <input type="text" placeholder="Name" name="name" value="<%out.println(note.getName());%>" disabled/>
        </div>
        <div class="form">
        <textarea rows="4" cols="50" name="content" placeholder="Type..." disabled/><%out.println(note.getDescription());%></textarea>
        </div>
        
        <img src="img/<% out.println(note.getFileName()); %>" style="width: 200px; height: 150px;"><br>

        <p><%out.println(note.getDate());%></p>
        <p>Status: <%out.println(note.getStatus());%></p>
        <%}%>
<!--        <div>
            <input type="submit" value="Add"/>
        </div>-->
<%String tag=request.getParameter("tag");
        String user = (String) request.getSession().getAttribute("USER");
        //String note=request.getParameter("note");  
        if(tag!=null) TagDAO.getInstance().InsertTag(tag, id, user);
        
        //request.getRequestDispatcher("view.jsp?id='"+a+"'").forward(request, response);
        //response.sendRedirect(request.getContextPath() + "/page2.jsp");
List<Tag> tags=TagDAO.getInstance().getTag(id);%>


<h4>Tags</h4>  <br>

<div class="note"> 
    <p><%if(!tags.isEmpty()) {
        for(Tag tag1 : tags) {%>
        #<% out.println(tag1.getName());  }} 
else %> No tags available.. Add one!</p>
</div><br><br>
    
        
        </form>
<form method="POST" action="view.jsp?id=<%out.println(id);%>">
        <div>
            <input type="text" placeholder="Tag" name="tag" required/>
            <input type="submit" value="Add Tag"/>
        </div>
</form><br>

<form method="POST" action="ShareController?id=<%out.println(id);%>">
        <div>
            <input type="text" placeholder="Share to who" name="share" required/>
            <input type="submit" value="Share Note"/>
        </div>
</form>
  
    </div>
 
  </div>

    
  </div>

 

  <footer id="myFooter">
    <div class="w3-container w3-theme-l2 w3-padding-32">
      <h4>Footer</h4>
    </div>

 
  </footer>
 <a href ="LogoutController">Logout</a>

 <script>
     
if ( window.history.replaceState ) {
  window.history.replaceState( null, null, 'page2.jsp' );
}
</script>
</body>
    

</html>
