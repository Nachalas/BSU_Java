package com.company.model;

import java.util.ArrayList;

public class Sentence {
    String fullSentence;
    ArrayList<Word> words = new ArrayList<>();

    public Sentence(String input) {
        fullSentence = input;
        String [] rawWords = input.split(" ");
        for(var i : rawWords) {
            words.add(new Word(i.trim()));
        }
    }

    public void swapFirstAndLast() {
        Word temp = words.get(words.size() - 1);
        words.set(words.size() - 1, words.get(0));
        words.set(0, temp);
    }

    @Override
    public String toString() {
        String toReturn = "";
        boolean isFirst = true;
        for(var i : words) {
            if(!isFirst) {
               toReturn += " ";
            }
            toReturn += i.toString();
            isFirst = false;
        }
        return toReturn;
    }
}
