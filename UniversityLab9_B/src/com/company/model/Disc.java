package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Disc implements Serializable {
    private String name;
    private ArrayList<Song> collection = new ArrayList<>();
    private transient String description = "This is a useless information";

    public Disc(String name) { this.name = name; }

    public String toString() {
        String toReturn =  "Disc \"" + name + "\":" + "\n";
        int id = 0;
        for(var i : collection) {
            id++;
            toReturn += id + ". " + i.toString() + "\n";
        }
        return toReturn;
    }

    public void add(Song song) {
        collection.add(song);
    }

    public int countLength() {
        int finalLength = 0;
        for (var i : collection) {
            finalLength += i.getLength();
        }
        return finalLength;
    }

    public ArrayList<Song> findCompositionsByRange(short min, short max) {
        ArrayList<Song> toReturn = new ArrayList<>();
        for(var i : collection) {
            short length = i.getLength();
            if (length >= min && length <= max) {
                toReturn.add(i);
            }
        }
        return toReturn;
    }

    public void sortByStyle() {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < collection.size()-1; i++) {
                SongStyle lhs = collection.get(i).getStyle();
                SongStyle rhs = collection.get(i + 1).getStyle();
                if(lhs.toString().compareTo(rhs.toString()) < 0) {
                    isSorted = false;

                    Song temp = collection.get(i);
                    collection.set(i, collection.get(i+1));
                    collection.set(i+1, temp);
                }
            }
        }
    }
}