package com.company;

import java.util.Scanner;

public class View {
    public void showInterface() {
        boolean menuFlag = true;
        System.out.println("Let's create a planet! Type in a new planet's name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Planet newPlanet = new Planet(name);
        while(menuFlag) {
            System.out.println("Options: ");
            System.out.println("1. Planet's name.");
            System.out.println("2. Quantity of continents.");
            System.out.println("3. Add a continent");
            System.out.println("4. Add an ocean");
            System.out.println("5. Add an island");
            System.out.println("6. All info about the planet");
            System.out.println("0. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println(newPlanet.getName());
                    break;
                case "2":
                    System.out.println(newPlanet.getQuantityOfContinents());
                    break;
                case "3":
                    System.out.println("Enter new continent's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new continent's area: ");
                    double area = scanner.nextDouble();
                    System.out.println("Enter new continent's population: ");
                    long population = scanner.nextLong();
                    newPlanet.addContinent(new Continent(name, area, population));
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Enter new ocean's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new ocean's area: ");
                    area = scanner.nextDouble();
                    System.out.println("Enter new ocean's volume: ");
                    double volume = scanner.nextDouble();
                    newPlanet.addOcean(new Ocean(name, area, volume));
                    scanner.nextLine();
                    break;
                case "5":
                    System.out.println("Enter new island's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new island's area: ");
                    area = scanner.nextDouble();
                    System.out.println("Enter new island's population: ");
                    population = scanner.nextLong();
                    newPlanet.addIsland(new Island(name, area, population));
                    scanner.nextLine();
                    break;
                case "6":
                    System.out.println(newPlanet);
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
