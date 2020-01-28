package application.View;

import application.Controller.AuthenticationController;
import application.Controller.FormController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogInView extends FormView {

	public LogInView(FormController controller, Stage primaryStage) {
		super(controller, primaryStage);
		
		addUIControls("Bitte loggen Sie sich ein!", "Einloggen");
	}
	
	
	// in Unit Tests übernehmen, funktioniert nicht
//	public static void main(String[] args) {
//		
//		class TestApp extends Application {
//
//			@Override
//			public void start(Stage theStage) throws Exception {
//				theStage.setWidth(800);
//				theStage.setHeight(600);
//				theStage.setMinWidth(800);
//				theStage.setMinHeight(600);
//				
//				new LogInView(new AuthenticationController(theStage, false), theStage);
//			}
//		}
//		System.out.println("Test");
//		TestApp a = new TestApp();
//		//Application.launch(a.getClass(), args);
//		//new LogInView(new AuthenticationController(primaryStage, adminExists), primaryStage)
//	}
	
	

}
