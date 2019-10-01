package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

public class OneToOneMappingDemo {

	public static void main(String[] args) {
	
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Country c1 = new Country();
		
		c1.setName("spain");
		c1.setLanguage("espanol");
		c1.setPopulation(1000000l);
		
		Flag f =new Flag();
		f.setFlagName("two coloured flag");
		f.setDescription("red and yellow");
		
		c1.setFlag(f);
		f.setCountry(c1);
		 
		s.save(c1);
		s.save(f);
		
		
		t.commit();
		s.clear();
		System.exit(0);
	}

}
