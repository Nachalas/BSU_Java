package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleArrayInput {
    public ArrayList<Integer> input() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число элементов");
        int quantity = in.nextInt();
        ArrayList<Integer> listToReturn = new ArrayList<>();
        System.out.println("Введите " + quantity + " элементов: ");
        for(int i = 0; i < quantity; i++) {
            int temp = in.nextInt();
            listToReturn.add(temp);
        }
        return listToReturn;
    }
}
