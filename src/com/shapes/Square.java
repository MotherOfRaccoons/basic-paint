package com.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Square extends Shape {

    @Override
    public void draw(GraphicsContext gc) {
        double x1 = min(beginPoint.getX(), endPoint.getX());
        double x2 = max(beginPoint.getX(), endPoint.getX());
        double y1 = min(beginPoint.getY(), endPoint.getY());
        double y2 = max(beginPoint.getY(), endPoint.getY());
        double width;
        if (y2 - y1 > x2 - x1) {
            width = x2 - x1;
        } else {
            width = y2 - y1;
        }
        gc.strokeRect(x1, y1, width, width);
    }
}
