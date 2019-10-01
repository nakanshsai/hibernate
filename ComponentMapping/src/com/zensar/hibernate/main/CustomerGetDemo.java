package com.zensar.hibernate.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class CustomerGetDemo {

	public static void main(String[] args) {
		Configuration c =new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
	Customer c1= s.get(Customer.class,2);
		System.out.println(c1.getCustomerId());
		System.out.println(c1.getAddress());
		System.out.println(c1.getAge());
		System.out.println(c1.getGender());
		System.out.println(c1.getBirthDate());
		
		Name customerName = c1.getCustomerName();
		System.out.println(customerName);
		
		Blob customerPhoto = c1.getProfilePhoto();
		
		
		try {
			InputStream in =customerPhoto.getBinaryStream();
			FileOutputStream fout = new FileOutputStream("./resources/newPhoto1.png");
			
			int data = 0;
			while((data=in.read())!=-1) {
				fout.write(data);
			}
			in.close();
			fout.close();
			
			
			Clob description =c1.getDescription(); 
			Reader r = description.getCharacterStream();
			//PrintWriter pw = new PrintWriter("./resources/customerDbInfo.txt");
			FileWriter pw = new FileWriter("./resources/customerDb.txt");
			int charData =0;
			while((charData=r.read())!=-1) {
				//pw.print((char)charData);
				pw.write(charData);
			}
			r.close();
			pw.close();
			
			t.commit();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
