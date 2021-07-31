package test;

import util.WeatherDataScanner;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        WeatherDataScanner weatherDataScanner = new WeatherDataScanner();
        System.out.println(weatherDataScanner.apiToClass("Paris").toString());

    }
}
