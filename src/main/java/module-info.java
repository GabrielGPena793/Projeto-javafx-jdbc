module com.uldemy.projetojavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uldemy.projetojavafxjdbc to javafx.fxml;
    exports com.uldemy.projetojavafxjdbc;
}