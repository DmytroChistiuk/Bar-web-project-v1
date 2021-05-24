package com.company;
import java.util.Arrays;
public class NumberWordsAfterDeletion implements StringWorker{
    public int execute(String sentence, String word) {
        char[] symbolsFromSentence = sentence.toCharArray();
        char[] symbolsFromWord = word.toCharArray();
        return symbolsFromSentence.length-symbolsFromWord.length;
        }
    }
