package com.xworkz.ormModule.dao;

import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.xworkz.ormModule.dto.MobileDTO;

public class MobileDAOImpl implements MobileDAO {

	static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration().configure("hibernate.conPros.xml")
				.addAnnotatedClass(MobileDTO.class);
		sessionFactory = configuration.buildSessionFactory();
	}
	@Override
	public void getAllMobiles() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String q = "select * from mobiledetails";
		Query query = session.getNamedQuery(q);
		// Query query = session.getNamedQuery("MobileDTO.getAll");
		List list = query.list();
		System.out.println(list);
		transaction.commit();
		session.close();
	}

}
