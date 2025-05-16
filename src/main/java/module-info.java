module com.example.fortunetelling {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fortunetelling to javafx.fxml;
    exports com.example.fortunetelling;
}