package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

public class Part1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10);
            list.add(randomNumber);
        }
        System.out.println(list);
        OptionalDouble result = list.stream().mapToDouble(number -> number * number).average();
        System.out.println(result);

    }
}
