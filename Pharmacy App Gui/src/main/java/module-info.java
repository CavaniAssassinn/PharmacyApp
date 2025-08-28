module za.ac.cput.pharmacy_app_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens za.ac.cput.pharmacy_app_gui to javafx.fxml;
    exports za.ac.cput.pharmacy_app_gui;
}