package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Scenic {
    private String name;
    private String img;
    private String area;
    private String price;
    private String point;
    private String id;
    private String hot;
    private String intro;
    private String address;
    private String level;
    private String sold;

    public Scenic(@JsonProperty("name")String name,
                  @JsonProperty("img")String img,
                  @JsonProperty("area")String area,
                  @JsonProperty("price")String price,
                  @JsonProperty("point")String point,
                  @JsonProperty("id")String id,
                  @JsonProperty("hot")String hot,
                  @JsonProperty("intro")String intro,
                  @JsonProperty("address")String address,
                  @JsonProperty("level")String level,
                  @JsonProperty("sold")String sold){
        this.name = name;
        this.img = img;
        this.area = area;
        this.price = price;
        this.point = point;
        this.id = id;
        this.hot = hot;
        this.intro = intro;
        this.address = address;
        this.level = level;
        this.sold = sold;



    }
}
