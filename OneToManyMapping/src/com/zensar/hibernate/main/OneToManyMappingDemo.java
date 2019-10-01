package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class OneToManyMappingDemo {
	public static void main(String[] args) {
		
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Movie m = new Movie();
		m.setTitle("ddlj");
		m.setReleaseDate(LocalDate.of(2019,9, 27));
		
		Song so = new Song("asd");
		Song so1 = new Song("asdf");
		Song so2 = new Song("asdfg");
		
		so.setMovie(m);
		so1.setMovie(m);
		so2.setMovie(m);
		
		
		List<Song> songs = new ArrayList<Song>();
		songs.add(so);
		songs.add(so1);
		songs.add(so2);
		
		m.setSongs(songs);
		
		s.delete(m);
		
		s.save(so);
		s.save(so1);
		s.save(so2);
		s.save(m);
		
		t.commit();
		s.close();
		
		
	}

}
