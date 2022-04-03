package com.main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Exercise16_06 extends Application {
    private double paneWidth = 350;
    private double paneHeight = 250;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        TextField tfTextField = new TextField();
        TextField tfPrefColumnSize = new TextField();
        tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
        tfPrefColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        tfPrefColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        tfTextField.setPrefColumnCount(13);
        tfPrefColumnSize.setPrefColumnCount(3);

        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(new Label("Text Field"),
                tfTextField);

        HBox hBox2 = new HBox(5);
        hBox2.setAlignment(Pos.CENTER);
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");
        hBox2.getChildren().addAll(rbLeft, rbCenter, rbRight);
        rbLeft.setOnAction(e ->{
            tfTextField.setAlignment(Pos.BOTTOM_LEFT);
        });
        rbRight.setOnAction(e ->{
            tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
        });
        rbCenter.setOnAction(e ->{
            tfTextField.setAlignment(Pos.CENTER);
        });
        tfPrefColumnSize.setOnAction(e->{
//            tfTextField.setPrefColumnCount(Integer.parseInt(tfPrefColumnSize.getText()));
            tfTextField.setFont(Font.font("Verdana", FontWeight.BOLD, Integer.parseInt(tfPrefColumnSize.getText())));
        });
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group);

        HBox hBox3 = new HBox(5);
        hBox3.getChildren().addAll(new Label("Column Size"),
                tfPrefColumnSize);

        HBox hBox4 = new HBox(15);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(hBox2, hBox3);

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox1, hBox4);

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise16_06"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }
        public static void main(String[] args) {
            launch(args);
        }
    }