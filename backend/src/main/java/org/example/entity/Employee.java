package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class Employee {
    private String employeeId;
    private String userName;
    private String gender;
    private int age;
    private String baseSalary;
    private String locationId;

    public Employee(@JsonProperty("employeeId")String employeeId, @JsonProperty("userName")String userName,
                    @JsonProperty("gender")String gender, @JsonProperty("age")int age,
                    @JsonProperty("baseSalary")String baseSalary, @JsonProperty("locationId")String locationId) {
        this.employeeId = employeeId;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.baseSalary = baseSalary;
        this.locationId = locationId;
    }
}
