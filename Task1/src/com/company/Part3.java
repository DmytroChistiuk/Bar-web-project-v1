package com.company;

public class Part3 {
   private static String returnString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=30; i++) {
           sb.append("("+i+")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(returnString());
    }
}
