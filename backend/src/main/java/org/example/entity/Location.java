package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {
    private String locationId;
    private String locationName;
    private String latitude;
    private String longitude;
    public Location(@JsonProperty("locationId")String locationId, @JsonProperty("locationName")String locationName,
                    @JsonProperty("latitude")String latitude, @JsonProperty("longitude")String longitude) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
