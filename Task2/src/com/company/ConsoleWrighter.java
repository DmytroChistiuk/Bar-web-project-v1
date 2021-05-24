package com.company;

public class ConsoleWrighter implements Writer{
    @Override
    public void write(String value) {
        System.out.println(value);
    }
}
