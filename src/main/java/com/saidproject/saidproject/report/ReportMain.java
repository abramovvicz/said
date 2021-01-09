package com.saidproject.saidproject.report;

import java.io.IOException;
import java.net.URISyntaxException;

public class ReportMain {
    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();
        try {
            generator.generateReport();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
