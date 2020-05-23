package com.company;

import java.util.Objects;
import java.util.StringTokenizer;

public class Continent {
    protected String name;
    protected double areaSquareKilometers;
    protected long population;

    public Continent() {
        this.name = "";
        this.areaSquareKilometers = 0;
        this.population = 0;
    }

    public Continent(String name, double area, long population) {
        this.name = name;
        this.areaSquareKilometers = area;
        this.population = population;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getAreaSquareKilometers() { return areaSquareKilometers; }
    public void setAreaSquareKilometers(double areaSquareKilometers) { this.areaSquareKilometers = areaSquareKilometers; }

    public long getPopulation() { return population; }
    public void setPopulation(long population) { this.population = population; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Double.compare(continent.areaSquareKilometers, areaSquareKilometers) == 0 &&
                population == continent.population &&
                Objects.equals(name, continent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, areaSquareKilometers, population);
    }

    @Override
    public String toString() {
        return name + ", " +
                "Area = " + areaSquareKilometers + "sq. km., " +
                "Population = " + population + "\n";
    }

    public String toStringFileFormat() {
        String delim = "-";
        return name + delim + areaSquareKilometers + delim + population;
    }
}
