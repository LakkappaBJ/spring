package com.xworkz.train.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.xworkz.entiy.TrainEntity;


@Component
public class TrainDAOImpl implements TrainDAO {
	public TrainDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " invoked");
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	public TrainDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

/*
	public int saveData(int trainNo, String trainName) {
		System.out.println("DAO started");
		String sql = "Insert Into train(TNO,TNAME)values ('" + trainNo + "','" + trainName + "')";
		TrainEntity trainDTO = new TrainEntity();
		trainDTO.setTrainNo(trainNo);
		trainDTO.setTrainName(trainName);
		int insert = jdbcTemplate.update(sql);
		System.out.println(insert + " Data is successfully inserted ");
		System.out.println(trainDTO);
		return insert;
	}
	//BOTH METHODS ARE WORK 
	*/
	public int saveData(int trainNo, String trainName) {
		System.out.println("DAO started");
		try(Session session=sessionFactory.openSession();){
			Transaction transaction = session.beginTransaction();
			TrainEntity trainEntity = new TrainEntity(trainNo,trainName);
			System.out.println("trainEntity " +trainEntity);
			session.save(trainEntity);
			transaction.commit();
			System.out.println(" Data is successfully inserted ");
		}
		return 1;
	}

	@Override
	public void getAllTrains() {
		try (Session session = sessionFactory.openSession();) {
			Query query = session.getNamedQuery("getAll");
			List list = query.list();
			System.out.println(list + " getAll Train details");
		}
	}

}
