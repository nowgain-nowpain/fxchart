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
 
 
public class LineNxChartSample extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis xAxis2 = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Big numbers");
        xAxis2.setLabel("Number of small numbers");
        //creating the chart
        final NxLineChart<Number,Number> lineChart = 
                new NxLineChart<Number,Number>(xAxis,yAxis, xAxis2);
        
        // x1-y
//        xAxis.setAutoRanging(true);
        java.lang.Object range = xAxis.getRange();
        xAxis.setForceZeroInRange(false);
        yAxis.setForceZeroInRange(false);
        
        xAxis2.setForceZeroInRange(false);
                
        lineChart.setTitle("Stock Monitoring, 2010");
               
        lineChart.setLegendSide(Side.TOP);
        
        //defining a series
        NXYChart.Series series = new NXYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new NXYChart.Data(10101231, 23));
        series.getData().add(new NXYChart.Data(12101231, 14));
        series.getData().add(new NXYChart.Data(13201231, Float.NaN)); //Fixed in ValueAxis and LineChart, NxLineChart.
        series.getData().add(new NXYChart.Data(14001231, 24));
        series.getData().add(new NXYChart.Data(15001231, 34));
        series.getData().add(new NXYChart.Data(16001231, 36));
        series.getData().add(new NXYChart.Data(17001231, 22));
        series.getData().add(new NXYChart.Data(18001231, 45));
        series.getData().add(new NXYChart.Data(19001231, Double.NaN));
        series.getData().add(new NXYChart.Data(20001231, 17));
        series.getData().add(new NXYChart.Data(21001231, 29));
        series.getData().add(new NXYChart.Data(22001231, 25));
        series.getData().add(new NXYChart.Data(17001231, 32));
    
        // x2-y
        NXYChart.Series series2 = new NXYChart.Series();
        series2.setName("My portfolio 2");
        //populating the series with data
        series2.getData().add(new NXYChart.Data(10, 13));
        series2.getData().add(new NXYChart.Data(12, 24));
        //series.getData().add(new NXYChart.Data(13201231, Float.NaN)); //CannoHi
        series2.getData().add(new NXYChart.Data(14, 11));
        series2.getData().add(new NXYChart.Data(15, 12));
        series2.getData().add(new NXYChart.Data(16, 26));
        series2.getData().add(new NXYChart.Data(17, 32));
        series2.getData().add(new NXYChart.Data(18, 45));
        series2.getData().add(new NXYChart.Data(19, 38));
        series2.getData().add(new NXYChart.Data(20, 27));
        series2.getData().add(new NXYChart.Data(21, 19));
        series2.getData().add(new NXYChart.Data(22, 35));
        series2.getData().add(new NXYChart.Data(12, 15));
         
         
//        xAxis.setRange(, true);
        java.lang.Object range2 = xAxis.getRange();        
        Scene scene  = new Scene(lineChart,800,600);
        //lineChart.getData().add(series);
        lineChart.getData().addAll(series, series2);
        java.lang.Object range3 = xAxis.getRange();        
       
        stage.setScene(scene);
         
        stage.show();
        
       java.lang.Object range4 = xAxis.getRange();        
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}