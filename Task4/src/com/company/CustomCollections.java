package com.company;

import java.util.ArrayList;

public class CustomCollections<Obj> {
private ArrayList arrayList = new ArrayList<>();
    public <Obj> void AddToCustomCollections(Obj objects) {
    arrayList.add(objects);
    }
    public void PrintSizeCustomCollections() {
       System.out.println(arrayList.size());
    }
    public <Obj> void AddByNumberCustomCollections(Obj objects, int number) {
        arrayList.add(number,objects);
    }
    public void RemoveFromCustomCollections(){
        arrayList.clear();
    }
    public void CollectionsIsEmpty(){
        if (arrayList.isEmpty()==true){
            System.out.println("Collections is empty, sorry man(");
        }
        else {
            System.out.println("Collections is full!");
        }
    }

    @Override
    public String toString() {
        return "CustomCollections{" +
                "arrayList=" + arrayList +
                '}';
    }
}
