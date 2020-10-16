/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;


public class NoteDAO {
    
    private static NoteDAO instance;
public static NoteDAO getInstance() {
if (instance == null) {
instance = new NoteDAO();
}
return instance;
}
private NoteDAO() {}


public List<Notes> getNoteUser(String user) {
String sql="SELECT * FROM notes WHERE user= '"+user+"' and status != 'shared' and status != 'trash'";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){

ResultSet rs = prepStmt.executeQuery();
while (rs.next()) {
notes.add(new Notes(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getString("date"),rs.getString("status"),rs.getString("user"),rs.getString("location"),rs.getString("fileName"),rs.getString("sharedFrom")));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}


public List<Notes> getNotes() {
    
String sql="SELECT * FROM notes";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
ResultSet rs = prepStmt.executeQuery();
while (rs.next()) {
notes.add(new Notes(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getString("date"),rs.getString("status"),rs.getString("user"),rs.getString("location"),rs.getString("fileName"),rs.getString("sharedFrom")));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}

public List<Notes> getNotesSearch(String getSearch, String user) {
    
String sql="SELECT * FROM notes WHERE (name LIKE '%"+getSearch+"%' OR description LIKE '%"+getSearch+"%') and user = '"+user+"'";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
ResultSet rs = prepStmt.executeQuery();
while (rs.next()) {
notes.add(new Notes(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getString("date"),rs.getString("status"),rs.getString("user"),rs.getString("location"),rs.getString("fileName"),rs.getString("sharedFrom")));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}

public List<Notes> getNotesShared(String user) {
    
String sql="SELECT * FROM notes WHERE user = '"+user+"' and status = 'shared'";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
ResultSet rs = prepStmt.executeQuery();
while (rs.next()) {
notes.add(new Notes(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getString("date"),rs.getString("status"),rs.getString("user"),rs.getString("location"),rs.getString("fileName"),rs.getString("sharedFrom")));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}

public List<Notes> getNoteId(String id) {
    
String sql="SELECT * FROM notes WHERE id = '"+id+"'";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
ResultSet rs = prepStmt.executeQuery();
while (rs.next()) {
notes.add(new Notes(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getString("date"),rs.getString("status"),rs.getString("user"),rs.getString("location"),rs.getString("fileName"),rs.getString("sharedFrom")));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}

public List<Notes> getNoteStatus(String user) {
    
String sql="SELECT * FROM notes WHERE status = 'trash' and user = '"+user+"'";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
ResultSet rs = prepStmt.executeQuery();
while (rs.next()) {
notes.add(new Notes(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getString("date"),rs.getString("status"),rs.getString("user"),rs.getString("location"),rs.getString("fileName"),rs.getString("sharedFrom")));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}

public List<Notes> EditNote(String id,String name, String description, String status, String user, String path, String filePath) {
String sql="UPDATE notes SET name='"+name+"', description='"+description+"', date=now(),status='"+status+"',user='"+user+"',location='"+path+"',fileName='"+filePath+"' WHERE id='"+id+"';";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
prepStmt.executeUpdate();
//while (rs.next()) {
//ads.add(new Ads(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getString("date"), rs.getString("category"), rs.getString("user"), rs.getString("fileName")));
//}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}

public List<Notes> EditNoteStatus(String id,String status) {
String sql="UPDATE notes SET status='"+status+"' WHERE id='"+id+"';";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
prepStmt.executeUpdate();
//while (rs.next()) {
//ads.add(new Ads(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getString("date"), rs.getString("category"), rs.getString("user"), rs.getString("fileName")));
//}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}

public List<Notes> DeleteNote(String id) {
String sql="DELETE FROM notes WHERE id='"+id+"';";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
prepStmt.executeUpdate();
//while (rs.next()) {
//ads.add(new Ads(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getString("date"), rs.getString("category"), rs.getString("user"), rs.getString("fileName")));
//}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}

public List<Notes> InsertNote(String name, String description, String date, String status, String user, String location, String fileName, String sharedFrom) {
String sql="INSERT INTO notes(name,description,date,status,user,location,fileName,sharedFrom) VALUES ('"+name+"','"+description+"','"+date+"','"+status+"','"+user+"','"+location+"','"+fileName+"','"+sharedFrom+"');";
List<Notes> notes = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){
prepStmt.executeUpdate();
//while (rs.next()) {
//ads.add(new Ads(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getString("date"), rs.getString("category"), rs.getString("user"), rs.getString("fileName")));
//}
} catch (SQLException ex) {
ex.printStackTrace();
}
return notes;
}
    
}
