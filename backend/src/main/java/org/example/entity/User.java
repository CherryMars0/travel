package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    private String userName;
    private String id;
    private String password;
    public User(String id, @JsonProperty("username")String username, @JsonProperty("password")String password) {
        this.id = id;
        this.userName = username;
        this.password = password;
    }
}
