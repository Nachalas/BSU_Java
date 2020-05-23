package com.company.view;

import com.company.db.DatabaseManufacturerDao;
import com.company.db.DatabaseSouvenirDao;
import com.company.entity.Manufacturer;
import com.company.entity.Souvenir;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class View {
    public void showInterface() {
        Logger.getLogger("com.zaxxer.hikari.pool.PoolBase").setLevel(Level.ERROR);
        Logger.getLogger("com.zaxxer.hikari.pool.HikariPool").setLevel(Level.ERROR);
        Logger.getLogger("com.zaxxer.hikari.HikariDataSource").setLevel(Level.ERROR);
        Logger.getLogger("com.zaxxer.hikari.HikariConfig").setLevel(Level.ERROR);
        Logger.getLogger("com.zaxxer.hikari.util.DriverDataSource").setLevel(Level.ERROR);

        DatabaseManufacturerDao databaseManufacturerDao = new DatabaseManufacturerDao();
        DatabaseSouvenirDao databaseSouvenirDao = new DatabaseSouvenirDao();

        Scanner scanner = new Scanner(System.in);

        boolean menuFlag = true;

        while (menuFlag) {
            System.out.println("Choose an option: ");
            System.out.println("1. All manufacturers");
            System.out.println("2. All souvenirs");
            System.out.println("3. Add a souvenir");
            System.out.println("4. Add a manufacturer");
            System.out.println("5. Show manufacturer's products");
            System.out.println("6. Show souvenirs made in a certain country");
            System.out.println("7. Show manufacturers with prices less than");
            System.out.println("8. Show manufacturers of a certain souvenir made at a certain date");
            System.out.println("9. Delete a certain manufacturer and it's souvenirs");
            System.out.println("10. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    Iterable<Manufacturer> manufacturers = databaseManufacturerDao.getAll();
                    for(var i : manufacturers) {
                        System.out.println(i);
                    }
                    break;
                case "2":
                    Iterable<Souvenir> souvenirs = databaseSouvenirDao.getAll();
                    for(var i : souvenirs) {
                        System.out.println(i);
                    }
                    break;
                case "3":
                    long id = databaseSouvenirDao.getLastID() + 1;
                    System.out.println("Enter a name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter a manufacturer's ID: ");
                    long mf_id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter a date: ");
                    String date = scanner.nextLine();
                    System.out.println("Enter a price: ");
                    long price = scanner.nextLong();
                    scanner.nextLine();
                    databaseSouvenirDao.insert(new Souvenir(id, name, mf_id, date, price));
                    break;
                case "4":
                    id = databaseManufacturerDao.getLastID() + 1;
                    System.out.println("Enter a name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter a country: ");
                    String country = scanner.nextLine();
                    databaseManufacturerDao.insert(new Manufacturer(id, name, country));
                    break;
                case "5":
                    System.out.println("Enter a manufacturer's id: ");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    souvenirs = databaseSouvenirDao.getByManufacturer(id);
                    for(var i : souvenirs) {
                        System.out.println(i);
                    }
                    break;
                case "6":
                    System.out.println("Enter a country: ");
                    country = scanner.nextLine();
                    souvenirs = databaseSouvenirDao.getByCountry(country);
                    for(var i : souvenirs) {
                        System.out.println(i);
                    }
                    break;
                case "7":
                    System.out.println("Enter a price: ");
                    price = scanner.nextLong();
                    scanner.nextLine();
                    manufacturers = databaseManufacturerDao.getByPrice(price);
                    for(var i : manufacturers) {
                        System.out.println(i);
                    }
                    break;
                case "8":
                    System.out.println("Enter a souvenir's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter a date: ");
                    date = scanner.nextLine();
                    manufacturers = databaseManufacturerDao.getByNameAndDate(name, date);
                    for(var i : manufacturers) {
                        System.out.println(i);
                    }
                    break;
                case "9":
                    System.out.println("Enter a manufacturer's id: ");
                    id = scanner.nextLong();
                    scanner.nextLine();
                    databaseManufacturerDao.deleteByID(id);
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
