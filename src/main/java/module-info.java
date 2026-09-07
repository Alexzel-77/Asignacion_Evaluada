module ni.edu.ni.asignacion_evaluada {

    requires javafx.controls;
    requires javafx.fxml;

    opens ni.edu.ni.asignacion_evaluada
            to javafx.fxml;

    exports ni.edu.ni.asignacion_evaluada;
}