package com.tma.documents;

import lombok.Data;

import java.util.UUID;

@Data
public class SingleCollection {

    private String id;
    private String name;

    public SingleCollection(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
