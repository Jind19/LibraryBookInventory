package com.tracker;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private String genre;
    private double price;
    private int copies;
    private boolean digital;

    public Book(String title, String author, String genre, double price, int copies, boolean digital) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.copies = copies;
        this.digital = digital;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public int getCopies() {
        return copies;
    }

    public boolean isDigital() {
        return digital;
    }

    @Override
    public String toString() {
        return "Book: " +
                "(title= " + title +
                ", price= $ " + price +
                " )";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true; // Reference equality
        if (o == null || getClass() != o.getClass()) return false; // ensure exact class match
        Book book = (Book) o; //  you know o is a Book, Safe cast o to Book

        /**
         * Two Books are equal if their title fields are equal.
         * Objects.equals(...) safely handles null, so you don’t need to manually check for nulls.
         * */
        return Objects.equals(title, book.title);
    }
}
