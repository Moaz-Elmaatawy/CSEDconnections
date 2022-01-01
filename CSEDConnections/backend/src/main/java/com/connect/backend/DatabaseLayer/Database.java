package com.connect.backend.DatabaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connect.backend.Controllers.DisplayedGrads;
import com.connect.backend.Controllers.Experience;
import com.connect.backend.Controllers.Graduate;
import com.connect.backend.Controllers.Student;

public class Database {
    private String url = "jdbc:mysql://127.0.0.1:3306/csedconnections";
    private String username = "root";
    private String password = "root";
    private String tableName;

    public Database() {
    }

    public Database(char type) {
        tableName = (type == 'S') ? "student" : "graduate";
    }

    public boolean signIn(String email, String pass) {

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("select email" +
                    " from " + tableName +
                    " where email = '" + email + "'" +
                    " AND password = '" + pass + "'");

            boolean exist = result.next();

            connection.close();
            System.out.println("Database connection closed!");
            return exist;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public boolean existsBefore(String email) {

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            System.out.println("select email" +
                    " from " + tableName +
                    " where email = '" + email + "'");
            ResultSet result = statement.executeQuery("select email" +
                    " from " + tableName +
                    " where email = '" + email + "'");

            boolean exist = result.next();

            connection.close();
            System.out.println("Database connection closed!");
            return exist;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public boolean signUp(Graduate graduate) {
        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            Experience experience = graduate.experience.get(0);
            try {
                String query = "insert into graduate values ('" + graduate.mail + "' , '" + graduate.name + "' , '"
                        + graduate.birhtDate
                        + "' , '" + graduate.gender + "' , '" + graduate.phone + "' , '" + graduate.password + "' , '"
                        + graduate.img + "' , '"
                        + graduate.about + "' , '" + graduate.graduationYear + "' )";
                System.out.println(query);
                statement.executeUpdate(query);
                statement.executeUpdate(
                        "insert into experience values ('" + graduate.mail + "' , '" + experience.companyName + "' , '"
                                + experience.location + "' , '" + experience.position + "','" + experience.startDate
                                + "','" + experience.endDate + "')");
            } catch (Exception e) {
                System.out.println("insertion failed");
                return false;
            }

            System.out.println("inserted successfully ");
            connection.close();
            System.out.println("Database connection closed!");
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public boolean signUp(Student student) {
        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            System.out.println("inserted successfully ");
            connection.close();
            System.out.println("Database connection closed!");
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public List<DisplayedGrads> getGraduates() {
        List<DisplayedGrads> displayedGrads = new ArrayList<>();

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet tuple = statement.executeQuery(
                    "select graduate.name ,graduate.email ,graduate.imageURL,experience.company ,experience.location" +
                            " from graduate JOIN experience " +
                            "on experience.email=graduate.email;");

            while (tuple.next()) {
                DisplayedGrads gradtemp = new DisplayedGrads();
                try {
                    gradtemp.company = tuple.getString("company");
                    gradtemp.email = tuple.getString("email");
                    gradtemp.img = tuple.getString("imageURL");
                    gradtemp.location = tuple.getString("location");
                    gradtemp.name = tuple.getString("name");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // System.out.println(gradtemp.name);
                displayedGrads.add(gradtemp);

            }

            connection.close();
            System.out.println("Database connection closed!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return displayedGrads;
    }

}
