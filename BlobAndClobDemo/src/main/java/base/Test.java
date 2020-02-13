package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		try {
			Configuration cfg=new Configuration().configure();
			SessionFactory sf=cfg.buildSessionFactory();
			Session ses=sf.openSession();
			Transaction tx=ses.beginTransaction();

			ModelClass mc=new ModelClass();
			mc.setStdId(101);
			mc.setStdName("ABC");
			try {
				FileInputStream fis=new FileInputStream("F:/ExtractDataFromImage-Java/Screenshot.png");
				byte[] barr=new byte[fis.available()];
				fis.read(barr);
				
				String longText="Some LOng Text here";
				char[] carr=longText.toCharArray();
				mc.setStdImg(barr);
				mc.setStdText(carr);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			ses.save(mc);
			tx.commit();
			ses.close();
			
			System.out.println("Done!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
