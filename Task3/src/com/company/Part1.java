package com.company;

import com.company.utils.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static final String QUERY="SELECT car_brand,color,price FROM hw_lesson3.car WHERE price <15000 AND (color='white' OR color ='black');";
        public static List<Car> findPart1() throws SQLException {
            List <Car> cars = new ArrayList<>();
            Connection connection = MySQLUtil.getConnection();
                PreparedStatement prepareStatement = connection.prepareStatement(QUERY);
                ResultSet resultSet = prepareStatement.executeQuery(QUERY);
                while (resultSet.next()) {
                    Car car = new Car();
                    String car_brand = resultSet.getString("car_brand");
                    String color = resultSet.getString("color");
                    int price = resultSet.getInt("price");
                    car.setCar_brand(car_brand);
                    car.setColor(color);
                    car.setPrice(price);
                    cars.add(car);
                }
            return cars;
    }}
