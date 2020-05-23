package com.company.view;

import com.company.mobile.GalaxyA50;
import com.company.mobile.SamsungMobile;

import java.util.Scanner;

public class View {
    public void showInterface() {
        boolean menuFlag = true;
        Scanner scanner = new Scanner(System.in);
        SamsungMobile galaxyA50 = new GalaxyA50((byte)4, (short)128);

        while (menuFlag) {
            System.out.println("1. Turn on.");
            System.out.println("2. Turn off.");
            System.out.println("3. Call.");
            System.out.println("4. Exit.");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    galaxyA50.turnOn();
                    break;
                case "2":
                    galaxyA50.turnOff();
                    break;
                case "3":
                    galaxyA50.call();
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
