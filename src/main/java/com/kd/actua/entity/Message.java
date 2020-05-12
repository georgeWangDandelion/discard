package com.kd.actua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class Message {

    private String name;

    private String status;

    private Map<String,List<Parameter>>[] id_messages;

}
