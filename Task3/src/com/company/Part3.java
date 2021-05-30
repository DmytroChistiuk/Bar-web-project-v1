package com.company;

import com.company.utils.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Part3 {
    public static final String QUERY="SELECT firstTable.order_number,firstTable.client_name,firstTable.car_brand,secondTable.price from carorder as firstTable left join car as secondTable on firstTable.car_brand = secondTable.car_brand";
    public static List<Car> findPart3() throws SQLException {
        List <Car> cars = new ArrayList<>();
        Connection connection = MySQLUtil.getConnection();
        Statement statement = connection.prepareStatement(QUERY);
        ResultSet resultSet = statement.executeQuery(QUERY);
        while (resultSet.next()) {
            Car car = new Car();
            int order_number = resultSet.getInt("order_number");
            String car_brand = resultSet.getString("car_brand");
            String client_name = resultSet.getString("client_name");
            int price = resultSet.getInt("price");
            car.setOrder_number(order_number);
            car.setCar_brand(car_brand);
            car.setClient_name(client_name);
            car.setPrice(price);

            cars.add(car);
        }
        return cars;
    }}


