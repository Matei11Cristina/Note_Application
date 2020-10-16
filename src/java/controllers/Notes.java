/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;



/**
 *
 * @author cristina
 */
public class Notes {
    private String id;
    private String name;
    private String description;
    private String date;
    private String status;
    private String user;
    private String location;
    private String fileName;
    private String sharedFrom;

    public Notes( String id, String name, String description, String date, String status, String user, String location, String fileName, String sharedFrom) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
        this.user = user;
        this.location = location;
        this.fileName = fileName;
        this.sharedFrom = sharedFrom;
    }

    public String getSharedFrom() {
        return sharedFrom;
    }

    public void setSharedFrom(String sharedFrom) {
        this.sharedFrom = sharedFrom;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
