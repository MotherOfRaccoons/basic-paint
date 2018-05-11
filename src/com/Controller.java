package com;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import com.shapes.Shape;

public class Controller implements Initializable {

    @FXML Canvas canvas;
    @FXML ColorPicker colorPicker;
    @FXML Slider slider;
    @FXML ListView<Shape> figureList;
    @FXML TextField edtNameOfFile;

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
        figureList.getItems().add(shape);
        figureList.getSelectionModel().selectLast();
        redraw();
    }

    public void drawDrag(MouseEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        shape.setEndPoint(new Point(x, y));
        list.set(list.size() - 1, shape);
        redraw();
    }

    private void redraw() {
        clearCanvas();
        for (Shape aShape : list) {
            gc.setStroke(aShape.getColor());
            gc.setLineWidth(aShape.getWidth());
            aShape.draw(gc);
        }
        gc.setStroke(colorPicker.getValue());
    }

    public void btnSerialize() {
        String nameOfFile = edtNameOfFile.getText();
        System.out.println("FILE");
       try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nameOfFile))) {
            out.writeObject(list);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked cast")
    public void btnDeserialize() {
        String nameOfFile = edtNameOfFile.getText();
        if (new File(nameOfFile).exists()) {
            clearCanvas();
            list.clear();
            figureList.getItems().clear();
            try (ObjectInputStream out = new ObjectInputStream(new FileInputStream(nameOfFile))) {
                list = (List<Shape>) out.readObject();
            } catch (Exception exc) {
                exc.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to read file.", ButtonType.OK);
                alert.showAndWait();
            }
            figureList.getItems().addAll(list);
            redraw();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "File "+nameOfFile+"doesn't exists.", ButtonType.OK);
            alert.showAndWait();
        }
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
        figureList.getItems().clear();
    }

    public void btnDeleteObject() {
        int index = figureList.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            list.remove(figureList.getItems().get(index));
            figureList.getItems().remove(index);
            redraw();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please chose an object to delete.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void dragSlider() {
        shape.setWidth(slider.getValue());
        redraw();
    }

    public void colorChanged() {
        shape.setColor(colorPicker.getValue());
        redraw();
    }

    public void changeFigure() {
        shape = figureList.getItems().get(figureList.getSelectionModel().getSelectedIndex());
        colorPicker.setValue(shape.getColor());
        slider.setValue(shape.getWidth());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        shape = shapeFactory.getShape("line");
        colorPicker.setValue(Color.BLACK);
        edtNameOfFile.setText("temp.out");
    }
}
