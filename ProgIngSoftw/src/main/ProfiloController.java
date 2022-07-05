package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.PersistenceException;
import dominio.Allenamento;
import dominio.Allenatore;
import interfacceCliente.GestioneListaAllenatoreController;
import interfacceCliente.VisualizzaProfiloAllenatoreController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ProfiloController implements Initializable {

	@FXML
	private ImageView imageHome;

	@FXML
	private Button buttonHome;

	@FXML
	private Button buttonAllenatori;

	@FXML
	private Label labelNome;

	@FXML
	private Label labelCognome;

	@FXML
	private HBox hboxValutazione;

	@FXML
	private Label labelCategoria;

	@FXML
	private Button buttonSegui;

	@FXML
	private Label labelSegui;

	@FXML
	private GridPane gridPane;

	private List<Button> buttons;

	private String usernameAll;
	private SceneController sceneController = new SceneController();

	@FXML
	void changeFollow(ActionEvent event) throws PersistenceException {

		VisualizzaProfiloAllenatoreController contr = new VisualizzaProfiloAllenatoreController();

		if (labelSegui.getText().equals("Segui già")) {
			labelSegui.setText("Non segui ancora l'allenatore");
			buttonSegui.setText("Inizia a seguire");
			contr.smettiDiSeguireAllenatore(SceneController.username, usernameAll);
		} else {
			labelSegui.setText("Segui già");
			buttonSegui.setText("Smetti di seguire");
			contr.seguiAllenatore(SceneController.username, usernameAll);
		}

	}

	@FXML
	void returnHome(ActionEvent event) throws IOException {

		sceneController.goHome(event);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		VisualizzaProfiloAllenatoreController contr = new VisualizzaProfiloAllenatoreController();
		GestioneListaAllenatoreController lista = new GestioneListaAllenatoreController();

		
		Allenatore res = null;
		List<Allenatore> follow = null;
		boolean found = false;
		try {
			res = contr.visualizzaProfilo(SceneController.profiloAllenatoreView);
			follow = lista.getAllenatoriSeguiti(SceneController.username);

		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (res != null) {
			this.usernameAll = res.getUsername();
			labelNome.setText(res.getNome());
			labelCognome.setText(res.getCognome());
			labelCategoria.setText(res.getCategoria());
			for (Allenatore al : follow) {
				if (al.getUsername().equals(res.getUsername())) {
					found = true;
					break;
				}
			}
			if (found) {
				labelSegui.setText("Segui già");
				buttonSegui.setText("Smetti di seguire");
			} else {
				labelSegui.setText("Non segui ancora l'allenatore");
				buttonSegui.setText("Inizia a seguire");
			}
			buttons = new ArrayList<>();

			int valutazione = 0;
			valutazione = Math.round(res.getValutazione());

			ImageView iv = new ImageView();

			if (valutazione == 0) {

			} else if (valutazione == 1) {
				Image im = new Image("file:view/manubri.png");

				StackPane stackPaneforImageActivity = new StackPane();
				iv = new ImageView(im);
				iv.setRotate(90);
				iv.setFitHeight(41);
				iv.setFitWidth(55);
				hboxValutazione.getChildren().add(stackPaneforImageActivity);
				stackPaneforImageActivity.getChildren().add(iv);
				stackPaneforImageActivity.setMargin(iv, new Insets(0, 0, 0, -15));

			} else if (valutazione == 2) {

				Image im = new Image("file:view/manubri.png");
				for (int i = 0; i < 2; i++) {
					StackPane stackPaneforImageActivity = new StackPane();
					iv = new ImageView(im);
					iv.setRotate(90);
					iv.setFitHeight(41);
					iv.setFitWidth(55);
					hboxValutazione.getChildren().add(stackPaneforImageActivity);
					stackPaneforImageActivity.getChildren().add(iv);
					stackPaneforImageActivity.setMargin(iv, new Insets(0, 0, 0, -15));
				}

			} else if (valutazione == 3) {

				Image im = new Image("file:view/manubri.png");
				for (int i = 0; i < 3; i++) {
					StackPane stackPaneforImageActivity = new StackPane();
					iv = new ImageView(im);
					iv.setRotate(90);
					iv.setFitHeight(41);
					iv.setFitWidth(55);
					hboxValutazione.getChildren().add(stackPaneforImageActivity);
					stackPaneforImageActivity.getChildren().add(iv);
					stackPaneforImageActivity.setMargin(iv, new Insets(0, 0, 0, -15));
				}

			} else if (valutazione == 4) {

				Image im = new Image("file:view/manubri.png");
				for (int i = 0; i < 4; i++) {
					StackPane stackPaneforImageActivity = new StackPane();
					iv = new ImageView(im);
					iv.setRotate(90);
					iv.setFitHeight(41);
					iv.setFitWidth(55);
					hboxValutazione.getChildren().add(stackPaneforImageActivity);
					stackPaneforImageActivity.getChildren().add(iv);
					stackPaneforImageActivity.setMargin(iv, new Insets(0, 0, 0, -15));
				}

			} else if (valutazione == 5) {

				Image im = new Image("file:view/manubri.png");

				for (int i = 0; i < 5; i++) {
					StackPane stackPaneforImageActivity = new StackPane();
					iv = new ImageView(im);
					iv.setRotate(90);
					iv.setFitHeight(41);
					iv.setFitWidth(55);
					hboxValutazione.getChildren().add(stackPaneforImageActivity);
					stackPaneforImageActivity.getChildren().add(iv);
					stackPaneforImageActivity.setMargin(iv, new Insets(0, 0, 0, -15));
				}

			}

			int r = 0;
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			gridPane.setAlignment(Pos.TOP_LEFT);
			if (res.getAllenamentiCaricati() != null) {
				for (Allenamento a : res.getAllenamentiCaricati()) {
					
					Label nome = new Label();

					nome.setFont(new Font("System", 20));
					nome.setText(a.getTitolo());
					gridPane.add(nome, 0, r);

					Button b = new Button();
					b.setFont(new Font("System", 20));
					b.setStyle("-fx-background-color:  #23ad5a;");
					b.setText("Visualizza allenamento");
					b.setTextFill(Color.WHITE);
					b.setId(a.getTitolo());
					b.setOnAction(this::viewAllenamento);
					buttons.add(b);
					gridPane.add(b, 1, r);
					r++;
				}
			}
		}

	}

	private void viewAllenamento(ActionEvent event) {

		Button b = (Button) event.getSource();
		String titoloAll = b.getId();

	}

}
