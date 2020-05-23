package com.company;

import java.io.*;
import java.lang.constant.Constable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Planet {
    private final String CONTINENTS = "database/continents.txt";
    private final String ISLANDS = "database/islands.txt";
    private final String OCEANS = "database/oceans.txt";

    private String name;

//    public Planet(String name, List<Continent> continents, List<Ocean> oceans, List<Island> islands) {
//        this.name = name;
//        this.continents = continents;
//        this.oceans = oceans;
//        this.islands = islands;
//    }

    public Planet(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Continent> getContinents() {
        ArrayList<Continent> toReturn = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTINENTS))) {
            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                toReturn.add(parseContinent(tempLine));
            }
            return toReturn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public List<Ocean> getOceans() {
        ArrayList<Ocean> toReturn = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(OCEANS))) {
            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                toReturn.add(parseOcean(tempLine));
            }
            return toReturn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public List<Island> getIslands() {
        ArrayList<Island> toReturn = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ISLANDS))) {
            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                toReturn.add(parseIsland(tempLine));
            }
            return toReturn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public Continent getContinentByName(String name) {
        List<Continent> continents = getContinents();
        for(var i : continents) {
            if( i.getName().equals(name) ) {
                return i;
            }
        }
        throw new NoSuchContinentException();
    }

    public Continent getContinentByPopulation(long population) {
        List<Continent> continents = getContinents();
        for(var i : continents) {
            if( i.getPopulation() == population ) {
                return i;
            }
        }
        throw new NoSuchContinentException();
    }

    public void addContinent(Continent continent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTINENTS, true))) {
            writer.write(continent.toStringFileFormat());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addOcean(Ocean ocean) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OCEANS, true))) {
            writer.write(ocean.toStringFileFormat());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addIsland(Island island) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ISLANDS, true))) {
            writer.write(island.toStringFileFormat());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String listToString(String listName, List list) {

        String toReturn = "";
        toReturn += listName + ": \n";
        for(var i : list) {
            toReturn += i + " ";
        }
        toReturn += "\n";
        return toReturn;
    }

    @Override
    public String toString() {
        List<Continent> continents = getContinents();
        List<Island> islands = getIslands();
        List<Ocean> oceans = getOceans();
        String toReturn = "Planet: " + name + "\n";
        toReturn += listToString("Continents", continents);
        toReturn += listToString("Oceans", oceans);
        toReturn += listToString("Islands", islands);
        return toReturn;
    }

    public Ocean parseOcean(String input) {
        StringTokenizer st = new StringTokenizer(input, "-");
        String name = st.nextToken();
        double area = Double.parseDouble(st.nextToken());
        double volume = Double.parseDouble(st.nextToken());
        return new Ocean(name, area, volume);
    }

    public Continent parseContinent(String input) {
        StringTokenizer st = new StringTokenizer(input, "-");
        String name = st.nextToken();
        double area = Double.parseDouble(st.nextToken());
        long population = Long.parseLong(st.nextToken());
        return new Continent(name, area, population);
    }

    public Island parseIsland(String input) {
        StringTokenizer st = new StringTokenizer(input, "-");
        String name = st.nextToken();
        double area = Double.parseDouble(st.nextToken());
        long population = Long.parseLong(st.nextToken());
        return new Island(name, area, population);
    }
}
