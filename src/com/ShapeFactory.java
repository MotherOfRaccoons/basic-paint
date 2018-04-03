package com;

import com.shapes.*;
import com.shapes.Rectangle;
import com.shapes.Shape;

import java.awt.*;

class ShapeFactory {

    Shape getShape(String shapeType, Point beginPoint, Point endPoint) {
        if (shapeType.equalsIgnoreCase("Line")) {
            return new Line(beginPoint, endPoint);
        } else if (shapeType.equalsIgnoreCase("Ellipse")) {
            return new Ellipse(beginPoint, endPoint);
        } else if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle(beginPoint, endPoint);
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle(beginPoint, endPoint);
        } else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square(beginPoint, endPoint);
        } else {
            return null;
        }
    }
}

