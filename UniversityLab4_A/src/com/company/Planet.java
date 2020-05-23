package com.company;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planet {
    private String name;
    private List<Continent> continents;
    private List<Ocean> oceans;
    private List<Island> islands;

//    public Planet(String name, List<Continent> continents, List<Ocean> oceans, List<Island> islands) {
//        this.name = name;
//        this.continents = continents;
//        this.oceans = oceans;
//        this.islands = islands;
//    }

    public Planet(String name) {
        this.name = name;
        continents = new ArrayList<Continent>();
        oceans = new ArrayList<Ocean>();
        islands = new ArrayList<Island>();
    }

    public int getQuantityOfContinents() {
        return continents.size();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Continent> getContinents() { return continents; }
    public void setContinents(List<Continent> continents) { this.continents = continents; }

    public List<Ocean> getOceans() { return oceans; }
    public void setOceans(List<Ocean> oceans) { this.oceans = oceans; }

    public List<Island> getIslands() { return islands; }
    public void setIslands(List<Island> islands) { this.islands = islands; }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public void addOcean(Ocean ocean) {
        oceans.add(ocean);
    }

    public void addIsland(Island island) {
        islands.add(island);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(continents, planet.continents) &&
                Objects.equals(oceans, planet.oceans) &&
                Objects.equals(islands, planet.islands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continents, oceans, islands);
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
        String toReturn = "Planet: " + name + "\n";
        toReturn += listToString("Continents", continents);
        toReturn += listToString("Oceans", oceans);
        toReturn += listToString("Islands", islands);
        return toReturn;
    }
}
