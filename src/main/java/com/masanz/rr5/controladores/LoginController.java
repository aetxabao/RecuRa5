package com.masanz.rr5.controladores;

import com.masanz.rr5.dao.LoginDao;
import com.masanz.rr5.modelo.Usuario;
import com.masanz.rr5.utils.SecUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginController {

    @FXML
    private TextField txtNombre;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblError;


    //modelo
    private LoginDao loginDao;


    public LoginController() {
        loginDao = new LoginDao();
    }


    @FXML
    void login(ActionEvent event) {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            lblError.setText("Teclee usuario");
            cogerFoco(txtNombre);
        }
        else {
            String password = txtPassword.getText().trim();
            if (password.isEmpty()) {
                lblError.setText("Teclee password");
                cogerFoco(txtPassword);
            }
            else {
//                boolean exito = loginDao.comprobarUsuario(nombre, password);
                boolean exito = comprobarUsuario();
                if (exito) {
                    iniciarSesion(event);
                }
                else {
                    lblError.setText("Datos incorrectos");
                    cogerFoco(txtNombre);
                }
            }
        }
    }

    public boolean comprobarUsuario() {
        boolean b = false;
        String nombre = txtNombre.getText().trim();
        String password = txtPassword.getText().trim();
        Usuario u = loginDao.getUsuario(nombre);
        if (u!=null){
            try {
                String calculatedHash = SecUtil.sha256(password + u.getSal());
                return calculatedHash.equals(u.getHash());
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return b;
    }

    private void iniciarSesion(ActionEvent event) {
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/masanz/rr5/vista/GuiAlumnos.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/com/masanz/rr5/vista/application.css").toExternalForm());
            scene.setRoot(root);
            Node nodo = (Node) event.getSource();
            Stage stage = (Stage) nodo.getScene().getWindow();

            stage.hide();
            stage.setScene(scene);
            stage.setTitle("Gestión de Aprobados y Suspendidos");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cogerFoco(TextField txt) {
        txt.requestFocus();
        txt.selectAll();
    }


}
