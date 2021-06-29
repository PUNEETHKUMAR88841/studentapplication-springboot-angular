package com.te.springboot.service;

import com.te.springboot.dto.StudentBean;

public interface StudentService {

public boolean insertStudent(StudentBean studentBean);
	
	public StudentBean searchStudent(int Userid);

	public boolean removeStudent(int Userid);

	public boolean updateStudent(StudentBean bean);
	
	public double aggregateMarks(double Marks);
	
    public char gradeStudent(char Grade);


}
