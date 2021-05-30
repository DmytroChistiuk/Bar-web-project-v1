package com.company;

import java.sql.SQLException;
import java.util.Arrays;

import static com.company.Part1.findPart1;
import static com.company.Part2.findPart2;
import static com.company.Part3.findPart3;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Задание 1: Вывод бренда, цвета, цены автомобиля, который имеет цвет белый или черный и имеет цену менее 15000.");
        for (Car car : findPart1()) {
            System.out.println(car.showPart1());
        }
System.out.println("Задание 2: Вывод общей стоимости черных автомобилей в разрезе бренда, но на сумму не больше 10000. Выводит только бренд и общую стоимость.");
        for (Car car : findPart2()) {
           System.out.println(car.showPart2());
        }

        System.out.println("Задание 3: Вывод номер заказа, имя клиента, бренд автомобиля и цену.");
        for (Car car : findPart3()) {
            System.out.println(car.showPart3());
        }
    }
}
