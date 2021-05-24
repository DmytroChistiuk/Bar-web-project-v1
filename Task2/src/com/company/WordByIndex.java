package com.company;

public class WordByIndex implements StringWorker {
       public int execute(String sentence, String word){
            char[] symbolsFromSentence = sentence.toCharArray();
            char[] symbolsFromWord = word.toCharArray();
            for (int i = 0; i < symbolsFromSentence.length; i++) {
                for (int j = 0; j < symbolsFromWord.length; j++){
                    if (symbolsFromSentence[i]==symbolsFromWord[j]&&symbolsFromSentence[i+1]==symbolsFromWord[j+1]){
                        return i+1;
                    }
                }
        }
           return 0;
    }
}
