package com.xworkz.student.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.student.entity.StudentEntity;
import com.xworkz.student.service.StudentServiceImpl;


@Repository
public class StudentDAOImpl implements StudentDAO {
	private static final Logger logger=Logger.getLogger(StudentDAOImpl.class.getName());

	@Autowired
	private SessionFactory sessionFactory;

	public StudentDAOImpl() {
		logger.info(this.getClass().getSimpleName() + " bean created");
	}

	@Override
	public boolean saveStudentDetails(StudentEntity studentEntity) {
		logger.info("DATA COMING FROM SERVICE TO DAO " + studentEntity);
		boolean isDatasaved = false;
		try (Session session = sessionFactory.openSession();) {
			logger.info("session created");
			Transaction transaction = session.beginTransaction();
			session.save(studentEntity);
			logger.info("data stored in db successfully ");
			transaction.commit();
			logger.debug("transaction commited");
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
			logger.info(result+" query executed and values are came");
			studentEntity = (StudentEntity) result;
			if (studentEntity != null) {
				return studentEntity;
			} else {
				logger.info("student entity not found");
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
				logger.error("Table is Empty");
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
				logger.info(update + " record deleted");
				isDataDeleted = true;
			} else {
				logger.info("No record deleted...data is not found in database..");
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			transaction.commit();
			session.close();
			logger.info("Session closed");
		}
		return isDataDeleted;
	}

	@Override
	public boolean updateStudentEntityByName(StudentEntity studentEntity) {
		logger.info("updateStudentEntityByName--");
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
			int update = query.executeUpdate();
			logger.info(update+" updated successfully");
			
			Query query2 = session.createNamedQuery("updateNameOnly");
			query2.setParameter("FIRSTNAMEUP", studentEntity.getFirstname());
			query2.setParameter("LastName", studentEntity.getLastname());
			int executeUpdate = query2.executeUpdate();
			logger.info(executeUpdate+" updated successfully");
			transaction.commit();
			isStudentEntityUpdated=true;
		}
		
		return isStudentEntityUpdated;
	}
}
