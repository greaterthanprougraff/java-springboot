package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameEntryTest {

    @Test
    void testConstructorAndGetters() {
        NameEntry entry = new NameEntry(1, "Alice");
        assertEquals(1, entry.getId());
        assertEquals("Alice", entry.getName());
    }

    @Test
    void testSetters() {
        NameEntry entry = new NameEntry();
        entry.setId(2);
        entry.setName("Bob");
        assertEquals(2, entry.getId());
        assertEquals("Bob", entry.getName());
    }
}
