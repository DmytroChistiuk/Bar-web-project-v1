package entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    @JsonProperty("speed")
    private double speed;
    @JsonProperty("deg")
    private int deg;

    @JsonCreator
    public Wind(@JsonProperty("speed") double speed, @JsonProperty("deg") int deg) {
        this.speed = speed;
        this.deg = deg;

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Данные по ветру: " +
                "Cкорость ветра = " + speed +
                ", Дег = " + deg;
    }
}