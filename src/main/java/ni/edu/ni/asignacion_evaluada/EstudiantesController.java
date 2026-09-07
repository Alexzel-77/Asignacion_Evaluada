package ni.edu.ni.asignacion_evaluada;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EstudiantesController {

    @FXML
    private TextField txtCarnet;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtCarrera;

    @FXML
    private TextArea txtAreaEstudiantes;


    @FXML
    private void guardarEstudiante() {

        String carnet = txtCarnet.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String edad = txtEdad.getText();
        String carrera = txtCarrera.getText();


        // VALIDACIÓN DE CAMPOS VACÍOS

        if (carnet.isEmpty() ||
                nombre.isEmpty() ||
                apellido.isEmpty() ||
                edad.isEmpty() ||
                carrera.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Campos vacíos");
            alert.setHeaderText("No se puede guardar");
            alert.setContentText(
                    "Debe completar todos los campos."
            );

            alert.showAndWait();

            return;
        }


        // AGREGAR INFORMACIÓN AL TEXTAREA

        txtAreaEstudiantes.appendText(
                "Carnet: " + carnet + "\n" +
                        "Nombre: " + nombre + "\n" +
                        "Apellido: " + apellido + "\n" +
                        "Edad: " + edad + "\n" +
                        "Carrera: " + carrera + "\n" +
                        "-----------------------------\n"
        );


        limpiarCampos();
    }


    @FXML
    private void limpiarCampos() {

        txtCarnet.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
        txtCarrera.clear();
    }
}