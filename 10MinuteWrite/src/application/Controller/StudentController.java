package application.Controller;

import application.Model.Model;
import application.Model.Student;
import application.View.StudentView;

public class StudentController implements UserController{
	
	Student user;
	Model theModel;
	StudentView theView;
	
	
	public StudentController(Model theModel, StudentView theView) {
		
		//this.user = user
		this.theModel = theModel;
		this.theView = theView;
		
	}


	@Override
	public boolean logOut() {
		// TODO Automatisch generierter Methodenstub
		return false;
	}

}
