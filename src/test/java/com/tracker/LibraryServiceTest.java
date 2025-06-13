package com.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Provider;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryServiceTest {

    private LibraryService service;
    private List<Book> sampleBooks;

    @BeforeEach
    void setUp() {
        service = new LibraryService();
        sampleBooks = Arrays.asList(
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 10.99, 12, true),
                new Book("1984", "George Orwell", "Dystopian", 8.99, 5, true),
                new Book("Clean Code", "Robert Martin", "Programming", 32.5, 3, false)
        );
    }

    @Test
    void testFilterLowStock(){
        List<Book> lowStock = service.filterLowStock(sampleBooks, 8);
        assertEquals(2, lowStock.size());
    }

    @Test
    void testCalculateTotalValue(){
        double totalValue = service.calculateTotalValue(sampleBooks);
        assertEquals(10.99*12 + 8.99*5 + 32.5*3, totalValue);
    }

    @Test
    void testFindMostExpensive() {
        assertTrue(service.findMostExpensive(sampleBooks).isPresent());
        assertEquals("Clean Code", service.findMostExpensive(sampleBooks).get().getTitle());
    }
}
