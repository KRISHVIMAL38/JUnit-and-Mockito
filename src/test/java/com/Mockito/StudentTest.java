package com.Mockito;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class StudentTest {
	StudentService studserv=Mockito.mock(StudentService.class);
	Student student=new Student(studserv);
	
	@Test
	public void getAvgMsrksTest() {
		
		Mockito.when(studserv.getTotalMarks()).thenReturn(500);
		Mockito.when(studserv.getTotalStudents()).thenReturn(10);
		Assertions.assertEquals(50, student.getAvgMarks());
	}
}
