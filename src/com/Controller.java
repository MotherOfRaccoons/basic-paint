package com;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Canvas canvas;
    @FXML
    ColorPicker colorPicker;

    private GraphicsContext gc;
    private Point beginPoint = new Point(0, 0);
    private Point endPoint = new Point(0, 0);
    private ShapeFactory shapeFactory = new ShapeFactory();
    private com.shapes.Shape Shape = null;

    public void drawClick(MouseEvent event) {
        if (Shape != null) {
            float x = (float) event.getX();
            float y = (float) event.getY();
            beginPoint.setLocation(x, y);
            endPoint.setLocation(x + 150, y + 100);
            Shape.setCoordinates(beginPoint, endPoint);
            Shape.draw(gc);
        }
    }

    public void btnLinePressed() {
        Shape = shapeFactory.getShape("Line", beginPoint, endPoint);
    }

    public void btnRectanglePressed() {
        Shape = shapeFactory.getShape("Rectangle", beginPoint, endPoint);
    }

    public void btnSquarePressed() {
        Shape = shapeFactory.getShape("Square", beginPoint, endPoint);
    }

    public void btnEllipsePressed() {
        Shape = shapeFactory.getShape("Ellipse", beginPoint, endPoint);
    }

    public void btnCirclePressed() {
        Shape = shapeFactory.getShape("Circle", beginPoint, endPoint);
    }

    public void btnClearPressed() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void colorChanged() {
        gc.setStroke(colorPicker.getValue());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        Shape = shapeFactory.getShape("line", beginPoint, endPoint);
        colorPicker.setValue(Color.BLACK);
    }
}
