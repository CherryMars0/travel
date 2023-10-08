package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    private String username;
    private int id;
    private String password;
    public User(@JsonProperty("id")int id, @JsonProperty("username")String username, @JsonProperty("password")String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
