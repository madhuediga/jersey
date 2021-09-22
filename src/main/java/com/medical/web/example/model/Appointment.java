package com.medical.web.example.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("Appointment")
public class Appointment {

    @PrimaryKey
    private  int id;

    private String name;

    private String email;

    private String date;

    private String startTime;

    private  String description;

    private String regTime;

}
