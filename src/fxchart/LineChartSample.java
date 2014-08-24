/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fxchart;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;

import javafx.stage.Stage;
 
 
public class LineChartSample extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
//        xAxis.setAutoRanging(true);
        java.lang.Object range = xAxis.getRange();
        xAxis.setForceZeroInRange(false);
        
        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(10101231, 23));
        series.getData().add(new XYChart.Data(12101231, 14));
        series.getData().add(new XYChart.Data(13201231, Float.NaN));
        series.getData().add(new XYChart.Data(14001231, 24));
        series.getData().add(new XYChart.Data(15001231, 34));
        series.getData().add(new XYChart.Data(16001231, 36));
        series.getData().add(new XYChart.Data(17001231, 22));
        series.getData().add(new XYChart.Data(18001231, 45));
        series.getData().add(new XYChart.Data(19001231, 43));
        series.getData().add(new XYChart.Data(20001231, 17));
        series.getData().add(new XYChart.Data(21001231, 29));
        series.getData().add(new XYChart.Data(22001231, 25));
        series.getData().add(new XYChart.Data(16001231, 16));
        
//        xAxis.setRange(, true);
        java.lang.Object range2 = xAxis.getRange();        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        java.lang.Object range3 = xAxis.getRange();        
       
        lineChart.setLegendSide(Side.TOP);
                
        stage.setScene(scene);
         
        stage.show();
        
       java.lang.Object range4 = xAxis.getRange();        
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}