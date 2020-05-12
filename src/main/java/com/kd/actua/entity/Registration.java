package com.kd.actua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Registration {
    private String name;

    private String managementUrl;

    private String serviceUrl;

    private String source;

    private Metadata metadata;
}
