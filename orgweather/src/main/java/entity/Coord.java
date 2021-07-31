package entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coord {
    private double lon;
    private double lat;

    @JsonCreator
    public Coord(@JsonProperty("lon") double lon, @JsonProperty("lat") double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Координаты:" +
                "Долгота [" + lon + "]" +
                ", Широта [" + lat + "]";
    }
}