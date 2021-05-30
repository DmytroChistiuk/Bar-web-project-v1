package com.company;

import com.company.utils.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static final String QUERY="SELECT car_brand, sum(price) FROM hw_lesson3.car WHERE color='black'AND price<10000 group by car_brand";
    public static List<Car> findPart2() throws SQLException {
        List <Car> cars = new ArrayList<>();
        Connection connection = MySQLUtil.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(QUERY);
        ResultSet resultSet = prepareStatement.executeQuery(QUERY);
        while (resultSet.next()) {
            Car car = new Car();
            String car_brand = resultSet.getString("car_brand");
            int sumPrice = resultSet.getInt("sum(price)");
            car.setCar_brand(car_brand);
            car.setSumPrice(sumPrice);
            cars.add(car);
        }
        return cars;
    }
        }
