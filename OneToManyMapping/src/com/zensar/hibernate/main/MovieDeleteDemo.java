package com.zensar.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class MovieDeleteDemo {
	public static void main(String[] args) {
		
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Movie m =s.get(Movie.class,4);
		System.out.println(m.getTitle());
		System.out.println(m.getReleaseDate());
		
		
		List<Song> songs = m.getSongs();
		for(Song s1: songs) {
			System.out.println(s1);
		}
		if(m!=null) {
			s.delete(m);
	
		}
		else {
			System.out.println("movie not found");
		}
		
		t.commit();
		s.close();
		System.exit(0);
	}

}
