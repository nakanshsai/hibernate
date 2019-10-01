package com.zensar.hibernate.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class ComponentMappingMain {

	public static void main(String[] args) {
		Configuration c =new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
	
		Name name= new Name();
		name.setFirstName("n");
		name.setMiddleName("akansh");
		name.setLastName("sai");
		
		Customer cu = new Customer();
		cu.setCustomerId(2);
		cu.setCustomerName(name);
		cu.setGender("male");
		cu.setAge(22);
		cu.setAddress("bangalore");
		cu.setBirthDate(LocalDate.of(1997, 6, 8));
		
		try {
			File photo = new File("./resources/customer.png");
			FileInputStream fnp = new FileInputStream(photo);		//opening file in read file
			Blob customerPhoto = BlobProxy.generateProxy(fnp, photo.length());
			cu.setProfilePhoto(customerPhoto);
			
			File file2 = new File("./resources/customerInfo.txt");
			FileReader fr = new FileReader(file2);
			Clob description = ClobProxy.generateProxy(fr, file2.length());
			cu.setDescription(description);
			
			
			s.save(cu);
			
			
			
			t.commit();
			s.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
