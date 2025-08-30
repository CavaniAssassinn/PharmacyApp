module za.ac.cput.pharmacy_app_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    requires za.ac.cput.pharmacyapp;

    opens za.ac.cput.pharmacy_app_gui to javafx.fxml;
    exports za.ac.cput.pharmacy_app_gui;
}