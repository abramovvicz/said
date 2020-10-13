package com.saidproject.saidproject.utils;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;

import java.io.IOException;

public class Chart {

    private static final String X_AXIS_TITLE = "Q [l/s]";
    private static final String Y_AXIS_TITLE = "P [MPa]";
    private static final String TITLE = "Punkt pracy hydrantu";
    private static final String TITLE_CHART_A = "POMIAR";
    private static final String TITLE_CHART_B = "REFERENCJA";
    private double[] xData = {};
    private double[] yData = {};

    public double[] getxData() {
        return xData;
    }

    public void setxData(double[] xData) {
        this.xData = xData;
    }

    public double[] getYData() {
        return yData;
    }

    public void setYData(double[] yData) {
        this.yData = yData;
    }



    public void createChart() throws IOException {

        // Create Chart
        XYChart chart = new XYChart(500, 400);
        chart.setTitle(TITLE);
        chart.setXAxisTitle(X_AXIS_TITLE);
        chart.setYAxisTitle(Y_AXIS_TITLE);
        chart.addSeries(TITLE_CHART_A, xData, yData);
        chart.addSeries(TITLE_CHART_B, Constants.X_REFERENCE_POINTS, Constants.Y_REFERENCE_POINTS);


        BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.JPG);
        BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.JPG, 150);

    }
}
