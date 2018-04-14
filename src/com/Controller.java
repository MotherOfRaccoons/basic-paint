package com;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import com.shapes.Shape;

public class Controller implements Initializable {

    @FXML Canvas canvas;
    @FXML ColorPicker colorPicker;
    @FXML Slider slider;

    private GraphicsContext gc;
    private ShapeFactory shapeFactory = new ShapeFactory();
    private Shape shape = null;
    private String currentShape = "Line";
    private List<Shape> list = new LinkedList<>();

    public void drawClick(MouseEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        shape = shapeFactory.getShape(currentShape);
        shape.setColor(colorPicker.getValue());
        shape.setWidth(slider.getValue());
        shape.setCoordinates(new Point(x,y), new Point(x, y));
        list.add(shape);
        shape.draw(gc);
    }

    public void drawDrag(MouseEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        shape.setEndPoint(new Point(x, y));
        list.set(list.size() - 1, shape);
        clearCanvas();
        for (Shape aShape : list) {
            gc.setStroke(aShape.getColor());
            gc.setLineWidth(aShape.getWidth());
            aShape.draw(gc);
        }
        gc.setStroke(colorPicker.getValue());
    }

    private void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void btnLinePressed() {
        currentShape = "Line";
    }

    public void btnRectanglePressed() {
        currentShape = "Rectangle";
    }

    public void btnSquarePressed() {
        currentShape = "Square";
    }

    public void btnEllipsePressed() {
        currentShape = "Ellipse";
    }

    public void btnCirclePressed() {
        currentShape = "Circle";
    }

    public void btnClearPressed() {
        clearCanvas();
        list.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        shape = shapeFactory.getShape("line");
        colorPicker.setValue(Color.BLACK);
    }
}
