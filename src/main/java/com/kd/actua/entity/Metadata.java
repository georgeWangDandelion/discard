package com.kd.actua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Metadata {
    private String nacos_InstaceId;

    private String nacos_weight;

    private String nacos_cluster;

    private boolean nacos_healthy;

    private String preserved_register_source;


}
