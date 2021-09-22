package com.medical.web.example.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("admin")
public class Admin {

    @PrimaryKey
    private int id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private boolean enabled;

    private String confirmationToken;

    private String gender;

    private  String role;

    private String lastSeen;
}
