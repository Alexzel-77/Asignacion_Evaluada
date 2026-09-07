package ni.edu.ni.asignacion_evaluada;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PeliculasController {

    @FXML
    private TableView<Pelicula> tablaPeliculas;

    @FXML
    private TableColumn<Pelicula, String> colTitulo;

    @FXML
    private TableColumn<Pelicula, String> colDirector;

    @FXML
    private TableColumn<Pelicula, String> colGenero;

    @FXML
    private TableColumn<Pelicula, String> colAnio;

    @FXML
    private TableColumn<Pelicula, String> colDuracion;


    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtDirector;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtDuracion;


    @FXML
    public void initialize() {

        // Configurar columnas

        colTitulo.setCellValueFactory(
                data -> data.getValue().titulo
        );

        colDirector.setCellValueFactory(
                data -> data.getValue().director
        );

        colGenero.setCellValueFactory(
                data -> data.getValue().genero
        );

        colAnio.setCellValueFactory(
                data -> data.getValue().anio
        );

        colDuracion.setCellValueFactory(
                data -> data.getValue().duracion
        );


        // Datos por defecto

        tablaPeliculas.getItems().addAll(

                new Pelicula(
                        "The Godfather",
                        "Francis Ford Coppola",
                        "Drama",
                        "1972",
                        "175"
                ),

                new Pelicula(
                        "Pulp Fiction",
                        "Quentin Tarantino",
                        "Crimen",
                        "1994",
                        "154"
                ),

                new Pelicula(
                        "The Dark Knight",
                        "Christopher Nolan",
                        "Acción",
                        "2008",
                        "152"
                )
        );


        // Detectar selección de película

        tablaPeliculas.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, anterior, seleccionada) -> {

                            if (seleccionada != null) {

                                txtTitulo.setText(
                                        seleccionada.titulo.get()
                                );

                                txtDirector.setText(
                                        seleccionada.director.get()
                                );

                                txtGenero.setText(
                                        seleccionada.genero.get()
                                );

                                txtAnio.setText(
                                        seleccionada.anio.get()
                                );

                                txtDuracion.setText(
                                        seleccionada.duracion.get()
                                );
                            }
                        }
                );
    }


    @FXML
    private void limpiarCampos() {

        txtTitulo.clear();
        txtDirector.clear();
        txtGenero.clear();
        txtAnio.clear();
        txtDuracion.clear();

        tablaPeliculas.getSelectionModel().clearSelection();
    }


    @FXML
    private void procesarInformacion() {

        if (txtTitulo.getText().isEmpty() ||
                txtDirector.getText().isEmpty() ||
                txtGenero.getText().isEmpty() ||
                txtAnio.getText().isEmpty() ||
                txtDuracion.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Campos vacíos");
            alert.setHeaderText("No se puede procesar");
            alert.setContentText(
                    "Debe completar todos los campos."
            );

            alert.showAndWait();

            return;
        }


        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Información de película");
        alert.setHeaderText("Película seleccionada");

        alert.setContentText(
                "Título: " + txtTitulo.getText() + "\n" +
                        "Director: " + txtDirector.getText() + "\n" +
                        "Género: " + txtGenero.getText() + "\n" +
                        "Año: " + txtAnio.getText() + "\n" +
                        "Duración: " + txtDuracion.getText() + " minutos"
        );

        alert.showAndWait();
    }


    // CLASE PARA REPRESENTAR UNA PELÍCULA

    public static class Pelicula {

        private final SimpleStringProperty titulo;
        private final SimpleStringProperty director;
        private final SimpleStringProperty genero;
        private final SimpleStringProperty anio;
        private final SimpleStringProperty duracion;


        public Pelicula(
                String titulo,
                String director,
                String genero,
                String anio,
                String duracion) {

            this.titulo = new SimpleStringProperty(titulo);
            this.director = new SimpleStringProperty(director);
            this.genero = new SimpleStringProperty(genero);
            this.anio = new SimpleStringProperty(anio);
            this.duracion = new SimpleStringProperty(duracion);
        }
    }
}