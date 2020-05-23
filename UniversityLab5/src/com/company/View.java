package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class View {
    boolean menuFlag = true;
    Scanner scanner = new Scanner(System.in);
    Department department = new Department();
    Department.Logger logger = department.new Logger();
    Department.Worker worker = new Department.Worker("1", "1", "1");
    String position = "1";

    Department anonymous = new Department() {
        public String description = "An anonymous department";

        @Override
        public void getOpen() {
            System.out.println("An anonymous department has opened! Its description is: " + description);
        }
    };

    public void showInterface() {
        while (menuFlag) {
            System.out.println("1. Create a new worker");
            System.out.println("2. Change position");
            System.out.println("3. Touch general class");
            System.out.println("4. Touch anonymous class");
            System.out.println("5. Current position");
            System.out.println("6. Position history");
            System.out.println("7. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Enter a name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter a surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter a position:");
                    position = scanner.nextLine();
                    worker = new Department.Worker(name, surname, position);
                    logger.update(worker, position);
                    break;
                case "2":
                    System.out.println("Enter new position:");
                    position = scanner.nextLine();
                    logger.update(worker, position);
                    break;
                case "3":
                    department.getOpen();
                    break;
                case "4":
                    anonymous.getOpen();
                    break;
                case "5":
                    Map<Department.Worker, String> temp = logger.getCurrentPositions();
                    System.out.println(temp.get(worker));
                    break;
                case "6":
                    System.out.println("Enter a position:");
                    position = scanner.nextLine();
                    Map<String, ArrayList<Department.Worker>> tempH = logger.getPositionHistory();
                    ArrayList<Department.Worker> tempList = tempH.get(position);
                    if(tempList != null) {
                        for(var i : tempList) {
                            System.out.println(i.getName() + " " + i.getSurname());
                        }
                    } else {
                        System.out.println("No history found");
                    }
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
