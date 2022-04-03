module com.lab10.lab10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab10.lab10 to javafx.fxml;
    exports com.lab10.lab10;
}