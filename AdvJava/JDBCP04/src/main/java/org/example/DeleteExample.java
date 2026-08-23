package org.example;

import org.example.config.DBConfig;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteExample {

    public static void main(String[] args) {
        try {
            Statement statement = DBConfig.getInstance();
            int row = statement.executeUpdate("DELETE FROM employee where id=4");
            System.out.println(row+ " row deleted");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
