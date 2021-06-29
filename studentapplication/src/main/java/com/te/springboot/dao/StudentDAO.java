package com.te.springboot.dao;


import com.te.springboot.dto.StudentBean;

public interface StudentDAO {
	
	public boolean insertStudent(StudentBean studentBean);
	
	public StudentBean searchStudent(int Userid);

	public boolean removeStudent(int Userid);

	public boolean updateStudent(StudentBean bean);
	
	public double aggregateMarks(double Marks);
	
    public char gradeStudent(char Grade);



	

}
