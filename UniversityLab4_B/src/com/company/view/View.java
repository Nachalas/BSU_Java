package com.company.view;

import com.company.collections.Disc;
import com.company.composition.Composition;
import com.company.composition.CompositionStyle;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public void showInterface() {
        boolean menuFlag = true;
        Scanner scanner = new Scanner(System.in);
        Disc disc = new Disc("Best collection of 2019");
        disc.readFromFile();

        while (menuFlag) {
            System.out.println("1. Disc info.");
            System.out.println("2. Disc length.");
            System.out.println("3. Add a new song.");
            System.out.println("4. Sort compositions by style.");
            System.out.println("5. Find compositions by length range.");
            System.out.println("6. Exit.");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println(disc);
                    break;
                case "2":
                    System.out.println("Overall length = " + disc.countLength()/60 + ":" + disc.countLength()%60);
                    break;
                case "3":
                    System.out.println("Enter new song's title:");
                    String name = scanner.nextLine();
                    System.out.println("Enter new song's performer:");
                    String performer = scanner.nextLine();
                    System.out.println("Enter new song's length:");
                    short length = scanner.nextShort();
                    scanner.nextLine();
                    System.out.println("Enter new song's style:");
                    CompositionStyle style = CompositionStyle.valueOf(scanner.nextLine());
                    disc.addItem(new Composition(name, performer, length, style));
                    break;
                case "4":
                    disc.sortByStyle();
                    break;
                case "5":
                    System.out.println("Enter minimum length:");
                    short min = scanner.nextShort();
                    scanner.nextLine();
                    System.out.println("Enter maximum length:");
                    short max = scanner.nextShort();
                    scanner.nextLine();
                    ArrayList<Composition> temp = disc.findCompositionsByRange(min, max);
                    if (temp.size() != 0) {
                        for(var i : temp) {
                            System.out.println(i);
                        }
                    } else {
                        System.out.println("No songs with needed range found");
                    }
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
