package com.company;

import com.company.model.Text;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a text: ");
        String textStr = scanner.nextLine();
        Text text = new Text(textStr);
        System.out.println(text);
        text.swapFirstAndLast();
        System.out.println(text);
    }
}
