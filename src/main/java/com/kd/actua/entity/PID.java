package com.kd.actua.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PID {

    private Property propertie;

    private String[] activeProfiles;

    private PropertySource[] propertySources;

}
