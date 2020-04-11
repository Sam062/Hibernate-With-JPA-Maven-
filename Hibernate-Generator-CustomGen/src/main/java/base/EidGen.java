package base;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EidGen implements IdentifierGenerator{
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		//FORMAT-- NIT-HIB-MMYYYY-RANDOM_NUM
		/*java.util.Date d=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MMyyyy");
		String s=sdf.format(d);

		Random r=new Random();
		int num=r.nextInt(10000);

		return "NIT-HIB-"+s+"-"+num;
		 */

		//##########  TASK  ##############################
		//YEAR-NIT-MONTH-HRS:MIN-BOOT-SEC_RANDOM_NUM --Format

		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(d); //2020

		sdf=new SimpleDateFormat("MM");
		String month=sdf.format(d);//05

		sdf=new SimpleDateFormat("hh:mm");
		String hhmm=sdf.format(d);//04:36

		sdf=new SimpleDateFormat("ss");
		String sec=sdf.format(d);//59

		int randomNum=new Random().nextInt(10000);
		
		//PK Value as : 2020-NIT-04-04:39-BOOT-40_8475
		return year+"-NIT-"+month+"-"+hhmm+"-BOOT-"+sec+"_"+randomNum;
	}

}
