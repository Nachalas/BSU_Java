package com.company;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;

public class BubbleSort {
    public void BubbleSort(ArrayList<Integer> input) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < input.size()-1; i++) {
                if(abs(input.get(i)) > abs(input.get(i+1))){
                    isSorted = false;

                    int buf = input.get(i);
                    input.set(i, input.get(i+1));
                    input.set(i+1, buf);
                }
            }
        }
    }
}
