package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Guider {
    private String id;
    private String name;
    private String scope;
    private String address;
    private String desc;
    private String sex;
    private String qq;
    private String hot;

    public Guider(@JsonProperty("id")String id, @JsonProperty("name")String name,
                  @JsonProperty("scope")String scope, @JsonProperty("address")String address,
                  @JsonProperty("desc")String desc, @JsonProperty("sex")String sex,
                  @JsonProperty("qq")String qq, @JsonProperty("hot")String hot) {
        this.id = id;
        this.name = name;
        this.scope = scope;
        this.address = address;
        this.desc = desc;
        this.sex = sex;
        this.qq = qq;
        this.hot = hot;
    }
}
