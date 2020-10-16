package com.saidproject.saidproject.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonFileReader {

    public static Reader READER;

    public static Reader readFile(String fileName) {
        try {
            READER = new FileReader(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return READER;
    }
}
