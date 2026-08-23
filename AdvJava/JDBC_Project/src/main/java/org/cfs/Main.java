package org.cfs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        StudentService service=new StudentService();
        int choice;

        do {
            System.out.println();
            System.out.println("==== Student Management System");

            System.out.println("1. Add Student");
            System.out.println("2. View All Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.println("Enter your choice");

            choice=scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter student Id: ");
                    int id=scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter student name:");
                    String name=scanner.nextLine();

                    System.out.println("Enter student email:");
                    String email=scanner.nextLine();

                    System.out.println("Enter course name:");
                    String course=scanner.nextLine();

                    System.out.println("Enter marks:");
                    double marks=scanner.nextDouble();

                    Student student= new Student(id,name,email,course,marks);
                    service.addStudent(student);
                    break;

                case 2:
                    service.viewAllStudent();
                    break;

                case 3:
                    System.out.println("Enter student Id: ");
                    int newId=scanner.nextInt();
                    scanner.nextLine();
                    service.searchStudent(newId);
                    break;

                case 6:
                    System.out.println("Application closed.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }



        }while (choice!=6);
        scanner.close();

    }
}
