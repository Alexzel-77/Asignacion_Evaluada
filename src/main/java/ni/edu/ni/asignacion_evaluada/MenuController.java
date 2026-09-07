package ni.edu.ni.asignacion_evaluada;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private ContextMenu contextMenu;


    @FXML
    public void abrirEstudiantes() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/estudiantes-view.fxml")
            );

            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Registro de Estudiantes");
            stage.setScene(new Scene(root, 700, 500));
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

            mostrarError(
                    "Error",
                    "No se pudo abrir el registro de estudiantes."
            );
        }
    }


    @FXML
    public void abrirPeliculas() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/peliculas-view.fxml")
            );

            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Registro de Películas");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

            mostrarError(
                    "Error",
                    "No se pudo abrir el registro de películas."
            );
        }
    }


    @FXML
    public void mostrarDesarrollador() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Desarrollador");
        alert.setHeaderText("Información del desarrollador");

        alert.setContentText(
                "Aplicación desarrollada por:\n\n" +
                        "Alejandro"
        );

        alert.showAndWait();
    }


    @FXML
    public void mostrarAyuda() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Ayuda");
        alert.setHeaderText("Ayuda de la aplicación");

        alert.setContentText(
                "Utilice el menú Catálogo para acceder a:\n\n" +
                        "- Registro de Estudiantes\n" +
                        "- Registro de Películas\n\n" +
                        "También puede utilizar el clic derecho " +
                        "para abrir el menú contextual."
        );

        alert.showAndWait();
    }


    @FXML
    public void mostrarContextMenu(
            javafx.scene.input.ContextMenuEvent event) {

        if (contextMenu != null) {

            contextMenu.show(
                    event.getPickResult().getIntersectedNode(),
                    event.getScreenX(),
                    event.getScreenY()
            );
        }
    }


    public void setContextMenu(ContextMenu contextMenu) {

        this.contextMenu = contextMenu;
    }


    private void mostrarError(
            String titulo,
            String mensaje) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}