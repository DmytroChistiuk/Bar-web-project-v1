package com.company;

public class Part2 {
    public static void main(String[] args) {
        CustomCollections customCollections = new CustomCollections<>();
        customCollections.AddToCustomCollections("It");
        customCollections.AddByNumberCustomCollections("is",1);
        customCollections.AddToCustomCollections("my");
        customCollections.AddByNumberCustomCollections("CUSTOM",3);
        customCollections.AddToCustomCollections("COLLECTIONS");
        customCollections.CollectionsIsEmpty();
        customCollections.PrintSizeCustomCollections();
        System.out.println(customCollections.toString());
        customCollections.RemoveFromCustomCollections();
        customCollections.CollectionsIsEmpty();
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        customCollections.AddToCustomCollections(1);
        customCollections.AddByNumberCustomCollections(2,1);
        customCollections.AddToCustomCollections(3.1);
        customCollections.AddByNumberCustomCollections(4,3);
        customCollections.AddToCustomCollections(5.1);
        customCollections.CollectionsIsEmpty();
        customCollections.PrintSizeCustomCollections();
        System.out.println(customCollections.toString());
        customCollections.RemoveFromCustomCollections();
        customCollections.CollectionsIsEmpty();



    }
}
