package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BookArray array = new BookArray();
        ArrayList<Book> test = array.findBooksByAuthor("Fyodor Dostoyevsky");
        for(var i : test) {
            System.out.println(i);
        }
    }
}
