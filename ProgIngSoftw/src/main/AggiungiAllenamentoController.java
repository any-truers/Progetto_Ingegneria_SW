package main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.PersistenceException;
import dominio.LivelloDifficolta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class AggiungiAllenamentoController implements Initializable {

	private SceneController sceneController = new SceneController();

	@FXML
	private ImageView imageHome;

	@FXML
	private Button buttonHome;

	@FXML
	private TextField textTitolo;

	@FXML
	private TextField textCategoria;

	@FXML
	private Spinner<Integer> spinnerDurata;

	@FXML
	private Spinner<Integer> spinnerCalorie;

	@FXML
	private ChoiceBox<LivelloDifficolta> choiceDifficolta;

	@FXML
	private Button buttonAddFile;

	@FXML
	private Label labelNomeFile;

	@FXML
	private Button buttonCaricaAllenamento;

	private File fileVideo;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	void addFile(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Carica allenamento");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("File video", "*.mp4", "*.mov", "*.avi", "*.wmv"),
				new ExtensionFilter("all", "*.*"));
		Stage stage = (Stage) anchorPane.getScene().getWindow();
		fileVideo = fileChooser.showOpenDialog(stage);
		if (fileVideo != null) {
			this.labelNomeFile.setText(fileVideo.getName());
		}
	}

	@FXML
	void caricaAllenamento(ActionEvent event) throws PersistenceException {
		interfacceAllenatore.AggiungiAllenamentoController contr = new interfacceAllenatore.AggiungiAllenamentoController();
		if (this.labelNomeFile.getText().isEmpty() || this.textTitolo.getText().isEmpty()
				|| this.spinnerDurata.getValue() <= 0 || this.spinnerCalorie.getValue() <= 0 || fileVideo == null) {

		} else
			contr.aggiungiAllenamento(SceneController.username, this.labelNomeFile.getText(),
					this.spinnerDurata.getValue().intValue(), this.textCategoria.getText(),
					this.spinnerCalorie.getValue().intValue(), this.choiceDifficolta.getValue(), fileVideo);
	}

	@FXML
	void returnHome(ActionEvent event) throws IOException {

		sceneController.goHome(event);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.labelNomeFile.setText("");
		for (int i = 0; i < LivelloDifficolta.values().length; i++) {
			this.choiceDifficolta.getItems().add(LivelloDifficolta.values()[i]);
		}
		this.choiceDifficolta.setValue(this.choiceDifficolta.getItems().get(0));

		SpinnerValueFactory<Integer> valueFactoryCalorie = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999,
				1);
		this.spinnerCalorie.setValueFactory(valueFactoryCalorie);
		SpinnerValueFactory<Integer> valueFactoryDurata = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999, 1);
		this.spinnerDurata.setValueFactory(valueFactoryDurata);

	}

}
