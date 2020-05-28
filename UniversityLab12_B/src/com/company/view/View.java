package com.company.view;

import com.company.dao.DatabaseDiscDao;
import com.company.dao.DatabaseSongDao;
import com.company.model.Composition;
import com.company.model.Disc;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class View {
    public void showInterface() {
        Logger.getLogger("com.zaxxer.hikari.pool.PoolBase").setLevel(Level.ERROR);
        Logger.getLogger("com.zaxxer.hikari.pool.HikariPool").setLevel(Level.ERROR);
        Logger.getLogger("com.zaxxer.hikari.HikariDataSource").setLevel(Level.ERROR);
        Logger.getLogger("com.zaxxer.hikari.HikariConfig").setLevel(Level.ERROR);
        Logger.getLogger("com.zaxxer.hikari.util.DriverDataSource").setLevel(Level.ERROR);

        Scanner scanner = new Scanner(System.in);

        boolean menuFlag = true;

        DatabaseDiscDao databaseDiscDao = new DatabaseDiscDao();
        DatabaseSongDao databaseSongDao = new DatabaseSongDao();

        while (menuFlag) {
            System.out.println("Choose an option: ");
            System.out.println("0. All discs with all songs");
            System.out.println("1. All discs");
            System.out.println("2. All songs");
            System.out.println("3. Add a disc");
            System.out.println("4. Add a song");
            System.out.println("5. Add a song to a disc");
            System.out.println("6. Count overall length of a disc");
            System.out.println("7. Find songs in a range");
            System.out.println("8. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    Iterable<Disc> discs = databaseDiscDao.getAll();
                    for(var i : discs) {
                        System.out.println(i);
                        Iterable<Composition> songs = databaseSongDao.findByDisc(i.getID());
                        for(var j : songs) {
                            System.out.println("  " + j);
                        }
                    }
                    break;
                case "1":
                    discs = databaseDiscDao.getAll();
                    for(var i : discs) {
                        System.out.println(i);
                    }
                    break;
                case "2":
                    Iterable<Composition> songs = databaseSongDao.getAll();
                    for(var i : songs) {
                        System.out.println(i);
                    }
                    break;
                case "3":
                    System.out.println("Enter a disc's name: ");
                    String name = scanner.nextLine();
                    databaseDiscDao.insert(new Disc(name));
                    break;
                case "4":
                    System.out.println("Enter a song's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter a performer: ");
                    String performer = scanner.nextLine();
                    System.out.println("Enter length of a song: ");
                    short length = scanner.nextShort();
                    scanner.nextLine();
                    System.out.println("Enter this song's style");
                    String style = scanner.nextLine();
                    databaseSongDao.insert(new Composition(name, performer, length, style));
                    break;
                case "5":
                    System.out.println("Enter a disc's ID: ");
                    long discID = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter a song's ID: ");
                    long songID = scanner.nextLong();
                    scanner.nextLine();
                    databaseDiscDao.addSongToDisc(songID, discID);
                    break;
                case "6":
                    System.out.println("Enter a disc's ID: ");
                    discID = scanner.nextLong();
                    scanner.nextLine();
                    Long result = databaseDiscDao.countLength(discID);
                    if(result != null) {
                        System.out.println("Disc's length: " + result / 60 + ":" + result % 60);
                    }
                    break;
                case "7":
                    System.out.println("Enter minimal length: ");
                    short minLen = scanner.nextShort();
                    scanner.nextLine();
                    System.out.println("Enter maximal length: ");
                    short maxLen = scanner.nextShort();
                    scanner.nextLine();
                    songs = databaseSongDao.findInRange(minLen, maxLen);
                    for(var i : songs) {
                        System.out.println(i);
                    }
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
