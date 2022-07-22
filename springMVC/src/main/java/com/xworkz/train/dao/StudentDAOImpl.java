package com.xworkz.train.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.entiy.StudentEntity;

@Component
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public StudentDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	@Override
	public boolean saveStudentDetails(StudentEntity studentEntity) {
		boolean isDataSaved = false;

		try (Session session = sessionFactory.openSession();) {
			Transaction transaction = session.beginTransaction();
			session.save(studentEntity);
			transaction.commit();
			System.out.println("Student entity saved into DB");
			isDataSaved = true;
			return isDataSaved;
		}

	}

	@Override
	public StudentEntity findStudentEntityByStudentName(String studentName) {
		System.out.println("Invoke findStudentEntityByStudentName() by " + this.getClass().getSimpleName());
		StudentEntity studentEntity=null;
		try (Session session = sessionFactory.openSession();) {

			Transaction transaction = session.beginTransaction();
			//System.out.println("--------transaction start------");
			Query query = session.createNamedQuery("StudentEntity.getByName");
			query.setParameter("FirstName", studentName);
			Object result = query.uniqueResult();
			System.out.println("Data fetching from db= "+result);
			 studentEntity = (StudentEntity) result;
			if (studentEntity != null) {
				
				return studentEntity;
			}else {
				System.out.println("StudentEntity not found");
			}
		}
		return studentEntity;
	}
}