package com.te.springboot.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.springboot.dto.StudentBean;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	
	
	@Override
	public boolean insertStudent(StudentBean studentBean) {
		entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isAdd = false;
		try {
			entityTransaction.begin();
			entityManager.persist(studentBean);

			entityTransaction.commit();
			isAdd = true;

		} catch (Exception e) {
			entityTransaction.rollback();
			isAdd = false;
			e.printStackTrace();
		}
		return isAdd;
	}// end of addemp

	

	@Override
	public StudentBean searchStudent(int Userid) {
		entityManager = entityManagerFactory.createEntityManager();

		StudentBean bean = entityManager.find(StudentBean.class, Userid);
		if (bean != null) {
			return bean;
		} else {
			return null;
		}

	}// end of search

	@Override
	public boolean removeStudent(int Userid) {
		entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			StudentBean studentBean = entityManager.find(StudentBean.class, Userid);
			if (studentBean != null) {
				entityManager.remove(studentBean);
				entityTransaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}// end of deleteemp

	@Override
	public boolean updateStudent(StudentBean bean) {
		entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isUpdate = false;

		try {
			entityTransaction.begin();
			StudentBean info = entityManager.find(StudentBean.class, bean.getUserid());
			if (bean.getName() != null && bean.getName() != "") {
				info.setName(bean.getName());
			}
			if (bean.getEmail() != null) {
				info.setEmail(bean.getEmail());
			}
			
			entityTransaction.commit();
			isUpdate = true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return isUpdate;
	} // end of update

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

//	@Override
//	public char gradeStudent(char Grade) {
//		if(Grade <=10 && Grade >= 9.1){
//			Logger("Excellent: Grade A");
//		}else if(percentage < 90 && percentage >= 80){
//			System.out.println("Very Good: Grade B");
//		}else if(percentage < 80 && percentage >= 70){
//			System.out.println("Good: Grade C");
//		}else if(percentage < 70 && percentage >= 60){
//			System.out.println("Satisfactory: Grade D");
//		}else if(percentage < 60 && percentage >= 50){
//			System.out.println("Work Hard: Grade E");
//		}else if(percentage < 50 && percentage >= 40){
//			System.out.println("Just Passed: Grade F");
//		}else {
//			System.out.println("Failed!");
//		return 0;
//	}
//
//}
}
