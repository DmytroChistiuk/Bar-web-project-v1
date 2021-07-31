package entity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("main")
    private Main main;

    @JsonCreator
    public WeatherData(@JsonProperty("wind") Wind wind,
                       @JsonProperty("coord") Coord coord,
                       @JsonProperty("weather") List<Weather> weather,
                       @JsonProperty("main") Main main) {
        this.coord = coord;
        this.wind = wind;
        this.weather = weather;
        this.main = main;

    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return   "{"+coord +";\n " + wind+ ";\n " + weather+";\n " + main +
                '}';
    }
}
