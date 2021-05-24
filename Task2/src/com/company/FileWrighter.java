package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWrighter implements Writer{
    @Override
    public  void write(String value) throws FileNotFoundException {
        File file = new File("result");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(value);
        printWriter.close();

    }
}
