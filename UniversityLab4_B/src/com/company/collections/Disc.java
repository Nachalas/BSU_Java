package com.company.collections;

import com.company.composition.Composition;
import com.company.composition.CompositionStyle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Disc extends Collection<Composition> {
    private final String delim = "-";

    private String name;

    {
        setDatabaseLoc("database/songs.txt");
    }

    public Disc(String name){
        this.name = name;
    }
    public Disc() {}

    protected Composition parseItem(String input) {
        StringTokenizer st = new StringTokenizer(input, delim);
        String name = st.nextToken();
        String performer = st.nextToken();
        Short length = Short.parseShort(st.nextToken());
        CompositionStyle style = CompositionStyle.valueOf(st.nextToken());
        return new Composition(name, performer, length, style);
    }

    @Override
    public String toString() {
        String toReturn =  "Disc \"" + name + "\":" + "\n";
        int id = 0;
        for(var i : collection) {
            id++;
            toReturn += id + ". " + i.toString() + "\n";
        }
        return toReturn;
    }

    public int countLength() {
        int finalLength = 0;
        for (var i : collection) {
            finalLength += i.getLength();
        }
        return finalLength;
    }

    public ArrayList<Composition> findCompositionsByRange(short min, short max) {
        ArrayList<Composition> toReturn = new ArrayList<>();
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
                CompositionStyle lhs = collection.get(i).getStyle();
                CompositionStyle rhs = collection.get(i + 1).getStyle();
                if(lhs.toString().compareTo(rhs.toString()) < 0) {
                    isSorted = false;

                    Composition temp = collection.get(i);
                    collection.set(i, collection.get(i+1));
                    collection.set(i+1, temp);
                }
            }
        }
    }
}
