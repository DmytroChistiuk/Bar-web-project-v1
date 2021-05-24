package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
NumberOfRepetitions numberOfRepetitions = new NumberOfRepetitions();
WordByIndex wordByIndex = new WordByIndex();
NumberWordsAfterDeletion numberWordsAfterDeletion = new NumberWordsAfterDeletion();
ConsoleWrighter consoleWrighter =new ConsoleWrighter();
FileWrighter fileWrighter = new FileWrighter();
String value = String.valueOf(numberOfRepetitions.execute("I like walking in the park","in")) +" "
        + String.valueOf(wordByIndex.execute("I like walking in the park","in")) + " "
        + String.valueOf(numberWordsAfterDeletion.execute("I like walking in the park","in"));
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if(string.equals("консоль")){
consoleWrighter.write(value);
        }else if(string.equals("файл")){
fileWrighter.write(value);
        }else{
            System.out.println("Вы ввели что-то неправильно, перезапустите програму и попробуйте еще раз!");
        }



    }
}
