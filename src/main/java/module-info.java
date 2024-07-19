module com.example.sistemavotacion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.sistemavotacion to javafx.fxml;
    exports com.example.sistemavotacion;
    exports com.example.sistemavotacion.Controller;
    opens com.example.sistemavotacion.Controller to javafx.fxml;
}