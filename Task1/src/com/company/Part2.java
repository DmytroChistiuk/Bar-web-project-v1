package com.company;

import java.util.Random;

public class Part2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int [] mas = new int[10];
        double average=0;
        for (int i = 0; i < mas.length; i++) {
            mas[i]=rand.nextInt(11)+10;
            average+=mas[i];
        }
        System.out.println(average/mas.length);
    }
}
