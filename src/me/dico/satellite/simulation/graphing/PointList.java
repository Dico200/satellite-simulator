package me.dico.satellite.simulation.graphing;

import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import me.dico.satellite.Satellite;

import java.util.LinkedList;

@SuppressWarnings("serial")
public class PointList extends LinkedList<Point> {
    
    private CanvasGrapher grapher = Satellite.getInstance().getGrapher();
    
    public void add(double t, double x, double y, double r, double v) {
        super.add(new Point(t, x, y, r, v));
        grapher.drawPoint(x, y);
    }
    
    public boolean pushToChart(LineChart<Number, Number> chart, ChartType type) {
        
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        ObservableList<XYChart.Data<Number, Number>> data = series.getData();
        
        if (type == ChartType.RADIUS) {
            series.setName("Radius");
            for (Point point : this) {
                data.add(new XYChart.Data<Number, Number>(point.getT(), point.getR()));
            }
        } else if (type == ChartType.VELOCITY) {
            series.setName("Velocity");
            for (Point point : this) {
                data.add(new XYChart.Data<Number, Number>(point.getT(), point.getV()));
            }
        } else {
            return false;
        }
        
        chart.getData().clear();
        chart.getData().add(series);
        
        //Adding the series to the chart added default visible nodes to each point of data added.
        //Make sure it's just a line without dots. These dots are set to visible when you hover over the chart.
        for (XYChart.Data<Number, Number> point : data) {
            point.getNode().setVisible(false);
        }
        
        return true;
    }
    
}
