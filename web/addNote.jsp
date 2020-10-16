<%-- 
    Document   : addNote
    Created on : 22-Apr-2019, 15:23:02
    Author     : cristina
--%>

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
        <title> Add a note</title>

        
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
        <h2>Add a note</h2>
    <form method="POST" action="AddController" enctype="multipart/form-data">
        <div class="form">
            <input type="text" placeholder="Name" name="name"/>
        </div>
        <div class="form">
        <textarea rows="4" cols="50" name="content" placeholder="Type..." required/></textarea>
        </div>
        <div> 
            <input type="file" name="file" id="file" placeholder="File"/> <br/>
        </div>  
        <div>Destination
            <input type="text" value="/Users/cristina/NetBeansProjects/project_WAD_try_prezentare/web/img" name="destination" laceholder="Destination"/>
        </div>
        
        <div>
            <input type="submit" value="Add"/>
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

</body>
    

</html>


