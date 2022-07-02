package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

	@FXML
	private TextField textUsername;

	@FXML
	private PasswordField textPassword;

	@FXML
	private Button buttonLogin;

	@FXML
	private Label labelError;
	
	private SceneController sceneController = new SceneController();
	
	@FXML
	void autenticazione(ActionEvent event) throws IOException {

		if (this.textUsername.getText().isEmpty() || textPassword.getText().isEmpty()) {
			labelError.setVisible(true);
		} else if (this.textUsername.getText().length() < 6 || this.textPassword.getText().length() < 8) {
			labelError.setVisible(true);
		} else {
			login.LoginController loginController = new login.LoginController();
			String res = loginController.autenticazione(textUsername.getText(), textPassword.getText());
			if (res == null) {
				labelError.setVisible(true);
			} else {

				if (res.equals("cliente")) {
					
					SceneController.username = textUsername.getText();
					SceneController.tipo = "cliente";

				}
				else if (res.equals("allenatore")) {
					
					SceneController.username = textUsername.getText();
					SceneController.tipo = "allenatore";
					sceneController.goHomeAllenatore(event);
					
				}
				else if (res.equals("amministratore")) {
					
					SceneController.username = textUsername.getText();
					SceneController.tipo = "amministratore";

				}
			}
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		labelError.setVisible(false);
	}

}