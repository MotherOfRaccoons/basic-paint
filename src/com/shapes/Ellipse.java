package com.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class Ellipse extends Shape {

    public Ellipse(Point beginPoint, Point endPoint) {
        super(beginPoint, endPoint);
    }

    @Override
    public void draw(GraphicsContext gc) {
        double x1 = beginPoint.getX();
        double x2 = endPoint.getX();
        double y1 = beginPoint.getY();
        double y2 = endPoint.getY();
        gc.strokeOval(x1, y1, x2 - x1, y2 - y1);
    }
}
