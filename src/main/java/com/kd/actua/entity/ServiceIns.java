package com.kd.actua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceIns {

    private String name;

    private String buildVersion;

    private String status;

    private Date statusTimestamp;

    private Instance[] instances;

}
