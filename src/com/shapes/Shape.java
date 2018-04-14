package com.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public abstract class Shape {
    Point beginPoint = new Point(0,0), endPoint = new Point(0,0);
    private Color color = Color.BLACK;
    private double width = 1;

    public void setCoordinates(Point beginPoint, Point endPoint) {
       this.beginPoint = beginPoint;
       this.endPoint = endPoint;
    }

    public void setEndPoint(Point point){
        this.beginPoint = point;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public abstract void draw(GraphicsContext gc);
}
