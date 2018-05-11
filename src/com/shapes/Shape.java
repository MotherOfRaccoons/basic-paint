package com.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable {
    Point beginPoint = new Point(0,0), endPoint = new Point(0,0);
    private String color = Color.BLACK.toString();
    private double width = 1;

    public void setCoordinates(Point beginPoint, Point endPoint) {
       this.beginPoint = beginPoint;
       this.endPoint = endPoint;
    }

    public void setEndPoint(Point point){
        this.beginPoint = point;
    }

    public void setColor(Color color) {
        this.color = color.toString();
    }

    public Color getColor() {
        return Color.web(color);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public abstract void draw(GraphicsContext gc);
}
