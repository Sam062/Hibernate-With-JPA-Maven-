package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.HibernateUtil;
import base.Product;

public class TestFullJoin {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			//SELECT prod.pcode, prod.pcost, mod.mcolor  FROM base.Product prod FULL JOIN  prod.mods AS mod;
			String hql=new StringBuilder("SELECT prod.pcode, prod.pcost, mod.mcolor")
					.append(" FROM "+Product.class.getName()+" prod")
					.append(" FULL JOIN ")
					.append(" prod.mods mod")
					.toString();

			System.out.println("-----------------------------");
			System.out.println(hql);

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
