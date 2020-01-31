package application.Model;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass implements DataBaseObject{
	
	int ID, lehrerID;
	String Klassenname;
	List<Student> dieSchueler = new ArrayList<Student>(); 

}
