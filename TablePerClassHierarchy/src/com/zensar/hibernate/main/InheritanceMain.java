package com.zensar.hibernate.main;



import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Employee;
import com.zensar.entities.WageEmp;

public class InheritanceMain {

	public static void main(String[] args) {
	
		Configuration c =new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
	Employee e = new Employee();
	
		e.setName("akansh");
		e.setJoinDate(LocalDate.of(2019, 8, 26));
		e.setSalary(7600);
		
		s.save(e);
		
	WageEmp we = new WageEmp();
		
		we.setName("rahul");
		we.setJoinDate(LocalDate.of(2019, 8, 26));
		we.setSalary(10000);
		we.setHours(5);
		we.setRate(20f);
		
		s.save(we);
		
		
		
		
		t.commit();
		s.close();

	}

}
