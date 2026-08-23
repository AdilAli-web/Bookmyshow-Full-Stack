package org.example.config;

import java.sql.*;

public class DBConfig {

   static String url="jdbc:mysql://localhost:3306/spark6";
   static String pass="root";
   static String userName="root";

    public static Statement getInstance()
    {
        try {
            Connection connection= DriverManager.getConnection(url,userName,pass);

            Statement statement= connection.createStatement();
            return statement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection()
    {
        Connection connection=null;
        try {
             connection= DriverManager.getConnection(url,userName,pass);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return connection;
    }
}
