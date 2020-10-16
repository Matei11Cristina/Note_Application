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

/**
 *
 * @author cristina
 */
public class TagDAO {
    
    private static TagDAO instance;
public static TagDAO getInstance() {
if (instance == null) {
instance = new TagDAO();
}
return instance;
}
private TagDAO() {}

public List<Tag> InsertTag(String name, String note, String user) {
String sql="INSERT INTO tag(name,note,user) VALUES ('"+name+"','"+note+"','"+user+"');";
List<Tag> tags = new ArrayList<>();
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
return tags;
}

public List<Notes> getTagNote(String name) {
String sql="SELECT * FROM notes LEFT JOIN tag ON notes.id = tag.note WHERE tag.name LIKE '%"+name+"%';";
List<Notes> tags = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){

ResultSet rs = prepStmt.executeQuery();
while (rs.next()) {
tags.add(new Notes(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getString("date"),rs.getString("status"),rs.getString("user"),rs.getString("location"),rs.getString("fileName"),rs.getString("sharedFrom")));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return tags;
}

public List<Tag> getTag(String note) {
String sql="SELECT * FROM tag WHERE note='"+note+"';";
List<Tag> tags = new ArrayList<>();
try (Connection connection=Connection1.getConnection();
PreparedStatement prepStmt = connection.prepareStatement(sql);
){

ResultSet rs = prepStmt.executeQuery();
while (rs.next()) {
tags.add(new Tag(rs.getString("id"),rs.getString("name"),rs.getString("note"),rs.getString("user")));
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return tags;
}

    
}
