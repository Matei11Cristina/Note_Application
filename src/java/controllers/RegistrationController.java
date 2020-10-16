/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristina
 */

public class RegistrationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String USERNAME="root";
    private static final String PASSWORD="cristina";
   private static final String CONN_STRING="jdbc:mysql://localhost:3306/mydb";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>");  
            out.println("<title>Servlet RegistrationController</title>");  
            out.println("<meta charset=\"UTF-8\">");  
            out.println("<meta name=\"viewport\" content=\"width=device-width\">");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Success!!</h2>");
            out.println("</body>");
            out.println("</html>");
            
           Connection conn=null;
      
      try{
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","root","cristina");
            System.out.println("Connected");
            Statement stmt=(Statement)conn.createStatement();
            String username=request.getParameter("uname");
            String password=request.getParameter("password");
            String email=request.getParameter("email");
            
            
            List<String> errors=new ArrayList<>();
            Exists exists =  new Exists();

        try {
            if(  exists.isUser( username, password ) == true )
                errors.add("User already exists.");
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

                            
                      


//Error case
if(!errors.isEmpty()){
request.setAttribute("errors", errors);
request.getRequestDispatcher("register.jsp").forward(request, response);
}
else {
            
            
            String insert="INSERT INTO mydb.user(username,password,email) VALUES ('"+username+"',sha1('"+password+"'),'"+email+"');";
            stmt.executeUpdate(insert);
            request.getRequestDispatcher("addNote.jsp").forward(request, response);}
        }catch (SQLException e){
            e.printStackTrace();
        }
      
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
