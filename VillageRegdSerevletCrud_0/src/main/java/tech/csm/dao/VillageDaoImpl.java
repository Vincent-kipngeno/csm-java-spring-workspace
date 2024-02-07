package tech.csm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tech.csm.entity.Village;
import tech.csm.util.DBUtil;

public class VillageDaoImpl implements VillageDao {

	@Override
	public String saveVillage(Village v) {
		Session ses = DBUtil.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		ses.persist(v);
		String msg="1 village is added with id: "+ses.getIdentifier(v);
		tx.commit();
		ses.close();
		
		return msg;
	}

	@Override
	public List<Village> getAllVillages() {
		final String seQuery="from Village";
		Session ses = DBUtil.getSessionFactory().openSession();
		Query<Village> qr = ses.createQuery(seQuery);
		List<Village> villageList=qr.list();
		
		
		ses.close();
		return villageList;
	}

}
