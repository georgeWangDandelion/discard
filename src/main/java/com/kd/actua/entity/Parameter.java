package com.kd.actua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Data
public class Parameter {

    public Parameter(String description) {
        this.description = description;
    }

    private String name;

    private String description;

    private TimeUnit baseUnit;

    private Measurement[] measurements;

    private AvaliableTag[] availableTags;
}
