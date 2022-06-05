package com.masanz.rr5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
			this.getClass().getResource("/com/masanz/rr5/vista/Login.fxml"));
//			this.getClass().getResource("/com/masanz/rr5/vista/GuiAlumnos.fxml"));
			Pane root = loader.load();

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/com/masanz/rr5/vista/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Gestión de Aprobados y Suspendidos");
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
