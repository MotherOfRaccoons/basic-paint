package com.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public abstract class Shape {
    Point beginPoint, endPoint;

    Shape(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public void setCoordinates(Point beginPoint, Point endPoint) {
       this.beginPoint = beginPoint;
       this.endPoint = endPoint;
    }

    public abstract void draw(GraphicsContext gc);
}
