package com.xworkz.student.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.student.entity.StudentEntity;


@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public StudentDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	@Override
	public boolean saveStudentDetails(StudentEntity studentEntity) {
		System.out.println("DATA COMING FROM SERVICE TO DAO " + studentEntity);
		boolean isDatasaved = false;
		try (Session session = sessionFactory.openSession();) {
			Transaction transaction = session.beginTransaction();
			session.save(studentEntity);
			System.out.println("data stored in db successfully ");
			transaction.commit();
			isDatasaved = true;
		}
		return isDatasaved;
	}

	@Override
	public StudentEntity findStudentEntityByStudentName(String studentName) {
		StudentEntity studentEntity = null;

		try (Session session = sessionFactory.openSession();) {
			Query query = session.createNamedQuery("StudentEntity.getStudentByName");
			query.setParameter("INPUTNAME", studentName);
			Object result = query.uniqueResult();
			studentEntity = (StudentEntity) result;
			if (studentEntity != null) {
				return studentEntity;
			} else {
				System.out.println("student entity not found");
			}
		}
		return studentEntity;
	}

	@Override
	public List<StudentEntity> getAllStudeInfo() {
		List<StudentEntity> list = null;
		try (Session session = sessionFactory.openSession();) {
			Query query = session.createNamedQuery("StudentEntity.getAllStudents");
			list = query.list();
			if (list.size() > 0 && list != null) {
				return list;
			} else {
				System.err.println("Table is Empty");
			}
		}
		return list;
	}

	@Override
	public boolean deleteByStudentName(String studentName) {
		Session session = null;
		Transaction transaction = null;
		boolean isDataDeleted = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery("StudentEntity.deleteByStudentname");
			query.setParameter("FIRSTName", studentName);
			int update = query.executeUpdate();
			if (update > 0) {
				System.out.println(update + " record deleted");
				isDataDeleted = true;
			} else {
				System.out.println("No record deleted...data is not found in database..");
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			transaction.commit();
			session.close();
			System.out.println("Session closed");
		}
		return isDataDeleted;
	}

	@Override
	public boolean updateStudentEntityByName(StudentEntity studentEntity) {
		System.out.println("updateStudentEntityByName--");
		boolean isStudentEntityUpdated=false;
		try(Session session= sessionFactory.openSession();){
			Transaction transaction = session.beginTransaction();
			Query query = session.createNamedQuery("StudentEntity.updateStudentEntityByStudentname");
			query.setParameter("FirstNAME", studentEntity.getFirstname());
			query.setParameter("MiddleName", studentEntity.getMiddlename());
			query.setParameter("LastName", studentEntity.getLastname());
			query.setParameter("Course", studentEntity.getCourse());
			query.setParameter("Gender", studentEntity.getGender());
			query.setParameter("Phone", studentEntity.getPhone());
			query.setParameter("Address", studentEntity.getAddress());
			query.setParameter("Email", studentEntity.getEmail());
			query.setParameter("PassWord", studentEntity.getPassword());
			query.setParameter("PSWRepeat", studentEntity.getPswRepeat());
			query.executeUpdate();
			
			Query query2 = session.createNamedQuery("updateNameOnly");
			query2.setParameter("FIRSTNAMEUP", studentEntity.getFirstname());
			query2.setParameter("LastName", studentEntity.getLastname());
			query2.executeUpdate();
			
			transaction.commit();
			isStudentEntityUpdated=true;
		}
		
		return isStudentEntityUpdated;
	}
}
