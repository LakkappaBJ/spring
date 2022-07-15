package com.xworkz.train.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.xworkz.train.dto.TrainDTO;

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

	public int saveData(int trainNo, String trainName) {
		System.out.println("DAO started");
		String sql = "Insert Into train(TNO,TNAME)values ('" + trainNo + "','" + trainName + "')";
		TrainDTO trainDTO = new TrainDTO();
		trainDTO.setTrainNo(trainNo);
		trainDTO.setTrainName(trainName);
		int insert = jdbcTemplate.update(sql);
		System.out.println(insert + " Data is successfully inserted ");
		System.out.println(trainDTO);
		return insert;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public TrainDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void getAllTrains() {
		try (Session session = sessionFactory.openSession();) {
			Query query = session.getNamedQuery("getAll");
			List list = query.list();
			System.out.println(list+" getAll Train details");
		}
	}
}
