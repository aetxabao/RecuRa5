package com.masanz.rr5.controladores;

import com.masanz.rr5.Main;
import com.masanz.rr5.config.Ctes;
import com.masanz.rr5.dao.AlumnosDao;
import com.masanz.rr5.excepciones.ExcepcionMarshall;
import com.masanz.rr5.io.Marshall;
import com.masanz.rr5.modelo.Alumno;
import com.masanz.rr5.utils.FicherosUtil;
import com.masanz.rr5.utils.RandomUtil;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;
import java.util.Optional;


public class AlumnosController {

    @FXML
    private ComboBox<String> cmbNota;

    @FXML
    private CheckBox cbxSusp;

    @FXML
    private MenuItem itmBorrar;

    @FXML
    private MenuItem itmCerrar;

    @FXML
    private MenuItem itmExport;

    @FXML
    private MenuItem itmImport;

    @FXML
    private MenuItem itmInfo;

    @FXML
    private ListView<String> lsvAprobados;

    @FXML
    private ListView<String> lsvSuspendidos;

    @FXML
    private RadioButton rbtAprobadosPorApellido;

    @FXML
    private RadioButton rbtAprobadosPorNota;

    @FXML
    private RadioButton rbtSuspendidosPorApellido;

    @FXML
    private RadioButton rbtSuspendidosPorNota;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnActualizar;

    // modelo
    private AlumnosDao alumnosDao;
    private Alumno alumno = null;

    @FXML
    public void initialize() {
        System.out.println("AlumnosController");

        alumnosDao = new AlumnosDao();

//        cmbNota.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
//
//        updateListas(null);
//
//        lsvAprobados.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                int index = lsvAprobados.getSelectionModel().getSelectedIndex();
//                if (index >= 0) {
//                    System.out.println("lsvAprobados " + index);
//                    alumno = alumnosDao.getAlumno(index, false, rbtAprobadosPorApellido.isSelected());
//                    System.out.println("Selected item: " + alumno);
//                    lsvSuspendidos.getSelectionModel().clearSelection();
//                    setAlumno();
//                }
//            }
//        });
//
//        lsvSuspendidos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                int index = lsvSuspendidos.getSelectionModel().getSelectedIndex();
//                if (index >= 0) {
//                    System.out.println("lsvSuspendidos " + index);
//                    alumno = alumnosDao.getAlumno(index, true, rbtSuspendidosPorApellido.isSelected());
//                    System.out.println("Selected item: " + alumno);
//                    lsvAprobados.getSelectionModel().clearSelection();
//                    setAlumno();
//                }
//            }
//        });

    }

    private void setAlumno(){
        if (alumno==null){
            txtNombre.setText("");
            txtApellido.setText("");
            cmbNota.getSelectionModel().selectFirst();
            cbxSusp.setSelected(true);
        }else{
            txtNombre.setText(alumno.getNombre());
            txtApellido.setText(alumno.getApellido());
            cmbNota.getSelectionModel().select(alumno.getNota()-1);
            cbxSusp.setSelected(alumno.isPendiente());
        }
    }

    @FXML
    void updateListas(ActionEvent event) {
        //TODO: updateListas
    }


    @FXML
    void updateAlumno(ActionEvent event) {
        //TODO: updateAlumno
    }


    @FXML
    public void importarBd(ActionEvent actionEvent) {
        //TODO: importarBd
    }

    @FXML
    public void exportarBd(ActionEvent actionEvent) {
        //TODO: exportarBd
    }

    @FXML
    private void borrarBd(ActionEvent actionEvent) {
        //TODO: borrarBd
    }

    @FXML
    public void info(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Gestión de Recursos FX v1");
        String texto = "Aplicación creada por Aitor E. como " +
                "trabajo de recuperación del módulo de " +
                "Programación del ciclo de DAW, curso 2021-2022.";
        alert.setContentText(texto);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(this.getClass().getResource("/com/masanz/rr5/vista/application.css").toExternalForm());
        alert.showAndWait();
    }

    @FXML
    protected void cerrarAplicacion(ActionEvent event) {
        Platform.exit();
    }

}
