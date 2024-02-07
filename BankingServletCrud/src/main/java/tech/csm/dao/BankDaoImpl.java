package tech.csm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import tech.csm.entity.Bank;
import tech.csm.util.DBUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public List<Bank> getAllBanks() {
		Session ses = DBUtil.getSessionFactory().openSession();
		Query<Bank> qr = ses.createQuery("from Bank");
		List<Bank> bankList=qr.list();
		ses.close();
		return bankList;
	}

}
