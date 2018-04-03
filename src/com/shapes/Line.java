package com.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class Line extends Shape {

    public Line(Point beginPoint, Point endPoint) {
        super(beginPoint, endPoint);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeLine(beginPoint.x, beginPoint.y, endPoint.x, endPoint.y);
    }
}
