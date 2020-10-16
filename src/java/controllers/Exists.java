/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.*;
public class Exists {
    
   public boolean userExists (String username) throws SQLException{
         String sql = "SELECT username FROM user;";
try (Connection con = Connection1.getConnection();
Statement instr = con.createStatement();) {
ResultSet rs = instr.executeQuery(sql);

while (rs.next()) {
String user=rs.getString("username");
            if(user.equals(username)){
                return true;
            }
}
} catch (SQLException e) {
}

      
    
        return false;
    }
    
    public boolean isUser(String username,String password) throws SQLException{
       String sql = "SELECT username,password FROM user; ";
try (Connection con = Connection1.getConnection();
Statement instr = con.createStatement();) {
    String pass1=instr.executeQuery("SELECT SHA1(\'"+password+"\')").toString();
ResultSet rs = instr.executeQuery(sql);

while (rs.next()) {
 String user=rs.getString("username");
            String pass=rs.getString("password");
        
           
            if(user.equals(username)&&pass.equals(pass)){
                return true;
            }
}
} catch (SQLException e) {
}
      
      
        return false;
    }
    
}
