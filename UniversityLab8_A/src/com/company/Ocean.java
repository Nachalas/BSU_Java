package com.company;

import java.util.Objects;
import java.util.StringTokenizer;

public class Ocean {
    private String name;
    private double areaMlnSquareKilometers;
    private double volumeMlnCubicKilometers;

    public Ocean(String name, double area, double volume) {
        this.name = name;
        this.areaMlnSquareKilometers = area;
        this.volumeMlnCubicKilometers = volume;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getAreaMlnSquareKilometers() { return areaMlnSquareKilometers; }
    public void setAreaMlnSquareKilometers(double areaMlnSquareKilometers) {
        this.areaMlnSquareKilometers = areaMlnSquareKilometers;
    }

    public double getVolumeMlnCubicKilometers() { return volumeMlnCubicKilometers; }
    public void setVolumeMlnCubicKilometers(double volumeMlnCubicKilometers) {
        this.volumeMlnCubicKilometers = volumeMlnCubicKilometers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocean ocean = (Ocean) o;
        return Double.compare(ocean.areaMlnSquareKilometers, areaMlnSquareKilometers) == 0 &&
                Double.compare(ocean.volumeMlnCubicKilometers, volumeMlnCubicKilometers) == 0 &&
                Objects.equals(name, ocean.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, areaMlnSquareKilometers, volumeMlnCubicKilometers);
    }

    @Override
    public String toString() {
        return name + ", " +
                "Area = " + areaMlnSquareKilometers + " sq.km." + ", " +
                "Volume = " + volumeMlnCubicKilometers + " km3" + "\n";
    }

    public String toStringFileFormat() {
        String delim =  "-";
        return name + delim + areaMlnSquareKilometers + delim + volumeMlnCubicKilometers;
    }
}
