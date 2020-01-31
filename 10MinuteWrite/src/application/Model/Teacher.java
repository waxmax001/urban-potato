package application.Model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends SchoolPerson implements DataBaseObject{
	
	List<SchoolClass> unterrichtetKlassen = new ArrayList<SchoolClass>();
	
}
