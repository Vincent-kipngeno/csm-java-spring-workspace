package tech.csm.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import tech.csm.entity.Panchayat;
import tech.csm.util.DBUtil;

public class PanchayatDaoImpl implements PanchayatDao {

	@Override
	public List<Panchayat> getPanchayatByBlockId(Integer blockId) {
		Session ses = DBUtil.getSessionFactory().openSession();
		final String sequery = "from Panchayat p where p.block.blockId=:blockId";
		Query<Panchayat> qr = ses.createQuery(sequery);
		qr.setParameter("blockId", blockId);
		List<Panchayat> panchayatList = qr.list();
		ses.close();
		return panchayatList;
	}

	@Override
	public Panchayat getPanchayatByPanchayatId(Integer panchayatId) {
		Session ses = DBUtil.getSessionFactory().openSession();
		final String sequery = "from Panchayat p where p.panchayatId=:panchayatId";
		Query<Panchayat> qr = ses.createQuery(sequery);
		qr.setParameter("panchayatId", panchayatId);
		Panchayat panchayat = qr.uniqueResult();
		ses.close();
		return panchayat;
	}

}
