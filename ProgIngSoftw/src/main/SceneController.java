package main;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

	private Stage stage;
	private Parent root;
	private Scene scene;
	public static String username = null;
	public static String tipo = null;

	public void goLogin(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/main/Prog_Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MyFit");
		stage.show();

	}

	public void goHomeAllenatore(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/main/Prog_HomeAllenatore.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MyFit");
		stage.show();

	}
	
	public void goListaAllenatori(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/main/Prog_ListaAll.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MyFit");
		stage.show();

	}
	
	public void goHome(ActionEvent event) throws IOException {
		if(this.tipo.equals("cliente")) {
			root = FXMLLoader.load(getClass().getResource("/main/Prog_HomeCliente.fxml"));
		}
		else if(this.tipo.equals("allenatore")) {
			root = FXMLLoader.load(getClass().getResource("/main/Prog_HomeAllenatore.fxml"));
		}
		else {
			root = FXMLLoader.load(getClass().getResource("/main/Prog_HomeAmministratore.fxml"));
		}
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MyFit");
		stage.show();
	}

}
