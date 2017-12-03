package mum.edu.app;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;

import mum.edu.persistance.HibernateUtil;


public class Application {

	private static EntityManagerFactory emf;
	private static SessionFactory session;


	public static void main(String[] args) {
	    session = HibernateUtil.getInstance().getSessionFactory();
//		session.getCurrentSession().
//		emf.close();
	}


}
