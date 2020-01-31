package application.Model;

import java.util.Date;

public class Test implements DataBaseObject{
	
	int ID, klassenID;
	Date datum;
	String TestText; //oder als Stream?
	boolean bis50fehlendeAnschlaege, bis100fehlendeAnschlaege, ueber100fehlendeAnschlaege,
			fehlerNichtWertenWennNotwendigeAnschlagszahlErreicht,
			freigegeben;

}
