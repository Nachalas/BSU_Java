package com.company;

import java.util.Scanner;

public class View {
    boolean menuFlag = true;
    Scanner scanner = new Scanner(System.in);
    GradeHandler gradeHandler = new GradeHandler();

    public void showInterface() {
        while (menuFlag) {
            System.out.println("1. Renew students");
            System.out.println("2. Add a student");
            System.out.println("3. Find student with specific average mark");
            System.out.println("4. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    gradeHandler.renewStudents();
                    break;
                case "2":
                    System.out.println("Enter a new student:");
                    String student = scanner.nextLine();
                    gradeHandler.addStudent(student);
                    break;
                case "3":
                    System.out.println("Enter an average mark:");
                    double average = scanner.nextDouble();
                    scanner.nextLine();
                    gradeHandler.makeItalic(average);
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
