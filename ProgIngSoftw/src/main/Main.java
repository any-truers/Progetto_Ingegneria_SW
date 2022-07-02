package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static Stage stage = null;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("/main/Prog_HomePage.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MyFit");
		this.stage = stage;
		stage.show();
	}

}
