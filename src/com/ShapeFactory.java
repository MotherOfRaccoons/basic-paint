package com;

import com.shapes.*;
import com.shapes.Rectangle;
import com.shapes.Shape;

import java.awt.*;

class ShapeFactory {

    Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("Line")) {
            return new Line();
        } else if (shapeType.equalsIgnoreCase("Ellipse")) {
            return new Ellipse();
        } else if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        } else {
            return null;
        }
    }
}

