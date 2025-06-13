package com.tracker;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main( String[] args ) {

        List<Book> books = Arrays.asList(
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 10.99, 12, true),
                new Book("1984", "George Orwell", "Dystopian", 8.99, 5, true),
                new Book("Clean Code", "Robert Martin", "Programming", 32.5, 3, false),
                new Book("Effective Java", "Joshua Bloch", "Programming", 45.0, 7, false),
                new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 12.75, 10, true)
        );

        LibraryService service = new LibraryService();

        System.out.println("\nLow Stock (< 8):");
        service.filterLowStock(books, 8).forEach(System.out::println);

        System.out.println("\nBook Titles (Uppercase, Sorted):");
        service.listAllTitlesUppercaseSortedUnique(books).forEach(System.out::println);

        System.out.println("\nGrouped by Genre:");
        service.groupByGenre(books).forEach((k, v) -> {
            System.out.println(k + " => " + v);
        });

        System.out.println("\nPartitioned by Digital or Physical:");
        service.partitionByDigitalVsPhysical(books).forEach((k, v) -> {
            System.out.println((k ? "Digital" : "Physical") +  " => "  + v);
        });

        System.out.println("\nTotal Inventory Value:");
        System.out.println("$" + service.calculateTotalValue(books));

        System.out.println("\nMost Expensive Book:");
        service.findMostExpensive(books).ifPresent(System.out::println);
    }
}
