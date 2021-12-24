package com.connect.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;  

public class Database {
    String url = "jdbc:mysql://127.0.0.1:3306/csedconnections";
    String username = "root";
    String password = "arduino-010";

    void checkForanexistingmail(){
        
    }

    void checkDataSignin(){
        System.out.println("Connecting database...");
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=connection.createStatement();
/*
            int m = statement.executeUpdate("insert into student(email ,name,password) values ('omar@gmail.com' , 'ahmed' ,'1234')");
            if (m==1)
                System.out.println("inserted successfully ");
            else
                System.out.println("insertion failed");
*/
            ResultSet result=statement.executeQuery("select graduate.name ,graduate.email ,graduate.imageURL,experience.company ,experience.location"+
                                                    " from graduate JOIN experience "+ 
                                                    "on experience.email=graduate.email;");  

            while(result.next())  
                System.out.println(result.getString("email"));  
                
            connection.close();  
            System.out.println("Database connection closed!");
        } 
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    List<DisplayedGrads> getGraduates(){
        List<DisplayedGrads> displayedGrads = new ArrayList<>();

        System.out.println("Connecting database...");
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=connection.createStatement();

            ResultSet tuple=statement.executeQuery("select graduate.name ,graduate.email ,graduate.imageURL,experience.company ,experience.location"+
                                                    " from graduate JOIN experience "+ 
                                                    "on experience.email=graduate.email;");  

            
            
            
            while(tuple.next()){
                DisplayedGrads gradtemp = new DisplayedGrads();
                try {
                    gradtemp.company = tuple.getString("company") ;
                    gradtemp.email = tuple.getString("email") ;
                    gradtemp.img = tuple.getString("imageURL") ;
                    gradtemp.location = tuple.getString("location") ;
                    gradtemp.name = tuple.getString("name") ;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                //System.out.println(gradtemp.name);
                displayedGrads.add(gradtemp) ;
    
            } 
            
            connection.close();  
            System.out.println("Database connection closed!");
        } 
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return displayedGrads;
    }

}
