package mum.edu.app;

import org.hibernate.SessionFactory;

import mum.edu.persistance.HibernateUtil;

public class App {
    private static SessionFactory session;
    
	public static void main(String[] args){
      session = HibernateUtil.getInstance().getSessionFactory();
//    session.getCurrentSession().
//    emf.close();
	}
	
}
