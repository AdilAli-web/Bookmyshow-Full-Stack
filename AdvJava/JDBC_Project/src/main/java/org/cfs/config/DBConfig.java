package org.cfs.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {

   static String url="jdbc:mysql://localhost:3306/jdbc_project01";
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
