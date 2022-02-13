module com.uldemy.projetojavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uldemy.application to javafx.fxml;
    exports com.uldemy.application;
    exports com.uldemy.gui;
    opens com.uldemy.gui to javafx.fxml;
}