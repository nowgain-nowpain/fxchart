/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fxchart;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
 
 
public class HighlightBaseXYChart extends Application {
 
    private DropShadow ds = new DropShadow();
 
    private ContextMenu contextMenu;
 
    private XYChart.Series selectedSeries;
       
    @Override
    public void start(Stage stage) {
        stage.setTitle("Linear plot");
         
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis(0, 22, 0.5);
 
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis) {
 
            @Override
            public String toString(Number object) {
                return String.format("%7.2f", object);
            }
        });
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
 
        lineChart.setCreateSymbols(false);
        lineChart.setAlternativeRowFillVisible(false);
        lineChart.setLegendVisible(false);
 
        final XYChart.Series series1 = new XYChart.Series();
 
        series1.getData().add(new XYChart.Data("Jan", 1));
        series1.getData().add(new XYChart.Data("Feb", 1.5));
        series1.getData().add(new XYChart.Data("Mar", 2));
        series1.getData().add(new XYChart.Data("Apr", 2.5));
        series1.getData().add(new XYChart.Data("May", 3));
        series1.getData().add(new XYChart.Data("Jun", 4));
        series1.getData().add(new XYChart.Data("Jul", 6));
        series1.getData().add(new XYChart.Data("Aug", 9));
        series1.getData().add(new XYChart.Data("Sep", 12));
        series1.getData().add(new XYChart.Data("Oct", 15));
        series1.getData().add(new XYChart.Data("Nov", 20));
        series1.getData().add(new XYChart.Data("Dec", 22));
 
        BorderPane pane = new BorderPane();
        pane.setCenter(lineChart);
        Scene scene = new Scene(pane, 800, 600);
        lineChart.getData().addAll(series1);
 
        contextMenu = new ContextMenu();
        MenuItem menuItem = new MenuItem("Save data");
        contextMenu.getItems().add(menuItem);
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent arg0) {
                if (selectedSeries != null) {
                    System.out.println("Save data of " + selectedSeries.getData());
                    // Saving logic here
                }
            }
        });
 
        // for every series in linechart
        applyMouseEvents(series1);
 
        stage.setScene(scene);
        stage.show();
    }
 
    private void applyMouseEvents(final XYChart.Series series) {
 
        final Node node = series.getNode();
        // We need set userdata to obtain it later through the node.
        node.setUserData(series);
 
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
 
            @Override
            public void handle(MouseEvent arg0) {
                node.setEffect(ds);
                node.setCursor(Cursor.HAND);
            }
        });
 
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
 
            @Override
            public void handle(MouseEvent arg0) {
                node.setEffect(null);
                node.setCursor(Cursor.DEFAULT);
            }
        });
 
        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
 
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                    contextMenu.show(node, mouseEvent.getScreenX() + 1, mouseEvent.getScreenY() + 1);
                    // Set as selected
                    selectedSeries = (XYChart.Series) node.getUserData();
                    System.out.println("Selected Series data " + selectedSeries.getData());
                }
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}