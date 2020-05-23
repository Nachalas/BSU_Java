package com.company;

import java.util.ArrayList;

public class BookArray {
    ArrayList<Book> array = new ArrayList<>();

    public void Append(Book input) {
        array.add(input);
    }

    public ArrayList<Book> findBooksByAuthor(String inputAuthor) {
        ArrayList<Book> finalList = new ArrayList<>();
        for(var i : array) {
            if(i.getWrittenBy() == inputAuthor) {
                finalList.add(i);
            }
        }
        return finalList;
    }

    public ArrayList<Book> findBooksByPublisher(String inputPublisher) {
        ArrayList<Book> finalList = new ArrayList<>();
        for(var i : array) {
            if(i.getPublisher() == inputPublisher) {
                finalList.add(i);
            }
        }
        return finalList;
    }

    public ArrayList<Book> findBooksPublishedAfterYear(int inputYear) {
        ArrayList<Book> finalList = new ArrayList<>();
        for(var i : array) {
            if(i.getYear() > inputYear) {
                finalList.add(i);
            }
        }
        return finalList;
    }

    public BookArray() {
        array.add(new Book(1, "In Search of Lost Time", "Marcel Proust", "Publisher 1", 1913, 4215, 25, BindingType.HARD));
        array.add(new Book(2, "Ulysses", "James Joyce", "Publisher 1", 1992, 730, 35, BindingType.HARD));
        array.add(new Book(3, "Don Quixote", "Miguel de Cervantes", "Publisher 2", 1665, 863, 30, BindingType.HARD));
        array.add(new Book(4, "The Great Gatsby", "F. Scott Fitzgerald", "Publisher 2", 1925, 218, 25, BindingType.HARD));
        array.add(new Book(5, "One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Publisher 3", 1967, 228, 40, BindingType.HARD));
        array.add(new Book(5, "The Brothers Karamazov", "Fyodor Dostoyevsky", "Publisher 3", 1880, 228, 40, BindingType.HARD));
        array.add(new Book(5, "Crime and Punishment", "Fyodor Dostoyevsky", "Publisher 3", 1866, 228, 50, BindingType.HARD));
    }

    public ArrayList<Book> getArray() {
        return array;
    }
}
