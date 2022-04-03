package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import media.*;

import java.util.ArrayList;
import java.util.Date;

public class StartingMenu extends Application {
    MediaRentalManager manager = new MediaRentalManager("src/files/db.txt");


    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(loadMainScreen(), 1280, 720);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/img/icon.png"));
        stage.setTitle("Media Rental");
        stage.show();
    }
    /*               Main Menus                 */
    public Pane loadMainScreen() {
        BorderPane BorderPane = new BorderPane();
        VBox first_box = new VBox(70);
        first_box.setPadding(new Insets(250, 0, 0, 100));
        Button[] buttons = new Button[3];
        String[] bt_names = {"Customer", "Media", "Rent"};
        for (int i = 0; i < 3; i++) {
            String s = "img/" + bt_names[i].toLowerCase() + ".png";
            buttons[i] = new Button(bt_names[i], new ImageView(s));
            buttons[i].setMinSize(160, 50);
            first_box.getChildren().add(buttons[i]);
        }
        buttons[0].setOnAction(e -> buttons[0].getScene().setRoot(loadCustomerMenu()));
        buttons[1].setOnAction(e -> buttons[1].getScene().setRoot(loadMediaMenu()));
        buttons[2].setOnAction(e-> buttons[2].getScene().setRoot(loadRentMenu()));
        ImageView background = new ImageView("file:src/img/background.png");
        background.setFitWidth(1280*.70);
        background.setFitHeight(720*.70);
        Label Title = new Label("Media Rental");
        Title.setLabelFor(background);
        BorderPane.setCenter(background);
        BorderPane.setLeft(first_box);
        return BorderPane;
    }
    public Pane loadCustomerMenu(){
        VBox customerPane = new VBox(30);
        String[]titles = {"Add new Customer",
                "Delete Customer",
                "Update Information about Customer",
                "Search a Customer by id",
                "Return to main page"};
        Button[] buttons = new Button[5];
        for(int i=0;i<5;i++){
            buttons[i] = new Button(titles[i]);
            buttons[i].setMinSize(210, 50);
            customerPane.getChildren().add(buttons[i]);
        }
        buttons[0].setOnAction(e->buttons[0].getScene().setRoot(loadAddCustomer()));
        buttons[1].setOnAction(e->buttons[1].getScene().setRoot(loadDeleteCustomer()));
        buttons[2].setOnAction(e->buttons[2].getScene().setRoot(loadUpdateCustomer()));
        buttons[3].setOnAction(e->buttons[3].getScene().setRoot(loadSearchCustomer()));
        buttons[4].setOnAction(e-> buttons[4].getScene().setRoot(loadMainScreen()));
        customerPane.setAlignment(Pos.CENTER);
        return customerPane;
    }
    public Pane loadMediaMenu(){
        VBox mediaPane = new VBox(30);

        String[]titles = {"Add new Media",
                "Delete Media",
                "Update Information about Media",
               "Search a Media by code",
                "Print All Media information",
                "Return to main page"};
        Button[] buttons = new Button[6];
        for(int i=0;i<6;i++){
            buttons[i] = new Button(titles[i]);
            buttons[i].setMinSize(210, 50);
            mediaPane.getChildren().add(buttons[i]);
        }
        buttons[0].setOnAction(e->buttons[0].getScene().setRoot(loadAddMedia()));
        buttons[1].setOnAction(e->buttons[1].getScene().setRoot(loadDeleteMedia()));
        buttons[2].setOnAction(e->buttons[2].getScene().setRoot(loadUpdateMedia()));
        buttons[3].setOnAction(e->buttons[3].getScene().setRoot(loadSearchMedia()));
        buttons[4].setOnAction(e->buttons[4].getScene().setRoot(loadPrintMedia()));
        buttons[5].setOnAction(e-> buttons[5].getScene().setRoot(loadMainScreen()));
        mediaPane.setAlignment(Pos.CENTER);
        return mediaPane;
    }
    public Pane loadRentMenu(){
        VBox rentPane = new VBox(30);

        String[]titles = {"Add To Cart",
                "Remove From Cart",
                "Return Media",
                "Cart & Rented",
                "Return to main page"};
        Button[] buttons = new Button[5];
        for(int i=0;i<5;i++){
            buttons[i] = new Button(titles[i]);
            buttons[i].setMinSize(210, 50);
            rentPane.getChildren().add(buttons[i]);
        }
        buttons[0].setOnAction(e->buttons[0].getScene().setRoot(loadAddToCart()));
        buttons[1].setOnAction(e->buttons[1].getScene().setRoot(loadRemoveFromCart()));
        buttons[2].setOnAction(e->buttons[2].getScene().setRoot(loadReturnMedia()));
        buttons[3].setOnAction(e->buttons[3].getScene().setRoot(loadCartAndRented()));
        buttons[4].setOnAction(e->buttons[4].getScene().setRoot(loadMainScreen()));
        rentPane.setAlignment(Pos.CENTER);
        return rentPane;

    }


    /*               Customer Menu                  */
    public Pane loadAddCustomer(){
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        TextField tf_customerID = new TextField();
        TextField tf_customerName = new TextField();
        tf_customerName.disableProperty().bind(tf_customerID.textProperty().isEmpty());
        TextField tf_customerAddress = new TextField();
        tf_customerAddress.disableProperty().bind(tf_customerName.textProperty().isEmpty());
        TextField tf_customerMobile = new TextField();
        tf_customerMobile.disableProperty().bind(tf_customerAddress.textProperty().isEmpty());
        RadioButton bt_limited = new RadioButton("Limited");
        bt_limited.disableProperty().bind(tf_customerMobile.textProperty().isEmpty());
        RadioButton bt_unlimited = new RadioButton("Unlimited");
        bt_unlimited.disableProperty().bind(tf_customerMobile.textProperty().isEmpty());
        ToggleGroup x = new ToggleGroup();
        bt_limited.setToggleGroup(x);
        bt_unlimited.setToggleGroup(x);
        gridpane.addRow(0,BoldLabel("Customer ID:"),tf_customerID);
        gridpane.addRow(1,BoldLabel("Customer Name:"),tf_customerName);
        gridpane.addRow(2,BoldLabel("Customer Address:"),tf_customerAddress);
        gridpane.addRow(3,BoldLabel("Customer Mobile:"),tf_customerMobile);
        gridpane.addRow(4,BoldLabel("Customer Plan:"), bt_limited,bt_unlimited);
        gridpane.setVgap(50);
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button bt_add = new Button("Add",new ImageView("file:src/img/add.png"));
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        buttons.getChildren().addAll(bt_add,bt_back);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadCustomerMenu()));
        bt_add.disableProperty().bind(tf_customerAddress.textProperty().isEmpty().or(tf_customerID.textProperty().isEmpty()).or(tf_customerMobile.textProperty().isEmpty().or(tf_customerName.textProperty().isEmpty().or(bt_limited.selectedProperty().or(bt_unlimited.selectedProperty()).not()))));
        bt_add.setOnAction(e->{
            String s;
            if (bt_unlimited.isSelected())
                s = "UNLIMITED";
            else
                s = "LIMITED";
            if(manager.addCustomer(tf_customerName.getText(), tf_customerAddress.getText(),
                    s, tf_customerID.getText(), tf_customerMobile.getText())){
                bt_add.setStyle("-fx-border-color: green");
                tf_customerID.setStyle("-fx-border-color: rgba(255,255,255,0)");
            }else{
                bt_add.setStyle("-fx-border-color: red");
                tf_customerID.setStyle("-fx-border-color: red");
            }

        });
        gridpane.setAlignment(Pos.CENTER);
        pane.setCenter(gridpane);
        pane.setBottom(buttons);
        return pane;
    }
    public Pane loadDeleteCustomer(){
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        TextField tf_customerID = new TextField();
        TextField tf_customerName = new TextField();
        tf_customerName.setDisable(true);
        TextField tf_customerAddress = new TextField();
        tf_customerAddress.setDisable(true);
        TextField tf_customerMobile = new TextField();
        tf_customerMobile.setDisable(true);
        TextField tf_customerPlan = new TextField();
        tf_customerPlan.setDisable(true);
        gridpane.addRow(0,BoldLabel("Customer ID:"),tf_customerID);
        gridpane.addRow(1,BoldLabel("Customer Name:"),tf_customerName);
        gridpane.addRow(2,BoldLabel("Customer Address:"),tf_customerAddress);
        gridpane.addRow(3,BoldLabel("Customer Mobile:"),tf_customerMobile);
        gridpane.addRow(4,BoldLabel("Customer Plan:"), tf_customerPlan);
        gridpane.setVgap(50);
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button bt_delete = new Button("Delete",new ImageView("file:src/img/delete.png"));
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        Button bt_find = new Button("Find",new ImageView("file:src/img/find.png"));
        buttons.getChildren().addAll(bt_find,bt_delete,bt_back);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadCustomerMenu()));
        bt_delete.disableProperty().bind(tf_customerID.textProperty().isEmpty());
        bt_find.disableProperty().bind(tf_customerID.textProperty().isEmpty());
        bt_delete.setOnAction(e->{
            if(manager.deleteCustomer(tf_customerID.getText())){
                tf_customerAddress.clear();
                tf_customerAddress.clear();
                tf_customerMobile.clear();
                tf_customerName.clear();
                tf_customerPlan.clear();
                tf_customerID.setStyle("-fx-border-color: rgba(255,255,255,0)");
                bt_delete.setStyle("-fx-border-color: green");
            }else{
                tf_customerID.setStyle("-fx-border-color: red");
                bt_delete.setStyle("-fx-border-color: red");
            }
        });
        bt_find.setOnAction(e->{
            Customer x = manager.getCustomer(tf_customerID.getText());
            if(x != null){
                tf_customerAddress.setText(x.getAddress());
                tf_customerMobile.setText(x.getMobileNumber());
                tf_customerName.setText(x.getName());
                tf_customerPlan.setText(x.getPlan());
                bt_find.setStyle("-fx-border-color: green");
                tf_customerID.setStyle("-fx-border-color: rgba(255,255,255,0)");
            }else{
                bt_find.setStyle("-fx-border-color: red");
                tf_customerID.setStyle("-fx-border-color: red");
            }
        });
        gridpane.setAlignment(Pos.CENTER);
        pane.setCenter(gridpane);
        pane.setBottom(buttons);
        return pane;
    }
    public Pane loadUpdateCustomer(){
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        ArrayList<String> customersIDS = manager.customersID();
        ComboBox<String> tf_customerID = new ComboBox<>();
        for(String s:customersIDS){
            tf_customerID.getItems().add(s);
        }
        TextField tf_customerName = new TextField();
        TextField tf_customerAddress = new TextField();
        TextField tf_customerMobile = new TextField();
        ComboBox<String> tf_customerPlan = new ComboBox<>();
        tf_customerPlan.getItems().add("LIMITED");
        tf_customerPlan.getItems().add("UNLIMITED");
        gridpane.addRow(0,BoldLabel("Customer ID:"),tf_customerID);
        gridpane.addRow(1,BoldLabel("Customer Name:"),tf_customerName);
        gridpane.addRow(2,BoldLabel("Customer Address:"),tf_customerAddress);
        gridpane.addRow(3,BoldLabel("Customer Mobile:"),tf_customerMobile);
        gridpane.addRow(4,BoldLabel("Customer Plan:"), tf_customerPlan);
        gridpane.setVgap(50);
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button bt_update = new Button("Update",new ImageView("file:src/img/update.png"));
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        Button bt_find = new Button("Find",new ImageView("file:src/img/find.png"));
        buttons.getChildren().addAll(bt_find,bt_update,bt_back);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadCustomerMenu()));
        bt_find.disableProperty().bind(tf_customerID.valueProperty().isNull());
        bt_update.disableProperty().bind(tf_customerID.valueProperty().isNull().or(tf_customerName.textProperty().isEmpty()
                .or(tf_customerMobile.textProperty().isEmpty().or(tf_customerAddress.textProperty().isEmpty().or(tf_customerPlan.valueProperty().isNull())))));
        bt_update.setOnAction(e-> manager.updateCustomer(tf_customerID.getValue(),tf_customerName.getText(),tf_customerMobile.getText(),tf_customerPlan.getValue(),tf_customerAddress.getText()));
        bt_find.setOnAction(e->{
            Customer customer = manager.getCustomer(tf_customerID.getValue());
            if(customer != null){
                tf_customerAddress.setText(customer.getAddress());
                tf_customerMobile.setText(customer.getMobileNumber());
                tf_customerName.setText(customer.getName());
                tf_customerPlan.setValue(customer.getPlan());
                bt_find.setStyle("-fx-border-color: green");
                tf_customerID.setStyle("-fx-border-color: rgba(255,255,255,0)");
            }else{
                bt_find.setStyle("-fx-border-color: red");
                tf_customerID.setStyle("-fx-border-color: red");
            }
        });
        bt_update.setOnAction(e-> manager.updateCustomer(tf_customerID.getValue(),tf_customerName.getText(),tf_customerMobile.getText(),tf_customerPlan.getValue(),tf_customerAddress.getText()));
        gridpane.setAlignment(Pos.CENTER);
        pane.setCenter(gridpane);
        pane.setBottom(buttons);
        return pane;
    }
    public Pane loadSearchCustomer(){
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        ComboBox<String> tf_customerID = new ComboBox<>();
        tf_customerID.getItems().addAll(manager.customersID());
        TextField tf_customerName = new TextField();
        tf_customerName.setEditable(false);
        TextField tf_customerAddress = new TextField();
        tf_customerAddress.setEditable(false);
        TextField tf_customerMobile = new TextField();
        tf_customerMobile.setEditable(false);
        TextField tf_customerPlan = new TextField();
        tf_customerPlan.setEditable(false);

        gridpane.addRow(0,BoldLabel("Customer ID:"),tf_customerID);
        gridpane.addRow(1,BoldLabel("Customer Name:"),tf_customerName);
        gridpane.addRow(2,BoldLabel("Customer Address:"),tf_customerAddress);
        gridpane.addRow(3,BoldLabel("Customer Mobile:"),tf_customerMobile);
        gridpane.addRow(4,BoldLabel("Customer Plan:"), tf_customerPlan);
        gridpane.setVgap(50);
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        Button bt_find = new Button("Find",new ImageView("file:src/img/find.png"));
        buttons.getChildren().addAll(bt_find,bt_back);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadCustomerMenu()));
        bt_find.disableProperty().bind(tf_customerID.valueProperty().isNull());
        bt_find.setOnAction(e->{
            Customer customer = manager.getCustomer(tf_customerID.getValue());
                tf_customerAddress.setText(customer.getAddress());
                tf_customerMobile.setText(customer.getMobileNumber());
                tf_customerName.setText(customer.getName());
                tf_customerPlan.setText(customer.getPlan());
        });
        tf_customerID.setOnAction(e->{
            Customer customer = manager.getCustomer(tf_customerID.getValue());
            tf_customerAddress.setText(customer.getAddress());
            tf_customerMobile.setText(customer.getMobileNumber());
            tf_customerName.setText(customer.getName());
            tf_customerPlan.setText(customer.getPlan());
        });

        gridpane.setAlignment(Pos.CENTER);
        pane.setCenter(gridpane);
        pane.setBottom(buttons);
        return pane;
    }
    /*               Media Menu                  */
    public Pane loadAddMedia(){
        BorderPane pane = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setVgap(50);
        TextField tf_mediaName = new TextField();
        TextField tf_copies = new TextField();
        TextField artist = new TextField();
        TextField songs = new TextField();
        ComboBox<String> rating = new ComboBox<>();
        rating.getItems().addAll("HR","DR","AC");
        TextField weight = new TextField();
        ComboBox<String> comboBox_Type = new ComboBox<>();
        comboBox_Type.getItems().addAll("Album","Game","Movie");
        gridPane.addRow(0,BoldLabel("Media Title: "),tf_mediaName);
        gridPane.addRow(1,BoldLabel("Number Of Copies: "),tf_copies);
        gridPane.addRow(2,BoldLabel("Media Type"),comboBox_Type);
        comboBox_Type.setOnAction(e->{
            if(comboBox_Type.getValue().equals("Album")){
                gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                rating.getSelectionModel().clearSelection();
                weight.clear();
                gridPane.addRow(3,BoldLabel("Artist: "),artist);
                gridPane.addRow(4,BoldLabel("Songs: "),songs);
            }else if (comboBox_Type.getValue().equals("Movie")){
                artist.clear();
                songs.clear();
                weight.clear();
                gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 4);
                gridPane.addRow(3,BoldLabel("Rating: "),rating);

            }else{
                gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 4);
                artist.clear();
                songs.clear();
                rating.getSelectionModel().clearSelection();
                gridPane.addRow(3,BoldLabel("Weight: "),weight);
            }
        });
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button bt_add = new Button("Add",new ImageView("file:src/img/add.png"));
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        buttons.getChildren().addAll(bt_add,bt_back);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadMediaMenu()));
        bt_add.disableProperty().bind(tf_mediaName.textProperty().isEmpty().or(tf_copies.textProperty().isEmpty()).or(artist.textProperty().isEmpty().or(songs.textProperty().isEmpty())).and(weight.textProperty().isEmpty().and(rating.valueProperty().isNull())));
        bt_add.setOnAction(e->{
            try {
                int copies = Integer.parseInt(tf_copies.getText());
                String title = tf_mediaName.getText().replaceAll(" ", "-");
                if (comboBox_Type.getValue().equals("Game")) {
                    manager.addGame(title, copies, Double.parseDouble(weight.getText()));
                } else if (comboBox_Type.getValue().equals("Album")) {
                    String artistName = artist.getText().replaceAll(" ", "-");
                    String songsName = artist.getText().replaceAll(" ", "-");
                    manager.addAlbum(title, copies, artistName, songsName);
                } else {
                    manager.addMovie(title, copies, rating.getValue());
                }
            }catch (NumberFormatException x){
                System.out.println("Number Format Error occurred!");
                bt_add.setStyle("-fx-border-color: red");
                tf_copies.setStyle("-fx-border-color: red");
                weight.setStyle("-fx-border-color: red");
            }
        });

        gridPane.setAlignment(Pos.CENTER);
        pane.setCenter(gridPane);
        pane.setBottom(buttons);
        return pane;
    }
    public Pane loadDeleteMedia(){
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        ComboBox<String> MediaTitles = new ComboBox<>();
        MediaTitles.getItems().addAll(manager.mediaListAsStrings());

        TextArea info = new TextArea();
        info.setEditable(false);

        MediaTitles.setOnAction(e->info.setText(manager.getMediaInfo(MediaTitles.getValue())));
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button bt_delete = new Button("Delete",new ImageView("file:src/img/delete.png"));
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        buttons.getChildren().addAll(bt_delete,bt_back);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadMediaMenu()));
        bt_delete.disableProperty().bind(MediaTitles.valueProperty().isNull());
        bt_delete.setOnAction(e->manager.removeMedia(MediaTitles.getValue()));
        gridpane.addRow(0,BoldLabel("Media Title: "),MediaTitles);
        gridpane.addRow(1,BoldLabel("Media Info: "),info);
        gridpane.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        pane.setCenter(gridpane);
        pane.setBottom(buttons);
        return pane;
    }
    public Pane loadUpdateMedia(){
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        ComboBox<String> MediaTitles = new ComboBox<>();
        MediaTitles.getItems().addAll(manager.mediaListAsStrings());
        TextField copies = new TextField();
        ComboBox<String> rating = new ComboBox<>();
        rating.getItems().addAll("HR","DR","AC");
        TextField songs= new TextField(),artist=new TextField(),weight = new TextField();
        gridpane.addRow(0,BoldLabel("Media Title:"),MediaTitles);
        gridpane.addRow(1,BoldLabel("Copies: "),copies);
        MediaTitles.setOnAction(e-> {
            copies.setText(String.valueOf(manager.getMedia(MediaTitles.getValue()).getCopies()));
                    if (manager.mediaType(MediaTitles.getValue()).equals("Game")) {
                        gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2);
                        gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                        rating.getSelectionModel().clearSelection();
                        songs.clear();
                        artist.clear();
                        gridpane.addRow(2, BoldLabel("Weight: "), weight);
                        weight.setText(String.valueOf(((Game)manager.getMedia(MediaTitles.getValue())).getWeight()));

                    } else if (manager.mediaType(MediaTitles.getValue()).equals("Album")) {
                        gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2);
                        gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                        rating.getSelectionModel().clearSelection();
                        weight.clear();
                        gridpane.addRow(2, BoldLabel("Artist: "), artist);
                        artist.setText(String.valueOf(((Album)manager.getMedia(MediaTitles.getValue())).getArtist()));
                        gridpane.addRow(3, BoldLabel("Songs: "), songs);
                        songs.setText(String.valueOf(((Album)manager.getMedia(MediaTitles.getValue())).getSongs()));
                    } else {
                        gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2);
                        gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                        artist.clear();
                        songs.clear();
                        weight.clear();
                        gridpane.addRow(2, BoldLabel("Rating: "), rating);
                        rating.setValue(String.valueOf(((Movie)manager.getMedia(MediaTitles.getValue())).getRating()));
                    }
                });
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button bt_update = new Button("Update",new ImageView("file:src/img/update.png"));
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        buttons.getChildren().addAll(bt_update,bt_back);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadMediaMenu()));
        bt_update.disableProperty().bind(copies.textProperty().isEmpty().or(rating.itemsProperty().isNull().and(weight.textProperty().isEmpty().and(artist.textProperty().isEmpty().or(songs.textProperty().isEmpty())))));
        bt_update.setOnAction(e->{
            try {
                manager.getMedia(MediaTitles.getValue()).setCopies(Integer.parseInt(copies.getText()));
                if (manager.mediaType(MediaTitles.getValue()).equals("Game")) {
                    ((Game) manager.getMedia(MediaTitles.getValue())).setWeight(Double.parseDouble(weight.getText()));

                } else if (manager.mediaType(MediaTitles.getValue()).equals("Album")) {
                    ((Album) manager.getMedia(MediaTitles.getValue())).setArtist(artist.getText().replaceAll(" ", "-"));
                    ((Album) manager.getMedia(MediaTitles.getValue())).setSongs(songs.getText().replaceAll(" ", "-"));
                } else {
                    ((Movie) manager.getMedia(MediaTitles.getValue())).setRating(rating.getValue());
                }
                manager.writeToFile();
            }catch (NumberFormatException x) {
                System.out.println("Number Format Error occurred!");
                bt_update.setStyle("-fx-border-color: red");
                copies.setStyle("-fx-border-color: red");
                weight.setStyle("-fx-border-color: red");
            }
        });
        gridpane.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        pane.setCenter(gridpane);
        pane.setBottom(buttons);

        return pane;

    }
    public Pane loadSearchMedia(){
        BorderPane pane = new BorderPane();
        GridPane gridpane = new GridPane();
        ComboBox<String> MediaTitles = new ComboBox<>();
        MediaTitles.getItems().addAll(manager.mediaListAsStrings());
        TextField copies = new TextField();
        ComboBox<String> rating = new ComboBox<>();
        rating.getItems().addAll("HR","DR","AC");
        TextField songs= new TextField(),artist=new TextField(),weight = new TextField();
        gridpane.addRow(0,BoldLabel("Media Title:"),MediaTitles);
        gridpane.addRow(1,BoldLabel("Copies: "),copies);
        songs.setEditable(false);
        artist.setEditable(false);
        rating.setEditable(false);
        weight.setEditable(false);
        copies.setEditable(false);
        MediaTitles.setOnAction(e-> {
            copies.setText(String.valueOf(manager.getMedia(MediaTitles.getValue()).getCopies()));
            if (manager.mediaType(MediaTitles.getValue()).equals("Game")) {
                gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2);
                gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                rating.getSelectionModel().clearSelection();
                songs.clear();
                artist.clear();
                gridpane.addRow(2, BoldLabel("Weight: "), weight);
                weight.setText(String.valueOf(((Game)manager.getMedia(MediaTitles.getValue())).getWeight()));

            } else if (manager.mediaType(MediaTitles.getValue()).equals("Album")) {
                gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2);
                gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                rating.getSelectionModel().clearSelection();
                weight.clear();
                gridpane.addRow(2, BoldLabel("Artist: "), artist);
                artist.setText(String.valueOf(((Album)manager.getMedia(MediaTitles.getValue())).getArtist()));
                gridpane.addRow(3, BoldLabel("Songs: "), songs);
                songs.setText(String.valueOf(((Album)manager.getMedia(MediaTitles.getValue())).getSongs()));
            } else {
                gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2);
                gridpane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
                artist.clear();
                songs.clear();
                weight.clear();
                gridpane.addRow(2, BoldLabel("Rating: "), rating);
                rating.setValue(String.valueOf(((Movie)manager.getMedia(MediaTitles.getValue())).getRating()));
            }
        });
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        buttons.getChildren().addAll(bt_back);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadMediaMenu()));
        gridpane.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        pane.setCenter(gridpane);
        pane.setBottom(buttons);

        return pane;
    }
    public Pane loadPrintMedia(){
        GridPane pane = new GridPane();
        ScrollPane scrollPane = new ScrollPane();
        TextArea info = new TextArea();
        info.setPrefSize(800,600);
        for(String mt: manager.mediaListAsStrings()){
            info.appendText(manager.getMediaInfo(mt));
            info.appendText("\n\n");
        }
        info.setEditable(false);
        scrollPane.setContent(info);
        pane.getChildren().add(scrollPane);
        pane.setAlignment(Pos.CENTER);
        Button bt_back = new Button("Back",new ImageView("file:src/img/back.png"));
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadMediaMenu()));
        pane.add(bt_back,0,1);
        return pane;
    }

    /*               RENT MENUS             */
    public Pane loadAddToCart(){
        BorderPane pane = new BorderPane();
        ComboBox<String> tf_customerId = new ComboBox<>();
        ComboBox<String> mediaTitles = new ComboBox<>();
        for(String x:manager.customersID()){
            tf_customerId.getItems().add(x);
        }
        for(String x: manager.mediaListAsStrings()){
            mediaTitles.getItems().add(x);
        }
        TextField tf_rentedDate = new TextField(new Date().toString());
        tf_rentedDate.setEditable(false);
        TextArea customerInfo = new TextArea();
        customerInfo.setEditable(false);
        TextArea mediainfo = new TextArea();
        mediainfo.setEditable(false);

        GridPane gridpane = new GridPane();



        tf_customerId.setOnAction(e->{
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
        });
        mediaTitles.setOnAction(e->{
            String s = manager.getMediaInfo(mediaTitles.getValue());
            mediainfo.setText(s);
        });
        gridpane.addRow(0,BoldLabel("Customer ID:"),tf_customerId);
        gridpane.addRow(1,new Label("Customer Info"),customerInfo);
        gridpane.addRow(2,BoldLabel("Media Title:"),mediaTitles);
        gridpane.addRow(3,new Label("Media Info"),mediainfo);
        gridpane.addRow(4,BoldLabel("Rent Date:"),tf_rentedDate);
        gridpane.setPadding(new Insets(50,0,0,100));
        HBox hBox = new HBox(10);
        Button bt_addToCart = new Button("Add To Cart", new ImageView("file:src/img/add.png"));
        Button bt_processesRequests = new Button("Processes Request", new ImageView("file:src/img/update.png"));
        Button bt_back = new Button("Back", new ImageView("file:src/img/back.png"));
        bt_back.setAlignment(Pos.BOTTOM_LEFT);
        bt_addToCart.disableProperty().bind(tf_customerId.valueProperty().isNull().or(mediaTitles.valueProperty().isNull()));
        hBox.getChildren().addAll(bt_addToCart,bt_processesRequests,bt_back);
        pane.setBottom(hBox);
        pane.setCenter(gridpane);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadRentMenu()));
        bt_addToCart.setOnAction(e-> {
            if(manager.addToCart(tf_customerId.getValue(),mediaTitles.getValue()))
                bt_addToCart.setStyle("-fx-border-color: green");
            else bt_addToCart.setStyle("-fx-border-color: red");
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
            String s1 = manager.getMediaInfo(mediaTitles.getValue());
            mediainfo.setText(s1);
        });
        bt_processesRequests.setOnAction(e->{
            manager.processRequest();
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
            String s1 = manager.getMediaInfo(mediaTitles.getValue());
            mediainfo.setText(s1);
        });

        return pane;

    }
    public Pane loadRemoveFromCart(){
        BorderPane pane = new BorderPane();
        ComboBox<String> tf_customerId = new ComboBox<>();
        ComboBox<String> cartItems = new ComboBox<>();
        tf_customerId.getItems().addAll(manager.customersID());
        cartItems.disableProperty().bind(tf_customerId.valueProperty().isNull());
        TextField tf_rentedDate = new TextField(new Date().toString());
        tf_rentedDate.setEditable(false);
        TextArea customerInfo = new TextArea();
        customerInfo.setEditable(false);
        TextArea mediainfo = new TextArea();
        mediainfo.setEditable(false);

        GridPane gridpane = new GridPane();



        tf_customerId.setOnAction(e->{
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
            cartItems.getItems().clear();
            cartItems.getItems().addAll(manager.getCustomer(tf_customerId.getValue()).getCart());
        });
        cartItems.setOnAction(e->{
            String s = manager.getMediaInfo(cartItems.getValue());
            mediainfo.setText(s);
        });
        gridpane.addRow(0,BoldLabel("Customer ID:"),tf_customerId);
        gridpane.addRow(1,new Label("Customer Info"),customerInfo);
        gridpane.addRow(2,BoldLabel("Media Title:"),cartItems);
        gridpane.addRow(3,new Label("Media Info"),mediainfo);
        gridpane.addRow(4,BoldLabel("Rent Date:"),tf_rentedDate);
        gridpane.setPadding(new Insets(50,0,0,100));
        HBox hBox = new HBox(10);
        Button removeFromCart = new Button("Remove From Cart", new ImageView("file:src/img/delete.png"));
        Button bt_processesRequests = new Button("Processes Request", new ImageView("file:src/img/update.png"));
        Button bt_back = new Button("Back",new ImageView("file:src/img/back.png"));
        bt_back.setAlignment(Pos.BOTTOM_LEFT);
        hBox.getChildren().addAll(removeFromCart,bt_processesRequests,bt_back);
        pane.setBottom(hBox);
        pane.setCenter(gridpane);
        removeFromCart.disableProperty().bind(cartItems.valueProperty().isNull());
        bt_processesRequests.disableProperty().bind(cartItems.valueProperty().isNull());
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadRentMenu()));
        removeFromCart.setOnAction(e-> {
            if(manager.removeFromCart(tf_customerId.getValue(),cartItems.getValue()))
                removeFromCart.setStyle("-fx-border-color: green");
            else removeFromCart.setStyle("-fx-border-color: red");
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
            String s1 = manager.getMediaInfo(cartItems.getValue());
            mediainfo.setText(s1);
        });
        bt_processesRequests.setOnAction(e->{
            manager.processRequest();
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
            String s1 = manager.getMediaInfo(cartItems.getValue());
            mediainfo.setText(s1);
        });

        return pane;

    }
    public Pane loadReturnMedia(){
        BorderPane pane = new BorderPane();
        ComboBox<String> tf_customerId = new ComboBox<>();
        ComboBox<String> cartItems = new ComboBox<>();
        tf_customerId.getItems().addAll(manager.customersID());
        cartItems.disableProperty().bind(tf_customerId.valueProperty().isNull());
        TextField tf_rentedDate = new TextField(new Date().toString());
        tf_rentedDate .setEditable(false);
        TextArea customerInfo = new TextArea();
        customerInfo.setEditable(false);
        TextArea mediainfo = new TextArea();
        mediainfo.setEditable(false);

        GridPane gridpane = new GridPane();



        tf_customerId.setOnAction(e->{
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
            cartItems.getItems().clear();
            cartItems.getItems().addAll(manager.getCustomer(tf_customerId.getValue()).getRented());
        });
        cartItems.setOnAction(e->{
            String s = manager.getMediaInfo(cartItems.getValue());
            mediainfo.setText(s);
        });
        gridpane.addRow(0,BoldLabel("Customer ID:"),tf_customerId);
        gridpane.addRow(1,new Label("Customer Info"),customerInfo);
        gridpane.addRow(2,BoldLabel("Rented Titles:"),cartItems);
        gridpane.addRow(3,new Label("Media Info"),mediainfo);
        gridpane.addRow(4,BoldLabel("Return Date:"),tf_rentedDate );
        gridpane.setPadding(new Insets(50,0,0,100));
        HBox hBox = new HBox(10);
        Button return_media = new Button("Return Media", new ImageView("file:src/img/return.png"));
        Button bt_back = new Button("Back",new ImageView("file:src/img/back.png"));
        Button bt_processesRequests = new Button("Processes Requests", new ImageView("file:src/img/update.png"));
        bt_back.setAlignment(Pos.BOTTOM_LEFT);
        hBox.getChildren().addAll(return_media,bt_processesRequests,bt_back);
        pane.setBottom(hBox);
        pane.setCenter(gridpane);
        return_media.disableProperty().bind(cartItems.valueProperty().isNull());
        bt_processesRequests.disableProperty().bind(cartItems.valueProperty().isNull());
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadRentMenu()));
        return_media.setOnAction(e-> {
            if(manager.returnMedia(tf_customerId.getValue(),cartItems.getValue()))
                return_media.setStyle("-fx-border-color: green");
            else return_media.setStyle("-fx-border-color: red");
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
            String s1 = manager.getMediaInfo(cartItems.getValue());
            mediainfo.setText(s1);
        });
        bt_processesRequests.setOnAction(e->{
            manager.processRequest();
            String s = manager.getCustomerInfo(tf_customerId.getValue());
            customerInfo.setText(s);
            String s1 = manager.getMediaInfo(cartItems.getValue());
            mediainfo.setText(s1);

        });

        return pane;
    }
    public Pane loadCartAndRented(){
        ComboBox<String> tf_customerId = new ComboBox<>();
        tf_customerId.getItems().addAll(manager.customersID());
        TextArea cartItems = new TextArea();
        TextArea rentItems = new TextArea();
        cartItems.setEditable(false);
        rentItems.setEditable(false);


        GridPane gridpane = new GridPane();



        tf_customerId.setOnAction(e->{
            cartItems.setText(manager.getCustomer(tf_customerId.getValue()).getCart().toString());
            rentItems.setText(manager.getCustomer(tf_customerId.getValue()).getRented().toString());
        });
        gridpane.addRow(0,BoldLabel("Customer ID:"),tf_customerId);
        gridpane.addRow(1,BoldLabel("Customer Cart"),cartItems);
        gridpane.addRow(2,BoldLabel("Rented Titles:"),rentItems);
        gridpane.setPadding(new Insets(50,0,0,100));
        Button bt_back = new Button("Back",new ImageView("file:src/img/back.png"));
        bt_back.setAlignment(Pos.BOTTOM_LEFT);
        bt_back.setAlignment(Pos.BOTTOM_LEFT);

        gridpane.add(bt_back,1,3);
        bt_back.setOnAction(e->bt_back.getScene().setRoot(loadRentMenu()));

        return gridpane;
    }
    public Label BoldLabel(String text) {
        Label boldLabel = new Label(text);
        boldLabel.setFont(new Font("Verdana", 20));
        return boldLabel;
    }
    public static void main(String[]args){launch(args);}
}
