package com.company;

import com.company.MyStack;

import java.util.Scanner;
import java.util.Stack;

public class View {
    public void showInterface() {

        MyStack myStack = new MyStack();

        Scanner scanner = new Scanner(System.in);

        boolean menuFlag = true;

        while (menuFlag) {
            System.out.println("Choose an option: ");
            System.out.println("1. Show all elements");
            System.out.println("2. Add a number");
            System.out.println("3. Get last element");
            System.out.println("4. Pop last element");
            System.out.println("5. Get element at index");
            System.out.println("6. Set element at index");
            System.out.println("7. Remove at index???");
            System.out.println("8. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    Stack<Integer> stack = myStack.getStack();
                    String output = "";
                    for(var i : stack) {
                        output += i + " ";
                    }
                    System.out.println(output);
                    break;
                case "2":
                    System.out.println("Enter a number: ");
                    Integer number = scanner.nextInt();
                    scanner.nextLine();
                    myStack.push(number);
                    break;
                case "3":
                    System.out.println("Last element: " + myStack.getLast());
                    break;
                case "4":
                    myStack.pop();
                    break;
                case "5":
                    System.out.println("Enter an index: ");
                    Integer index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(myStack.get(index));
                    break;
                case "6":
                    System.out.println("Enter an index: ");
                    index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter a new value: ");
                    Integer newValue = scanner.nextInt();
                    scanner.nextLine();
                    myStack.set(index, newValue);
                    break;
                case "7":
                    System.out.println("Enter an index: ");
                    index = scanner.nextInt();
                    scanner.nextLine();
                    myStack.delete(index);
                    break;
                default:
                    menuFlag = false;
                    break;
            }
        }
    }
}
