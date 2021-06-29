package com.te.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.dao.StudentDAO;

import com.te.springboot.dto.StudentBean;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;

	@Override
	public boolean insertStudent(StudentBean studentBean) {
		// TODO Auto-generated method stub
		return dao.insertStudent(studentBean);
	}

	@Override
	public StudentBean searchStudent(int Userid) {
		// TODO Auto-generated method stub
		return dao.searchStudent(Userid);
	}

	@Override
	public boolean removeStudent(int Userid) {
		// TODO Auto-generated method stub
		return dao.removeStudent(Userid);
	}

	@Override
	public boolean updateStudent(StudentBean bean) {
		// TODO Auto-generated method stub
		return dao.updateStudent(bean);
	}

	@Override
	public double aggregateMarks(double Marks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char gradeStudent(char Grade) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	

}
