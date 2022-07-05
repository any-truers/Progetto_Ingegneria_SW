package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeAllenatoreController implements Initializable{
	
	private SceneController sceneController = new SceneController();
	
	@FXML
    private ImageView imageHome;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonRicerca;

    @FXML
    private Button buttonAllenatori;

    @FXML
    private Button buttonAggiungi;

    @FXML
    private Button buttonRimuovi;

    @FXML
    private Button buttonStatistiche;

    @FXML
    void aggiungiAllenamento(ActionEvent event) throws IOException {
    	sceneController.goAddAllenamento(event);
    }

    @FXML
    void listaAllenatori(ActionEvent event) throws IOException {
    	
    	sceneController.goListaAllenatori(event);
    	
    }

    @FXML
    void returnHome(ActionEvent event) {

    }

    @FXML
    void ricerca(ActionEvent event) {

    }

    @FXML
    void rimuoviAllenamento(ActionEvent event) {

    }

    @FXML
    void visualizzaStatistiche(ActionEvent event) {

    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
