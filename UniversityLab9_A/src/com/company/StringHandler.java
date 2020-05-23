package com.company;

import java.io.*;
import java.util.ArrayList;

public class StringHandler {
    private final String INPUT = "F:/java epam/UniversityLab9_A/database/Files.txt";
    private String stringInput, stringOutput;
    public ArrayList<String> strings = new ArrayList<>();

    public StringHandler() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT))) {
            stringInput = reader.readLine();
            stringOutput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(stringInput))) {
            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                strings.add(tempLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findBiggestSubstring() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(stringOutput))) {
            for(var i : strings) {
                int maxOccurences = 0;
                for(int j = 0; j < i.length() - 1; j++) {
                    char temp = i.charAt(j);
                    int occurences = 0;
                    while(temp >= '0' && temp <= '9' && j != i.length() - 1) {
                        occurences++;
                        j++;
                        temp = i.charAt(j);
                    }
                    if(j == i.length() - 1 && (temp >= '0' && temp <= '9')) {
                        occurences++;
                    }
                    maxOccurences = Math.max(maxOccurences, occurences);
                }
                writer.write("" + maxOccurences);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
