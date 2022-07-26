package com.xworkz.student.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.student.dto.StudentDTO;
import com.xworkz.student.entity.StudentEntity;

@Component
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
			Query query = session.createNamedQuery("StudentEntity.getByName");
			query.setParameter("FirstaName", studentName);
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
			Query query = session.createNamedQuery("StudentEntity.getAll");
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
	public boolean deleteByName(String studentName) {
		boolean isDataDeleted=false;
		try (Session session = sessionFactory.openSession();) {
			Transaction transaction = session.beginTransaction();
			Query query = session.createNamedQuery("StudentEntity.deleteByname");
			query.setParameter("FIRSTName", studentName);
			int update = query.executeUpdate();
			System.out.println(update + " record deleted");
			if (update>0) {
				isDataDeleted=true;
			}
			transaction.commit();
			return isDataDeleted;
		}
	}
}
