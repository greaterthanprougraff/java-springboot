package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.NameEntry;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final Map<Integer, NameEntry> names = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    // GET /greeting/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getGreeting(@PathVariable int id) {
        log.info("Fetching greeting for ID: {}", id);
        NameEntry entry = names.get(id);
        if (entry != null) {
            return ResponseEntity.ok("Hello, " + entry.getName() + "!");
        } else {
            return ResponseEntity.status(404).body("No name allotted for this ID.");
        }
    }

    // POST /greeting
    @PostMapping
    public ResponseEntity<?> postGreeting(@RequestBody NameEntry payload) {
        log.info("Received POST with payload: {}", payload);
        String name = payload.getName();
        Integer id = payload.getId();

        if (name == null || name.isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required.");
        }

        if (id != null) {
            if (!names.containsKey(id)) {
                names.put(id, new NameEntry(id, name));
                return ResponseEntity.ok(new NameEntry(id, name));
            } else {
                int newId = idCounter.getAndIncrement();
                names.put(newId, new NameEntry(newId, name));
                return ResponseEntity.ok("ID " + id + " is not available. Name '" + name + "' added with new ID " + newId + ".");
            }
        } else {
            int newId = idCounter.getAndIncrement();
            names.put(newId, new NameEntry(newId, name));
            return ResponseEntity.ok(new NameEntry(newId, name));
        }
    }

    // PUT /greeting
    @PutMapping
    public ResponseEntity<?> putGreeting(@RequestBody NameEntry payload) {
        log.info("Received PUT with payload: {}", payload);
        int id = payload.getId();
        String newName = payload.getName();
        if (newName == null || newName.isEmpty()) {
            return ResponseEntity.badRequest().body("New name is required.");
        }
        NameEntry entry = names.get(id);
        if (entry != null) {
            entry.setName(newName);
            return ResponseEntity.ok(entry);
        } else {
            return ResponseEntity.status(404).body("No name allotted for this ID.");
        }
    }

    // DELETE /greeting/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGreeting(@PathVariable int id) {
        log.info("Deleting greeting for ID: {}", id);
        NameEntry entry = names.remove(id);
        if (entry != null) {
            return ResponseEntity.ok("Name for ID " + id + " deleted.");
        } else {
            return ResponseEntity.status(404).body("No name allotted for this ID.");
        }
    }
}