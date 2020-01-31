package application.Controller;


import java.util.concurrent.CountDownLatch;

import application.View.LogInView;
import application.View.RegisterView;
import application.View.RegisterView;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AuthenticationController extends Task<Boolean> implements FormController {
	
	private Stage primaryStage;
	private boolean adminExists,
					teacher; // Lehrer oder Schueler
	private CountDownLatch latch;
	
	public AuthenticationController(Stage primaryStage, boolean adminExists) {
		System.out.println("AuthenticationController erstellt");
		this.primaryStage = primaryStage;
		this.adminExists = adminExists;
		
		this.latch = new CountDownLatch(1);
		Scene theView;
		if(adminExists) { //normaler LogIn
			System.out.println("Login Case in Authentication Controller");
			primaryStage.setTitle("Login");
			theView = new LogInView(this, primaryStage);
		}
		else { // Kein Admin
			primaryStage.setTitle("Admin-Registrierung");
			theView = new RegisterView(this, primaryStage);
		}
		primaryStage.setScene(theView);
		primaryStage.show();
	}
	
	
	/*
	 *Gibt den Speicherort des Admins zurück
	 *alternativ mit Object lock synchronized(lock) { while(condition)... lock.wait(); 
	 */
	@Override
	protected Boolean call() throws Exception {
		System.out.println("Task zur Registrierung oder Login gestartet.");
		try {
			latch.await();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Interrupted");
		}
		return teacher;
	}
	
//	public void adminEntered(String username, String password) {
//		System.out.println("Admin in Controller angekommen.");
//		//write config file
//		latch.countDown();
//		System.out.println("Latch released");
//		adminExists = true;
//	}

	@Override
	public void formCompleted(String username, String password) {
		if(adminExists) { //normaler LogIn
			System.out.println("Login erfolgreich.");
			//ToDo überprüfe in der Datenbank, ob der User existiert
			//Setze Teacher-Variable;
			teacher = true; //nur zum Testen
		}
		else { // Kein Admin
			System.out.println("Admin in Controller angekommen.");
			//ToDo write config file
			System.out.println("Latch released");
			adminExists = true;
			teacher = true;
		}
		latch.countDown();
	}


}
