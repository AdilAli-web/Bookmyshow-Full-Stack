package org.example.dynamic;

import org.example.config.DBConfig;

import java.sql.*;
import java.util.Scanner;

public class InsertExample {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter id: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter name: ");
        String name=scanner.nextLine();

        System.out.println("Enter department: ");
        String dep=scanner.nextLine();

        System.out.println("Enter salary: ");
        double sal=scanner.nextDouble();

       /* String sql="INSERT into employee VALUES("+
                id+", '"+name +"', '"+dep+"', "+sal+ ")";*/

        String sql= """
                INSERT INTO employee (id, name,dep,sal) VALUES(?,?,?,?)
                """;

        System.out.println(sql);

        try {
            Connection connection = DBConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,dep);
            preparedStatement.setDouble(4,sal);

            int row = preparedStatement.executeUpdate();

            System.out.println(row+ " Emp inserted");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
}
