package com.company.model;

import java.util.ArrayList;

public class Disc {
    private final String delim = "-";

    private long ID;
    private String name;

    public Disc(long id, String name){
        this.ID = id;
        this.name = name;
    }

    public Disc(String name) {
        this.name = name;
    }

    public Disc() {}

    @Override
    public String toString() {
        String toReturn =  ID + ". Disc \"" + name + "\"";
        return toReturn;
    }

    public long getID() { return ID; }
    public String getName() { return name; }
}
