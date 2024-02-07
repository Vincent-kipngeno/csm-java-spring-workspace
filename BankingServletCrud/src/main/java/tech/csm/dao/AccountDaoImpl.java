package tech.csm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import tech.csm.entity.Account;
import tech.csm.util.DBUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> getAccountByBankId(Integer bankId) {
		final String seQuery="from Account a where a.bank.bankId=:bid";
		Session ses = DBUtil.getSessionFactory().openSession();
		Query<Account> qr = ses.createQuery(seQuery);
		qr.setParameter("bid", bankId);
		List<Account> accountList=qr.list();
		ses.close();
		return accountList;
	}

}
