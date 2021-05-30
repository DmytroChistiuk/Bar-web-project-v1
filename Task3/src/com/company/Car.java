package com.company;

public class Car {
    private int price;
    private String color;
    private String car_brand;
    private String client_name;
    private int order_number;
    private int sumPrice;

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String showPart2() {
        return "{car_brand=" + car_brand + ", " + "sumPrice=" +
                sumPrice +
                '}';
    }
    public String showPart1() {
        return "{car_brand=" + car_brand + ", " + "price=" + price + ", "+ "color=" + color+'}';
    }

    public String showPart3() {
        return "{order_number="+order_number+ ", " +"client_name="+client_name + ", " +"car_brand=" + car_brand + ", " + "price=" + price +'}';
    }
}
