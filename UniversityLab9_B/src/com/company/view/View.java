package com.company.view;

import com.company.model.Disc;
import com.company.model.Serializer;
import com.company.model.Song;
import com.company.model.SongStyle;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public void showInterface() {
        boolean menuFlag = true;
        Scanner scanner = new Scanner(System.in);
        Serializer serializer = new Serializer();

        Disc disc;

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
                    disc = serializer.deserialize();
                    System.out.println(disc);
                    break;
                case "2":
                    disc = serializer.deserialize();
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
                    SongStyle style = SongStyle.valueOf(scanner.nextLine());
                    disc = serializer.deserialize();
                    disc.add(new Song(name, performer, length, style));
                    serializer.serialize(disc);
                    break;
                case "4":
                    disc = serializer.deserialize();
                    disc.sortByStyle();
                    serializer.serialize(disc);
                    break;
                case "5":
                    System.out.println("Enter minimum length:");
                    short min = scanner.nextShort();
                    scanner.nextLine();
                    System.out.println("Enter maximum length:");
                    short max = scanner.nextShort();
                    scanner.nextLine();
                    disc = serializer.deserialize();
                    ArrayList<Song> temp = disc.findCompositionsByRange(min, max);
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
