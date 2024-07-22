module com.example.sistemavotacion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls; // Si estás usando ControlsFX, asegúrate de que esté en tu classpath
    requires java.sql;

    // Abre los paquetes para el acceso de reflexión por parte de JavaFX
    opens com.example.sistemavotacion to javafx.fxml;
    opens com.example.sistemavotacion.Controller to javafx.fxml;

    // Exporta los paquetes que serán accesibles para otros módulos
    exports com.example.sistemavotacion;
    exports com.example.sistemavotacion.Controller;
}
