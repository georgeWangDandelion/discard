package com.kd.actua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Measurement {

    private String statistic;

    private double value;
}
