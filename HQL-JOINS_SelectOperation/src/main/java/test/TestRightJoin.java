package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.HibernateUtil;
import base.Product;

public class TestRightJoin {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			//SELECT prod.pcode, prod.pcost, mod.mcolor  FROM base.Product prod RIGHT JOIN  prod.mods AS mod;
			String hql=new StringBuilder("SELECT prod.pcode, mod.mcolor ")
					.append(" FROM "+Product.class.getName()+" prod")
					.append(" RIGHT JOIN ")
					.append(" prod.mods AS mod")
					.toString();

			System.out.println("-----------------------------");
			System.out.println(hql);

			Query q=ses.createQuery(hql);
			List<Object[]> l=q.list();

			for (Object[] objects : l) {
				System.out.println(objects[0]+"-"+objects[1]+"-"+objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
