module HW {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens hw to javafx.fxml;
    exports hw;
}