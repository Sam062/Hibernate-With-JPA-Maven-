package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.HibernateUtil;
import base.Product;

public class TestLeftJoin {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			/*
			SELECT prod.pcode, p.pcost, mod.mcolor  
			FROM base.Product prod 
			LEFT JOIN  
			prod.mods AS mod
			 */
			String hql=new StringBuilder("SELECT prod.pcode, prod.pcost, mod.mcolor ")
					.append(" FROM "+Product.class.getName()+" prod")
					.append(" LEFT JOIN ")
					.append(" prod.mods AS mod")
					.toString();
			
			Query q=ses.createQuery(hql);
			List<Object[]> l=q.list();
			
			for (Object[] objects : l) {
				System.out.println(objects[0]+"-"+objects[1]+"-"+objects[2]);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
