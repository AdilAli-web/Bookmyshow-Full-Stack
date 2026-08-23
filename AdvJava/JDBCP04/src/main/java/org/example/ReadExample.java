package org.example;

import java.sql.*;

public class ReadExample {

    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/spark6";
        String pass="root";
        String userName="root";
        String sql="SELECT * from employee";

        try {
            Connection connection= DriverManager.getConnection(url,userName,pass);

            Statement statement= connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String dep=resultSet.getString("dep");
                double sal=resultSet.getDouble("sal");


                System.out.println(
                        id + " | "+
                        name + " | "+
                        dep + " | "+
                        sal
                );
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
