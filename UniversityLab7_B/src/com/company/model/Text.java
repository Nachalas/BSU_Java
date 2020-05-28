package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Text {
    String fullText;
    List<Sentence> sentences = new ArrayList<>();

    public Text(String input) {
        fullText = input.replaceAll("\\s+", " ");
        String [] rawSentences = fullText.split("\\.");
        for(var i : rawSentences) {
            sentences.add(new Sentence(i.trim()));
        }
    }

    public void swapFirstAndLast() {
        for(var i : sentences) {
            i.swapFirstAndLast();
        }
    }

    @Override
    public String toString() {
        String toReturn = "";
        boolean isFirst = true;
        for(var i : sentences) {
            if(!isFirst) {
                toReturn += " ";
            }
            toReturn += i.toString() + ".";
            isFirst = false;
        }
        return toReturn;
    }
}
