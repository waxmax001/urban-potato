package application.View;

import java.util.ArrayList;
import java.util.List;
import application.View.Constants;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class StandardScene extends Scene {
	static BorderPane thePane;
	private List<Button> leftButtons = new ArrayList<Button>();
	VBox left = new VBox();
	VBox center = new VBox();
	Label userLabel;
	
	
	public StandardScene(Stage primaryStage) {
		super(createPane(), primaryStage.getWidth(), primaryStage.getHeight());
		//thePane = (BorderPane) this.getRoot();
		thePane.setPadding(new Insets(10, 10, 10, 10)); //top, right, bottom, left
		
		//Left
		left.setSpacing(15);
		left.setPadding(new Insets(10, 20, 10, 10));
		createButtons();
		//createUserlabel("Mayer");
		
		//Center
		center.setPrefWidth(500);
		center.setPadding(new Insets(10, 20, 10, 20));
//		TextField testText = new TextField();
//		testText.setPrefHeight(100);
//		center.getChildren().add(testText);
		
		thePane.setLeft(left);
		thePane.setCenter(center);
		
	}


	private static BorderPane createPane() {
		thePane = new BorderPane();
		return thePane;
	}


	private void createButtons() {
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		
		button1.setOnAction(e -> System.out.println("Button 1 gedrückt"));
		button2.setOnAction(e -> System.out.println("Button 2 gedrückt"));
		
		button1.setPrefSize(100, 100);
		button2.setPrefSize(100, 100);
		
		button1.setStyle(Constants.BLUE + Constants.WHITE + Constants.FONT);
		button2.setStyle(Constants.BLUE + Constants.WHITE + Constants.FONT);
		
		getButtonList().add(button1);
		getButtonList().add(button2);
		
		getButtonList().forEach(button -> left.getChildren().add(button));
	}
	
	/**
	 * fügt links oder im Center einen Button hinzu; Spot als Konstante LEFT oder CENTER
	 * @param b
	 */
	private void addButton(Button b, int spot) {
		switch (spot) {
		case Constants.LEFT:
			getButtonList().add(b);
			left.getChildren().add(b);
			break;
		case Constants.CENTER:
			
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + spot);
		}
	}
	/**
	 * Wird nach der Erzeugung der Buttons aufgerufen
	 * @param name
	 */
	private void createUserlabel(String name) {
		userLabel = new Label("Lehrer: \n" + name);
		userLabel.setStyle(Constants.FONT + Constants.USER_LABEL);
		userLabel.setPrefSize(100, 100);
		userLabel.setContentDisplay(ContentDisplay.TOP);
		left.getChildren().add(userLabel);
	}


	public List<Button> getButtonList() {
		return leftButtons;
	}


}
