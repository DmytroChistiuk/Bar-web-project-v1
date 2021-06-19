package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Part1 {


    public static void main(String[] args) throws IOException {
        int itarator=0;
        HashMap<String,Integer> domenMap = new HashMap<>(); // мапа результирующих доменов
       String[] arrayDomens = ArrayOfDomenFromFile().toArray(new String[0]); // преобразуем лист в массив стрингов для удобства
       HashMap<String,Integer> additionalMap = new HashMap<>(); // дополнительная мапа для переноса элемемнтов в результирующую мапу
        for (int i = 0; i < arrayDomens.length; i++) {  // записываем в доп. мапу все домены
            additionalMap.put(arrayDomens[i],1);
        }

        for (int i = 0; i < arrayDomens.length; i++) { // проходимся по масиву доменов
            for (Map.Entry<String,Integer> entry:additionalMap.entrySet()){ // проходимся по мапе
                if (arrayDomens[i].equals(entry.getKey())) // сравниваем елемент масива и мапы
                {
                   itarator = entry.getValue();
                   itarator++;
                    domenMap.remove(arrayDomens[i]); // удаляем прежний элемент ключ - значение,чтобы изменить ключ
                    domenMap.put(arrayDomens[i],itarator);
                }
                else {
                    domenMap.put(arrayDomens[i],1); // добавляем елемент, он встречается первый раз
                }

            }
        }
        for (Map.Entry<String,Integer> entry:domenMap.entrySet()){ // выводим в консоль все домены и их частоту встречаемости
        System.out.println("Сколько раз встречается ["+entry.getValue() + "] ~~ Что встречается ["+ entry.getKey()+"]");
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
