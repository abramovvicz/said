package com.saidproject.saidproject.utils;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;

import java.io.IOException;

public class Chart {

    private static final String X_AXIS_TITLE = "Q [l/s]";
    private static final String Y_AXIS_TITLE = "P [MPa]";
    private static final String TITLE = "Punkt pracy hydrantu";
    private static final String TITLE_CHART_A = "ref a";
    private static final String TITLE_CHART_B = "ref b";
    private double[] xData = {};
    private double[] yData = {};
    private double[] xData1 = {};
    private double[] yData1 = {};

    public double[] getxData() {
        return xData;
    }

    public void setxData(double[] xData) {
        this.xData = xData;
    }

    public double[] getyData() {
        return yData;
    }

    public void setyData(double[] yData) {
        this.yData = yData;
    }

    public double[] getxData1() {
        return xData1;
    }

    public void setxData1(double[] xData1) {
        this.xData1 = xData1;
    }

    public double[] getyData1() {
        return yData1;
    }

    public void setyData1(double[] yData1) {
        this.yData1 = yData1;
    }

    public void createChart() throws IOException {

        // Create Chart
        XYChart chart = new XYChart(500, 400);
        chart.setTitle(TITLE);
        chart.setXAxisTitle(X_AXIS_TITLE);
        chart.setYAxisTitle(Y_AXIS_TITLE);
        chart.addSeries(TITLE_CHART_A, xData, yData);
        chart.addSeries(TITLE_CHART_B, xData1, yData1);


        BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.JPG);
        BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.JPG, 150);

    }
}
