package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    @JsonProperty("temp")
    private int temp;
    @JsonProperty("feels_like")
    private int feels_like;
    @JsonProperty("temp_min")
    private int temp_min;
    @JsonProperty("temp_max")
    private int temp_max;

    public Main(@JsonProperty(" temp") int temp, @JsonProperty("feels_like") int feels_like,@JsonProperty("temp_min") int temp_min,@JsonProperty("temp_max") int temp_max) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    @Override
    public String toString() {
        return "Данные по температуре:" +
                "Teмпература=" + temp +
                ", Ощущается как=" + feels_like +
                ", Минимальная температура=" + temp_min +
                ", Максимальная температура=" + temp_max;

    }
}
