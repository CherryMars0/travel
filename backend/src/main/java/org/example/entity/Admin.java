package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Admin {
    private String id;
    private String name;
    private String password;

    public Admin(@JsonProperty("id")String id, @JsonProperty("name")String name, @JsonProperty("password")String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
