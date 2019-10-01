package com.zensar.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.User;

/**
 * @author akansh_sai
 * @modification date  28th sept 2019 11:13am
 * @version 2.0
 *@copyright Zensar Technologies All rights reserved
 */

public class UserDaoImpl implements UserDao {
	private Session session;
	public UserDaoImpl() {
		
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		session= sf.openSession();
		
	}
	
	@Override
	public void insert(User user) {
		Transaction t = session.beginTransaction();
		session.save(user);
		t.commit();
		
		
	}

	@Override
	public void update(User user) {
		Transaction t = session.beginTransaction();
		session.update(user);
		t.commit();
		
	}

	@Override
	public void delete(User user) {
	
		Transaction t = session.beginTransaction();
		session.delete(user);
		t.commit();
		
	}

	@Override
	public User getByUsername(String username) {
		
		
		
		return session.get(User.class, username);
	}

	@Override
	public List<User> getAll() {
		
		Query q = session.createQuery("from User");
		return q.getResultList();
	}

	
	

}
