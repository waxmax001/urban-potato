package application;

import application.Controller.AuthenticationController;
import application.View.*;
import java.util.ArrayList;
import java.util.List;
import javafx.concurrent.Task;
import javax.swing.text.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{
	
//	List<Scene> sceneList = new ArrayList<Scene>();
	
	
	public void start(Stage primaryStage) throws Exception {
		try {
			//Abfrage in Config-File, ob Admin schon erstellt. wenn nicht, öffne RegisterView
			boolean adminExists = false;
			// Controller
			// Model
			
			
			// View
			primaryStage.setWidth(800);
			primaryStage.setHeight(600);
			primaryStage.setMinWidth(800);
			primaryStage.setMinHeight(600);
			
			// Registrierung
			
			if(!adminExists) { // oder while?
				System.out.println("Main: Admin-Registrierung");
				AuthenticationController regTask = new AuthenticationController(primaryStage, adminExists);
				
				regTask.setOnSucceeded((succeededEvent) -> { // 
					System.out.println("Task wurde beendet.");
					primaryStage.hide();
					mainProgram(primaryStage);
				});
				
				Thread regThread = new Thread(regTask);
				regThread.setDaemon(true);
				regThread.start();
			}
			else {
				mainProgram(primaryStage);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
private void mainProgram(Stage primaryStage) {
	// Scenes erstellen
	Scene testScene = new StandardScene(primaryStage);
	//Scenes hinzufügen
	primaryStage.setScene(testScene);
	
	primaryStage.setTitle("Zehn-Minuten-Abschrift");
	primaryStage.show();
	System.out.println("Hauptprogramm gestartet.");
}
	
	public static void main(String[] args) {
		launch(args);
	}
		
}
