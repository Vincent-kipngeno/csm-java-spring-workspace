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

	@Override
	public List<Village> getAllVillagesByBlockAndPopulation(int bId, int pop) {
		final String seQuery="from Village v where v.panchayat.block.blockId=:bId and v.population <=:pop";
		Session ses = DBUtil.getSessionFactory().openSession();
		Query<Village> qr = ses.createQuery(seQuery);
		qr.setParameter("bId", bId);
		qr.setParameter("pop", pop);
		List<Village> villageList=qr.list();
		
		
		ses.close();
		return villageList;
	}

	@Override
	public List<Village> getAllVillagesByPopulation(int pop) {
		final String seQuery="from Village v where v.population <=:pop";
		Session ses = DBUtil.getSessionFactory().openSession();
		Query<Village> qr = ses.createQuery(seQuery);
		qr.setParameter("pop", pop);
		List<Village> villageList=qr.list();
		
		
		ses.close();
		return villageList;
	}

	@Override
	public List<Village> getAllVillagesByBlock(int bId) {
		final String seQuery="from Village v where v.panchayat.block.blockId=:bId";
		Session ses = DBUtil.getSessionFactory().openSession();
		Query<Village> qr = ses.createQuery(seQuery);
		qr.setParameter("bId", bId);
		List<Village> villageList=qr.list();
		
		
		ses.close();
		return villageList;
	}

}
