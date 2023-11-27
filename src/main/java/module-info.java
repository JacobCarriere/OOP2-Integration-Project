module com.example.oop2integrationproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.oop2integrationproject to javafx.fxml;
    exports com.example.oop2integrationproject;
}