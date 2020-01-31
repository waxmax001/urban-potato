package application.Controller;

/**
 * Vater-Klasse aller Controller, die eine Verbindung zur Datenbank aufbauen
 * Vater von AuthenticationController... damit AuthenticationController weiter ein eigener Task bleibt, ConnectingController auch von Task erben lassen?
 * Vater von StudentController und TeacherConroller
 * @author Max
 *
 */
public abstract class ConnectingController {
	
	public ConnectingController() {
		
	}
	
	abstract void connect();

}
