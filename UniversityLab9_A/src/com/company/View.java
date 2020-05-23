package com.company;

import java.util.Scanner;

public class View {
    public void showInterface() {
        boolean menuFlag = true;
        Scanner scanner = new Scanner(System.in);
        StringHandler stringHandler = new StringHandler();

        while (menuFlag) {
            System.out.println("1. Read from file");
            System.out.println("2. Find occurrences");
            System.out.println("3. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    stringHandler.readFromFile();
                    break;
                case "2":
                    stringHandler.findBiggestSubstring();
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
