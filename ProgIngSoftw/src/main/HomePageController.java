package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Modality;

public class HomePageController implements Initializable {

	@FXML
	private Button buttonLogin;

	@FXML
	private Button buttonLogin1;
	
	private SceneController sceneController = new SceneController();

	@FXML
	void login(ActionEvent event) throws Exception {
		
		sceneController.goLogin(event);
		
	}

	@FXML
	void registrazione(ActionEvent event) {
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
