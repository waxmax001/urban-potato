package application;

import application.Controller.AuthenticationController;
import application.Controller.StudentController;
import application.Controller.TeacherController;
import application.View.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javafx.concurrent.Task;
import javax.swing.text.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{
	
	boolean adminExists;
	Stage primaryStage;
	boolean teacher; //Login als Schueler(nicht-Lehrer) oder Lehrer
	
//	List<Scene> sceneList = new ArrayList<Scene>();
	
	/*
	 * ToDo
	 * Hauptprogramm
	 * Vererbung StudentView und TeacherView von Abstract UserView sowie Teacher/Student_Controller von UserController
	 */
	
	public void start(Stage primaryStage) throws Exception {
		try {
			//Abfrage in Config-File, ob Admin schon erstellt. wenn nicht, öffne RegisterView
			adminExists = true;
			
			this.primaryStage = primaryStage;
				
			// View
			primaryStage.setWidth(800);
			primaryStage.setHeight(600);
			primaryStage.setMinWidth(800);
			primaryStage.setMinHeight(600);
			
			// Registrierung
			if(!adminExists) registerAdmin();
			else 			 logIn();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


private void registerAdmin() {
	AuthenticationController regTask = new AuthenticationController(primaryStage, adminExists);
	
	regTask.setOnSucceeded((succeededEvent) -> { // 
		System.out.println("Registrierung abgeschlossen und Task beendet.");
		primaryStage.hide();
		logIn();
	});
	
	Thread regThread = new Thread(regTask);
	regThread.setDaemon(true);
	regThread.start();
}

private void logIn() {
	assert(adminExists==true);
	//System.out.println("Die Variable adminExists steht auf " + adminExists);
	AuthenticationController logInTask = new AuthenticationController(primaryStage, adminExists);
	
	logInTask.setOnSucceeded((succeededEvent) -> { // 
		System.out.println("LogIn abgeschlossen und Task beendet.");
		primaryStage.hide();
		teacher = logInTask.getValue();
		if (teacher)
			System.out.println("... als Lehrer eingeloggt.");
		else
			System.out.println("... als Schüler eingeloggt.");
		mainProgram();
	});
	Thread LogInThread = new Thread(logInTask);
	LogInThread.setDaemon(true);
	LogInThread.start();
}
	
private void mainProgram() {
	// Unterscheide nach Schueler oder Lehrer und erstelle passende Controller und Views;
	if (teacher) {
		TeacherController tController = new TeacherController();
		
	} else {
		StudentController sController = new StudentController();
		
	}
	System.out.println("Starte Hauptprogramm");
	// Controller
	// Model
	
	// Scenes erstellen
	Scene testScene = new StandardScene(primaryStage);
	//Scenes hinzufügen
	primaryStage.setScene(testScene);
	
	primaryStage.setTitle("Zehn-Minuten-Abschrift");
	primaryStage.show();
}

	
	public static void main(String[] args) {
		launch(args);
	}
		
}
