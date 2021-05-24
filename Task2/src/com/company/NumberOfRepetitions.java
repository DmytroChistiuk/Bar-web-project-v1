package com.company;

public class NumberOfRepetitions implements StringWorker{
    public int execute(String sentence, String word){
        int counter=0;
        String []arrayOfSentence = sentence.split(" ");
        for (int i = 0; i < arrayOfSentence.length; i++) {
            if (arrayOfSentence[i].equals(word)){
                counter++;
            }
        }
        return counter;
    }
}
