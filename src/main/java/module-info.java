module com.uldemy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uldemy.application to javafx.fxml;
    exports com.uldemy.application;
    exports com.uldemy.model.entities;
    exports com.uldemy.model.services;
    exports com.uldemy.gui;
    opens com.uldemy.gui to javafx.fxml;
}