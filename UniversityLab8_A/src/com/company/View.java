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
            System.out.println("1. Add a continent");
            System.out.println("2. Add an ocean");
            System.out.println("3. Add an island");
            System.out.println("4. Find continent by name");
            System.out.println("5. Find continent by population");
            System.out.println("228. All info about the planet");
            System.out.println("0. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Enter new continent's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new continent's area: ");
                    double area = scanner.nextDouble();
                    System.out.println("Enter new continent's population: ");
                    long population = scanner.nextLong();
                    newPlanet.addContinent(new Continent(name, area, population));
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.println("Enter new ocean's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new ocean's area: ");
                    area = scanner.nextDouble();
                    System.out.println("Enter new ocean's volume: ");
                    double volume = scanner.nextDouble();
                    newPlanet.addOcean(new Ocean(name, area, volume));
                    scanner.nextLine();
                    break;
                case "3":
                    System.out.println("Enter new island's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new island's area: ");
                    area = scanner.nextDouble();
                    System.out.println("Enter new island's population: ");
                    population = scanner.nextLong();
                    newPlanet.addIsland(new Island(name, area, population));
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Enter a name to search:");
                    name = scanner.nextLine();
                    try {
                        System.out.println(newPlanet.getContinentByName(name));
                    } catch (NoSuchContinentException e) {
                        System.out.println("No continent with such name");
                    }
                    break;
                case "5":
                    System.out.println("Enter what population to search:");
                    String populationString = scanner.nextLine();
                    try {
                        population = Long.parseLong(populationString);
                        try {
                            System.out.println(newPlanet.getContinentByPopulation(population));
                        } catch (NoSuchContinentException e) {
                            System.out.println("No continent with needed population");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong number format");
                    }
                    break;
                case "228":
                    System.out.println(newPlanet);
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
