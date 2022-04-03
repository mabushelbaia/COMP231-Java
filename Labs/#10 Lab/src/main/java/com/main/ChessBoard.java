package com.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessBoard extends Application {

    Color[][] COLORS = {
            {rgba(194, 205, 215, 255), rgba(140,162,173,255)},
            {rgba(129,150,171,255),rgba(95,117,138,255)},
            {rgba(194,204,214,255),rgba(75,124,174,255)},
            {rgba(255,255,221,255),rgba(134,166,102,255)},
            {rgba(216,159,88,255),rgba(156,89,36,255)},
            {rgba(241,246,179,255),rgba(88,148,93,255)}
    };
    @Override
    public void start(Stage primaryStage) {
        int height = 900, width = 800;
        Pane PANE = new Pane();
        GridPane pane = new GridPane();
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        int count = 0;
        double s = 100;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                Rectangle r = new Rectangle(s, s);
                r.heightProperty().bind(pane.heightProperty().subtract(100).divide(8));
                r.widthProperty().bind(pane.widthProperty().divide(8));
                r.setFill(COLORS[0][count%2]);
                pane.add(r, j, i);
                count++;
            }
        }
        PANE.getChildren().add(pane);
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.BOTTOM_CENTER);
        int option = 30;
        bottomBox.spacingProperty().bind(pane.widthProperty().subtract(option* COLORS.length).divide(COLORS.length));
        for(int i=0;i< COLORS.length;i++){
            Rectangle MiniBox = new Rectangle();
            MiniBox.setWidth(option);
            MiniBox.setHeight(option);
            int x=0;
            int y=0;
            for(int j=0;j<4;j++){
                Rectangle r = new Rectangle(option/4.,option/4.);

                if(j%2 == 0) {
                    r.setX(MiniBox.getX() + x);
                    r.setFill(COLORS[i][j/2]);
                    x += option;
                }else{
                    r.setY(MiniBox.getY()+y);
                    r.setFill(COLORS[i][j/2]);
                    y+= option;
                }
            }
            bottomBox.getChildren().add(MiniBox);
        }
        PANE.getChildren().add(bottomBox);
        Scene scene = new Scene(PANE, width, height);
        primaryStage.setTitle("ChessBoard"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    public static Color rgba(int R,int G,int B,int A) {
        return new Color(
               R/255.,
                G/255.,
                B/255.,
                A/255.);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
