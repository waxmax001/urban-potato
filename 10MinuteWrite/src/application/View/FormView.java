package application.View;

import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.Window;
import application.Controller.AuthenticationController;
import application.View.Constants;

/**
 * gedacht als Parent-Klasse von RegisterView und LogInView
 * @author M4x
 *
 */
public class FormView extends Scene {
	//Klassenvariablen
	GridPane thePane;
	private TextField nameField;
	private TextField passwordField;
	private AuthenticationController controller;

	public FormView(AuthenticationController controller, Stage primaryStage) {
		
		super(new GridPane(), primaryStage.getWidth(), primaryStage.getHeight());
		
		this.controller = controller;
		
		initiatePane();
		addUIControls();
	}
	
	private void initiatePane() {
		thePane = (GridPane) this.getRoot();
		//Position the pane at the center of the screen
		thePane.setAlignment(Pos.CENTER);
		//Set a padding of 5px
		thePane.setPadding(new Insets(10, 10, 10, 10));
		//horizontal and vertical gap between columns
		thePane.setHgap(10);
		thePane.setVgap(10);
		//Add column Constraints
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);
		ColumnConstraints columnTwoConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstraints.setHgrow(Priority.ALWAYS);
		
		thePane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstraints);
	}

	private void addUIControls() {
		//Add header
		Label headerLabel = new Label("Bitte registrieren Sie einen Admin!");
		headerLabel.setStyle(Constants.FONT_BIG);
		thePane.add(headerLabel, 0,0,2,1);
		thePane.setHalignment(headerLabel, HPos.CENTER);
		thePane.setMargin(headerLabel, new Insets(20,0,20,0));
		
		//Add Username label
		Label nameLabel = new Label("Username");
		nameLabel.setStyle(Constants.FONT);
		thePane.add(nameLabel, 0, 1);
		nameField = new TextField();
		nameField.setPrefHeight(40);
		thePane.add(nameField, 1, 1);
		
		//Add Password Label
		Label passwordLabel = new Label("Passwort");
		passwordLabel.setStyle(Constants.FONT);
		thePane.add(passwordLabel, 0, 2);
		passwordField = new TextField();
		passwordField.setPrefHeight(40);
		thePane.add(passwordField, 1, 2);
		
		//Bestätigungsknopf
		Button submitButton = createSubmitButton("Registrieren");
	}

	
	private Button createSubmitButton(String buttonName) {
		Button submitButton = new Button(buttonName);
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(200);
		submitButton.setStyle(Constants.FONT + Constants.BLUE + Constants.WHITE);
		thePane.add(submitButton, 0, 3, 2, 1);
		thePane.setHalignment(submitButton, HPos.CENTER);
		thePane.setMargin(submitButton, new Insets(20,0,20,0));
		submitButton.setOnAction(e -> {
			if(nameField.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, thePane.getScene().getWindow(),
				"Formularfehler!", "Bitte geben Sie einen Usernamen ein!");
				return;
			}
			if(passwordField.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, thePane.getScene().getWindow(),
				"Formularfehler!", "Bitte geben Sie ein Passwort ein!");
				return;
			}
			controller.adminEntered(nameField.getText(), passwordField.getText());
			showAlert(Alert.AlertType.CONFIRMATION, thePane.getScene().getWindow(),
				"Registrierung erfolgreich!", "Herzlich Willkommen, " + nameField.getText());
		}
				);
		return submitButton;
	}
	
	//private Button createSubmButton()
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

}
