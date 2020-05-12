package com.kd.actua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Instance {

    private String id;

    private int version;

    private Registration registration;

    private boolean registered;

    private StatusInfo statusInfo;

    private Date statusTimestamp;

    private Info info;

    private Endpoint[] endpoints;

    private String buildVersion;

    private Tags tags;
}

