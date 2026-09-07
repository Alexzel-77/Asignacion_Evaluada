package ni.edu.ni.asignacion_evaluada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource(
                        "/menu-view.fxml"
                )
        );

        Scene scene = new Scene(
                fxmlLoader.load(),
                800,
                500
        );

        stage.setTitle("Sistema de Registro");
        stage.setScene(scene);
        stage.show();
    }
}
