package com.company;

import java.io.FileNotFoundException;

public interface Writer {
    void write(String value) throws FileNotFoundException;
}
