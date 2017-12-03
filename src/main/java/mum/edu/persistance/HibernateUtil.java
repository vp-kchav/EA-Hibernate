package mum.edu.persistance;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static HibernateUtil INSTANCE = null;
 
	private final SessionFactory sessionFactory=buildSessionFactory();
	private SessionFactory buildSessionFactory() {
		try{
		    return new Configuration().configure().buildSessionFactory();
	}
	catch (Throwable ex){
		System.err.println("Initial SessionFactory creation failed." + ex);
		throw new ExceptionInInitializerError(ex);
	}
}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public void shutdown(){
		getSessionFactory().close();
	}
	
	// private constructor restricted to this class itself
    private HibernateUtil()
    {
  
    }
    // static method to create instance of Singleton class
    public static HibernateUtil getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new HibernateUtil();
 
        return INSTANCE;
    }
    

}