package application.View;

import application.Controller.AuthenticationController;
import application.Controller.FormController;
import javafx.stage.Stage;

public class RegisterView extends FormView {
	
	public RegisterView(FormController controller, Stage primaryStage) {
		super(controller, primaryStage);
		
		addUIControls("Bitte registrieren Sie einen Admin!", "Registrieren");
	}
	
}
