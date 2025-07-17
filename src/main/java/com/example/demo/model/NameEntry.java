package com.example.demo.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameEntry {
    private Integer id;
    private String name;

    public NameEntry() {}

    public NameEntry(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
