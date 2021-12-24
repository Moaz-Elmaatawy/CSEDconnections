package com.connect.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;  

public class Database {
    String url = "jdbc:mysql://127.0.0.1:3306/csedconnections";
    String username = "root";
    String password = "arduino-010";

    public static void main(String[] args) {
        //Device varibles
        
        
    }
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

    ArrayList<ResultSet> getGraduates(){
        ArrayList<ResultSet>resultQuery=new ArrayList<>();
        System.out.println("Connecting database...");
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=connection.createStatement();

            ResultSet tuple=statement.executeQuery("select graduate.name ,graduate.email ,graduate.imageURL,experience.company ,experience.location"+
                                                    " from graduate JOIN experience "+ 
                                                    "on experience.email=graduate.email;");  

            while(tuple.next())
                resultQuery.add(tuple);  
            //System.out.println(tuple.getString("email"));  
                
            connection.close();  
            System.out.println("Database connection closed!");
        } 
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return resultQuery;
    }

}
