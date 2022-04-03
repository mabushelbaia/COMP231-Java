package com.main;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Exercise3 extends Application{



    @Override
    public void start(Stage stage) throws FileNotFoundException {
        VBox vBox = new VBox();
        HBox first_box = new HBox();
        TextField tf_stid = new TextField();
        first_box.getChildren().addAll(new Label("Student ID"),tf_stid);
        HBox second_box = new HBox();
        TextField tf_stname = new TextField();
        second_box.getChildren().addAll(new Label("Student Name"),tf_stname);
        HBox third_box = new HBox();
        RadioButton avg = new RadioButton("Average");
        RadioButton exc = new RadioButton("Excellent");
        RadioButton vg = new RadioButton("Very Good");
        ToggleGroup tg = new ToggleGroup();
        avg.setToggleGroup(tg);
        exc.setToggleGroup(tg);
        vg.setToggleGroup(tg);
        third_box.getChildren().addAll(new Label("Average"),exc,vg,avg);
        HBox fourth_box = new HBox();
        TextField tf_dpname = new TextField();
        fourth_box.getChildren().addAll(new Label("Department Name"),tf_dpname);
        HBox fifth_box = new HBox();
        Button save = new Button("SAVE");


        String s;
        if(avg.isSelected())
            s = "Average";
        else if (exc.isSelected())
            s = "Excellent";
        else if (vg.isSelected())
            s = "Very Good";
        else
            s = "none";
        save.setOnAction(e->{
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("data.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();1
            }
            writer.print(tf_stid.getText() + " "+ tf_stname.getText() + " "+ s + " " + tf_dpname.getText()+ "\n");
            System.out.println(tf_stid.getText() + " "+ tf_stname.getText() + " "+ s + " " + tf_dpname.getText());
            writer.close();

        });

        fifth_box.getChildren().add(save);
        vBox.getChildren().addAll(first_box,second_box,third_box,fourth_box,fifth_box);
        Scene scene = new Scene(vBox,800,600);
        stage.setTitle("Exercise16_06"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
    public static void main(String[] args) {
        launch(args);
    }
}
