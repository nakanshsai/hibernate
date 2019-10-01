package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperations {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure();
		// singleton and heavy weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();// represents database connection and light weight
		Transaction t = s.beginTransaction();
		// insert new record
		// Product p = new Product(1009,"pendrive","sandisk",(float) 999.00);
		// s.save(p);

		// get record according to primary key

		/*
		 * Product p =s.get(Product.class,1000);
		 * 
		 * //Product p =s.load(Product.class,1009); if(p!=null) { System.out.println(p);
		 * } else { System.out.println("id doesnot exist"); }
		 */

		// update a record
		/*
		 * Product p =s.get(Product.class,1004); if(p!=null) {
		 * 
		 * 
		 * 
		 * p.setPrice(2000+p.getPrice()); s.update(p);
		 * 
		 * 
		 * 
		 * } else { System.out.println("id doesnot exist"); }
		 */

		
		//delete record
		Product p = s.get(Product.class, 1004);
		if (p != null) {

			
			s.delete(p);
			System.out.println("record deleted");
			

		} else {
			System.out.println("id doesnot exist");
		}

		t.commit();
		s.close();

	}

}
