package application.Controller;


import java.util.concurrent.CountDownLatch;

import application.View.RegisterView;
import javafx.concurrent.Task;
import javafx.stage.Stage;

public class AuthenticationController extends Task<Void> {
	
	private Stage primaryStage;
	private boolean adminExists;
	private CountDownLatch latch;
	
	public AuthenticationController(Stage primaryStage, boolean adminExists) {
		
		this.primaryStage = primaryStage;
		this.adminExists = adminExists;
		
		this.latch = new CountDownLatch(1);
		
		primaryStage.setTitle("Admin-Registrierung");
		RegisterView theView = new RegisterView(this, primaryStage);
		//new Thread(theView).start(); wenn die View auch implements runnable
		primaryStage.setScene(theView);
		primaryStage.show();
	}
	
	
	/*
	 *Gibt den Speicherort des Admins zurück
	 *alternativ mit Object lock synchronized(lock) { while(condition)... lock.wait(); 
	 */
	@Override
	protected Void call() throws Exception {
		System.out.println("Task zur Registrierung gestartet.");
		try {
			latch.await();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Interrupted");
		}
		return null;
	}
	
	public void adminEntered(String username, String password) {
		System.out.println("Admin in Controller angekommen.");
		//write config file
		latch.countDown();
		System.out.println("Latch released");
		adminExists = true;
	}

}
