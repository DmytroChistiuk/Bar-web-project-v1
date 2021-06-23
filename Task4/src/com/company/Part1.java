package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.company.SortMapByValue.sortByValue;

public class Part1 {


    public static void main(String[] args) throws IOException {
        int itarator=0;
        HashMap<String,Integer> domenMap = new HashMap<>(); // мапа результирующих доменов
       String[] arrayDomens = ArrayOfDomenFromFile().toArray(new String[0]); // преобразуем лист в массив стрингов для удобства

        for (int i = 0; i < arrayDomens.length; i++) {
            if (domenMap.containsKey(arrayDomens[i])){
                itarator = domenMap.get(arrayDomens[i]);
                itarator++;
                domenMap.put(arrayDomens[i], itarator);
            }
                else {
                    domenMap.put(arrayDomens[i],1); // добавляем елемент, он встречается первый раз
                }

            }
        HashMap<String,Integer> sortedDomenMap = (HashMap<String, Integer>) sortByValue(domenMap);
        HashMap<String,Integer> map = new HashMap<>();
        int i=0;
        itarator=11;
        for (Map.Entry<String,Integer> entry: sortedDomenMap.entrySet()){ // выводим в консоль все домены и их частоту встречаемости
            if(sortedDomenMap.size()-i<=10){
                itarator--;
                System.out.println("The "+itarator+" place is ["+entry.getKey()+"], that occurs "+entry.getValue()+" times ");
                //System.out.println("Сколько раз встречается ["+entry.getValue() + "] ~~ Что встречается ["+ entry.getKey()+"]");
            }
            i++;
        }
    }


    public static List<String> ArrayOfDomenFromFile() throws IOException {
        // функция считывания с файла url
        // делим url по "/" получаем домены
        // записываем домены в Лист
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
