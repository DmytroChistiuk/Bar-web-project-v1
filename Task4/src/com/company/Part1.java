package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Part1 {


    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> domenMap = new HashMap<>();
       String[] arrayDomens = ArrayOfDomenFromFile().toArray(new String[0]);
       HashMap<String,Integer> additionalMap = new HashMap<>();
        for (int i = 0; i < arrayDomens.length; i++) {
            additionalMap.put(arrayDomens[i],1);
        }
        int itarator=0;
        for (int i = 0; i < arrayDomens.length; i++) {
            for (Map.Entry<String,Integer> entry:additionalMap.entrySet()){
                if (arrayDomens[i].equals(entry.getKey()))
                {
                   itarator = entry.getValue();
                   itarator++;
                    domenMap.remove(arrayDomens[i]);
                    domenMap.put(arrayDomens[i],itarator);
                }
                else {
                    domenMap.put(arrayDomens[i],1);
                }

            }
        }
        for (Map.Entry<String,Integer> entry:domenMap.entrySet()){
        System.out.println("Сколько раз встречается ["+entry.getValue() + "] ~~ Что встречается ["+ entry.getKey()+"]");
        }
    }


    public static List<String> ArrayOfDomenFromFile() throws IOException {
        FileReader fileReader = new FileReader("urls.txt");
        Scanner scanner = new Scanner(fileReader);
        List<String> arrayDomens =new ArrayList<>();
        String[] separ;
while (scanner.hasNextLine())
{separ = scanner.nextLine().split("/");
arrayDomens.add(separ[0]);
}
fileReader.close();
        return arrayDomens;

    }
}
