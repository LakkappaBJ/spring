package com.xworkz.ormModule.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.ormModule.dto.StudentEntity;

@Component
public class StudentDAOImpl implements StudentDAO {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	static SessionFactory buildSessionFactory;
	static {
		Configuration configuration = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(StudentEntity.class);
		buildSessionFactory = configuration.buildSessionFactory();
	}
	
	public void showAll(StudentEntity studentEntity) {
		try(Session session = buildSessionFactory.openSession();) {
			String hql = "StudentEntity.findAll";
			Query query1 = session.getNamedQuery(hql);
			List list = query1.list();
			System.out.println(list);
			session.close();
		}
	}
	


}
