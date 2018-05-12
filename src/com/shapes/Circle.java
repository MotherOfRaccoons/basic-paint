package com.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape {

    @Override
    public void draw(GraphicsContext gc) {
        double x1 = beginPoint.getX();
        double x2 = endPoint.getX();
        double y1 = beginPoint.getY();
        double y2 = endPoint.getY();

        double width = Math.min(Math.abs(y2 - y1), Math.abs(x2 - x1));
        if (x2 < x1) {
            x1 = x1 - width;
        }
        if (y2 < y1) {
            y1 = Math.abs(y1 - width);
        }

        gc.strokeOval(x1, y1, width, width);
    }
}
