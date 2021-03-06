package me.dico.satellite.simulation.graphing;

public class Point {
    
    private double t, x, y, r, v;
    
    public Point(double t, double x, double y, double r, double v) {
        this.t = t;
        this.x = x;
        this.y = y;
        this.v = v;
        this.r = r;
    }
    
    public double getT() {
        return t;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getV() {
        return v;
    }
    
    public double getR() {
        return r;
    }
    
}

