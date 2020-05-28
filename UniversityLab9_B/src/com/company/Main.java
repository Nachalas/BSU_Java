package com.company;

import com.company.model.Disc;
import com.company.model.Serializer;
import com.company.model.Song;
import com.company.model.SongStyle;
import com.company.view.View;

public class Main {
    public static void main(String[] args) {
//        Disc disc = new Disc("My collection of music");
//        Song song1 = new Song("New age", "Celldweller", (short) 335, SongStyle.EDM);
//        Song song2 = new Song("Adrenaline", "Shinedown", (short) 206, SongStyle.ROCK);
//        Song song3 = new Song("Happy Little Boozer", "Korpiklaani", (short) 215, SongStyle.ROCK);
//        Song song4 = new Song("Children of the sea", "Black Sabbath", (short) 334, SongStyle.ROCK);
//        disc.add(song1);
//        disc.add(song2);
//        disc.add(song3);
//        disc.add(song4);
//        Serializer serializer = new Serializer();
//        serializer.serialize(disc);

        View view = new View();
        view.showInterface();
    }
}
