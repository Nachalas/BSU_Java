package com.company;

import java.util.Scanner;

public class View {
    boolean menuFlag = true;
    Scanner scanner = new Scanner(System.in);
    NumberCollection numberCollection = new NumberCollection();

    public void showInterface() {
        while (menuFlag) {
            System.out.println("1. All collection");
            System.out.println("2. Add a number");
            System.out.println("3. Delete a number");
            System.out.println("4. Find nearest to a number");
            System.out.println("5. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println(numberCollection.toString());
                    break;
                case "2":
                    System.out.println("Enter a number:");
                    double number = scanner.nextDouble();
                    scanner.nextLine();
                    numberCollection.addNumber(number);
                    break;
                case "3":
                    System.out.println("Enter a number:");
                    number = scanner.nextDouble();
                    scanner.nextLine();
                    numberCollection.removeNumber(number);
                    break;
                case "4":
                    System.out.println("Enter a number:");
                    number = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(numberCollection.findNearest(number));
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
