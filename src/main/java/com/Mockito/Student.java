package com.Mockito;

public class Student {
	StudentService studserv;
	
	Student(StudentService studserv){
		this.studserv=studserv;
	}
	
	 int getAvgMarks() {
		return studserv.getTotalMarks()/studserv.getTotalStudents();
	}

}
