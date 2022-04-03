package com.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(100,200);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        rectangle.setX(100);
        rectangle.setY(100);
        double x = 150;
        pane.getChildren().add(rectangle);
        Circle[] circles = new Circle[3];
        for (int i=0;i<3;i++){
            circles[i] = new Circle(20);
            circles[i].setFill(Color.WHITE);
            circles[i].setStroke(Color.BLACK);
            circles[i].setCenterX(150);
            circles[i].setCenterY(x);
            pane.getChildren().add(circles[i]);
            x+=50;
        }


        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        ToggleGroup tg = new ToggleGroup();
        String[]a = {"Green","Yellow","Red"};
        RadioButton[] btt = new RadioButton[3];
        for (int i=0;i<3;i++){
            btt[i] = new RadioButton(a[i]);
            btt[i].setToggleGroup(tg);
            hBox.getChildren().add(btt[i]);
        }
        btt[0].setOnAction(e ->{
            circles[0].setFill(Color.GREEN);
            circles[1].setFill(Color.WHITE);
            circles[2].setFill(Color.WHITE);
        });
        btt[1].setOnAction(e ->{
            circles[0].setFill(Color.WHITE);
            circles[1].setFill(Color.YELLOW);
            circles[2].setFill(Color.WHITE);
        });
        btt[2].setOnAction(e ->{
            circles[0].setFill(Color.WHITE);
            circles[1].setFill(Color.WHITE);
            circles[2].setFill(Color.RED);
        });
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 300,500 );
        primaryStage.setTitle("Lights"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}