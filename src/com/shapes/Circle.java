package com.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Circle extends Shape {

    @Override
    public void draw(GraphicsContext gc) {
        double x1 = min(beginPoint.getX(), endPoint.getX());
        double x2 = max(beginPoint.getX(), endPoint.getX());
        double y1 = min(beginPoint.getY(), endPoint.getY());
        double y2 = max(beginPoint.getY(), endPoint.getY());
        double d;
        if (y2 - y1 > x2 - x1) {
            d = x2 - x1;
        } else {
            d = y2 - y1;
        }
        gc.strokeOval(x1, y1, d, d);
    }
}
