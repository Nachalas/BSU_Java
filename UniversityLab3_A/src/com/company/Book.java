package com.company;

import java.util.Scanner;

public class Book {
    public long ID;
    public String name;
    public String writtenBy;
    public String publisher;
    public int year;
    public int pages;
    public int price;
    public BindingType bindingType;

    public Book() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ID:");
        ID = in.nextLong();
        System.out.println("Введите название:");
        name = in.nextLine();
        System.out.println("Введите автора:");
        writtenBy = in.nextLine();
        System.out.println("Введите издателя:");
        publisher = in.nextLine();
        System.out.println("Введите год издания:");
        year = in.nextInt();
        System.out.println("Введите количество страниц:");
        pages = in.nextInt();
        System.out.println("Введите цену:");
        price = in.nextInt();
        System.out.println("Введите тип переплёта:");
        bindingType = bindingType.valueOf(in.next().toUpperCase());
    }

    public Book(long ID, String name, String writtenBy, String publisher, int year, int pages, int price, BindingType bindingType) {
        this.ID = ID;
        this.name = name;
        this.writtenBy = writtenBy;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("ID=").append(ID);
        sb.append(", name='").append(name).append('\'');
        sb.append(", writtenBy='").append(writtenBy).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", year=").append(year);
        sb.append(", pages=").append(pages);
        sb.append(", price=").append(price);
        sb.append(", bindingType=").append(bindingType);
        sb.append('}');
        return sb.toString();
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBindingType(BindingType bindingType) {
        this.bindingType = bindingType;
    }
}
