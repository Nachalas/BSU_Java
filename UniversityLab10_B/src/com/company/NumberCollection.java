package com.company;

import java.util.*;

public class NumberCollection {
    TreeSet<Double> numbers = new TreeSet<Double>();

    public void addNumber(double number) {
        numbers.add(number);
    }

    public double findNearest(double number) {
        double floor = numbers.floor(number);
        double ceiling = numbers.ceiling(number);
        double toFloor = Math.abs(number - floor);
        double toCeiling = Math.abs(number - ceiling);
        return toFloor < toCeiling ? floor : ceiling;
    }

    public void removeNumber(double number) {
        numbers.remove(number);
    }

    @Override
    public String toString() {
        String toReturn = "";
        for(var i : numbers) {
            toReturn += i + " ";
        }
        return toReturn;
    }
}
