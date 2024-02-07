package tech.csm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tech.csm.entity.BTransaction;
import tech.csm.util.DBUtil;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public String saveTransaction(BTransaction t) {
		Session ses = DBUtil.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		ses.persist(t);
		String msg="1 transaction is added with id: "+ses.getIdentifier(t);
		tx.commit();
		ses.close();
		
		return msg;
	}

	@Override
	public List<BTransaction> getAllTransactions() {
		final String seQuery="from BTransaction";
		Session ses = DBUtil.getSessionFactory().openSession();
		Query<BTransaction> qr = ses.createQuery(seQuery);
		List<BTransaction> transactionList=qr.list();
		
		
		ses.close();
		return transactionList;
	}


}
