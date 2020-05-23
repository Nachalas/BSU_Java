package com.company.collections;

import com.company.composition.Composition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Collection<E> {
    protected ArrayList<E> collection;
    protected String DB_Destination;

    public Collection() {
        collection = new ArrayList<E>();
    }

    public void addItem(E item) {
        collection.add(item);
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_Destination))) {
            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                E temp = parseItem(tempLine);
                collection.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace(); //Мб поменяю на лог
        }
    }

    protected abstract E parseItem(String input);

    public void setDatabaseLoc(String loc) { DB_Destination = loc; }

    public List<E> getCollection() {
        return collection;
    }
}
