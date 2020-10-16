package com.saidproject.saidproject.utils;

import java.io.IOException;
import java.util.Map;

public interface GenerateWordFile<K,V> {

    void generateWordFile() throws IOException;

    Map<K,V> convert();
}
