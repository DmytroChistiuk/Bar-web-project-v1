package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.WeatherData;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WeatherDataScanner {
    public WeatherData apiToClass(String text) throws IOException {
        String link = "https://api.openweathermap.org/data/2.5/weather?q=";
        String link2 = "&appid=92650366df9034eb77c16cf7c6064cc0";
        String spec = link + text + link2;
        URL url = new URL(spec);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(sc.next());
        }
        String result = sb.toString();

        result = result.replaceAll("<[^>]*>", "");


        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result, WeatherData.class);
    }
}
