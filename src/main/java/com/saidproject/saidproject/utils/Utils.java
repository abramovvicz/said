package com.saidproject.saidproject.utils;

import com.google.common.io.ByteSource;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static java.sql.Date convertToSqlDate(java.util.Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime());
    }

    public static InputStream convertByteArrayToBlob(byte[] photoAsBytes) {
        InputStream inputStream = null;
        try {
            inputStream = ByteSource.wrap(photoAsBytes).openStream();

        } catch (IOException e) {
            //TODO: ADD LOG OR CUSTOM EXCEPTION HERE
        }
        return inputStream;
    }
}
