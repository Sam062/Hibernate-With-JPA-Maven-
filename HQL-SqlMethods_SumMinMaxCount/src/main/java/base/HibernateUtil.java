package base;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	static {
		sf=new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSfg() {
		return sf;
	}

}
