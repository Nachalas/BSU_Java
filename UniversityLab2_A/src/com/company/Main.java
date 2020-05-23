package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выполнил: Моргунов Владислав 9 группа 2 курс");
        System.out.println("Получено: ???");
        Date date = new Date();
        System.out.println("Сдано: " + date);

        ConsoleArrayInput input = new ConsoleArrayInput();
        ArrayList<Integer> test = input.input();
        OperationsWithNumbers testOperations = new OperationsWithNumbers();
        int quantity = testOperations.FindEvenDigitsOnlyNumbers(test);
        System.out.println("Количество элементов только с чётными цифрами - " + quantity);
        quantity = testOperations.FindNumbersWithEqualQuantityOfEvenAndNonEven(test);
        System.out.println("Количество элементов с равным количеством чётных и нечётных цифр - " + quantity);
    }
}
