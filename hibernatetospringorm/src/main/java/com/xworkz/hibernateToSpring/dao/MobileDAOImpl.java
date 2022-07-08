package com.xworkz.hibernateToSpring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.hibernateToSpring.dto.MobileEntity;

//Using datasource driver manager
@Component
public class MobileDAOImpl implements MobileDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public MobileDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void getAllMobiles() {
		try (Session session = sessionFactory.openSession();) {
			Query query = session.getNamedQuery("MobileEntity.getAll");
			List list = query.list();
			System.out.println(list);
		}

	}

}
