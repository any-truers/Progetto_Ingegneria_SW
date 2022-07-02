package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.PersistenceException;
import dominio.Allenatore;
import interfacceCliente.GestioneListaAllenatoreController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ListaAllController implements Initializable {

	@FXML
	private Button buttonVisualizzaProfilo;

	@FXML
	private Button buttonVisualizzaProfilo1;

	@FXML
	private Button buttonVisualizzaProfilo11;

	@FXML
	private ImageView imageHome;

	@FXML
	private Button buttonHome;

	@FXML
	private GridPane gridPane;

	private SceneController sceneController = new SceneController();

	private List<Button> buttons;

	@FXML
	void returnHome(ActionEvent event) throws IOException {
		
		sceneController.goHome(event);
		
	}

	@FXML
	void visualizzaProfilo(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		GestioneListaAllenatoreController contr = new GestioneListaAllenatoreController();
		
		List<Allenatore> res = null;
		try {
			res = contr.getAllenatoriSeguiti(SceneController.username);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(SceneController.username);
		if (res != null && !res.isEmpty()) {
			System.out.println("QUI");
			buttons = new ArrayList<>();
			int r = 2;
			int valutazione = 0;
			
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			gridPane.setAlignment(Pos.TOP_LEFT);
			for (Allenatore a : res) {
				System.out.println(a.getCategoria());
				Label nome = new Label();
				nome.setFont(new Font("System", 17));
				Label categoria = new Label();
				categoria.setFont(new Font("System", 17));
				nome.setText(a.getNome() + " " + a.getCognome());
				categoria.setText(a.getCategoria());
				gridPane.add(nome, 1, r);
				gridPane.add(categoria, 2, r);
				valutazione = Math.round(a.getValutazione());
				/*if (valutazione == 0) {
					
					Image im = new Image("/manubri.png");
					ImageView iv = new ImageView();
					iv.setImage(im);
					gridPane.add(iv, 3, r);

				} else if (valutazione == 1) {
					
					Image im = new Image("/manubri.png");
					ImageView iv = new ImageView();
					iv.setImage(im);
					gridPane.add(iv, 3, r);
					
				} else if (valutazione == 2) {
					
					Image im = new Image("/manubri.png");
					ImageView iv = new ImageView();
					iv.setImage(im);
					gridPane.add(iv, 3, r);

				} else if (valutazione == 3) {
					
					Image im = new Image("/manubri.png");
					ImageView iv = new ImageView();
					iv.setImage(im);
					gridPane.add(iv, 3, r);

				} else if (valutazione == 4) {
					
					Image im = new Image("/manubri.png");
					ImageView iv = new ImageView();
					iv.setImage(im);
					gridPane.add(iv, 3, r);

				} else if (valutazione == 5) {
					
					Image im = new Image("/manubri.png");
					ImageView iv = new ImageView();
					iv.setImage(im);
					gridPane.add(iv, 3, r);
				}*/
				
				Button b = new Button();
				b.setFont(new Font("System", 15));
				b. setStyle("-fx-background-color:  #23ad5a;");
				b.setText("Visualizza profilo");
				b.setTextFill(Color.WHITE);
				b.setId(a.getUsername());
				b.setOnAction(this::viewProfilo);
				buttons.add(b);
				gridPane.add(b, 4, r);
				r++;
			}
		}
	}
	
	private void viewProfilo(ActionEvent event) {
		
		Button b = (Button) event.getSource();
		String usernameProfilo = b.getId();
		System.out.println("USERNAME: " + usernameProfilo);
	}

}
