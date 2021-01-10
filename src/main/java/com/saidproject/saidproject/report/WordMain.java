package com.saidproject.saidproject.report;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.net.URISyntaxException;

public class WordMain {
    public static void main(String[] args) {
        WordGenerator wordGenerator = new WordGenerator();
        try {
            wordGenerator.generate();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
