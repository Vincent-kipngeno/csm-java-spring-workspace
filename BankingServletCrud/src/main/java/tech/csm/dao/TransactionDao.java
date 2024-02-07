package tech.csm.dao;

import java.util.List;

import tech.csm.entity.BTransaction;

public interface TransactionDao {

	String saveTransaction(BTransaction t);

	List<BTransaction> getAllTransactions();

}
