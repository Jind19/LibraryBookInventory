package com.tracker;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryService {

    /**
     * Filters Books by low stock.
     */
    public List<Book> filterLowStock(List<Book> inventory, int minQty){
        return inventory.stream()
                .filter(p -> p.getCopies() < minQty)
                .collect(Collectors.toList());
    }

    /**
     * Returns all book titles in uppercase, sorted, and with no duplicates.
     *
     * @param inventory the list of books
     * @return a list of unique, sorted, uppercase book titles
     */
    public List<String> listAllTitlesUppercaseSortedUnique(List<Book> inventory) {
        return inventory.stream()
                .map(book -> book.getTitle().toUpperCase())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Group Books by genre.
     */
    public Map<String, List<Book>> groupByGenre(List<Book> inventory){
        return inventory.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    /**
     * Partition books into digital vs physical
     */
    public Map<Boolean, List<Book>> partitionByDigitalVsPhysical(List<Book> inventory){
        return inventory.stream()
                .collect(Collectors.partitioningBy(Book::isDigital));
    }

    /**
     * Calculate total inventory value (price × copies) using reduce
     */
    public double calculateTotalValue(List<Book> inventory){
        // Check with if else, throw exceptions in such a case, then use stream
        return inventory.stream()
                .map(book -> book.getPrice() * book.getCopies()) // Intermediate: map
                .reduce(0.0, Double::sum); // Terminal: reduce
    }

    /**
     * Find Book with max price.
     */
    public Optional<Book> findMostExpensive(List<Book> inventory){
        return inventory.stream()
                .max(Comparator.comparing(Book::getPrice)); // Terminal: max
    }


}
