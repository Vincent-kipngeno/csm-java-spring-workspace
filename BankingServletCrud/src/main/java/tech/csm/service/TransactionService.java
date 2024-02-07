package tech.csm.service;

import java.util.List;

import tech.csm.entity.BTransaction;

public interface TransactionService {

	String saveVillage(BTransaction v);

	List<BTransaction> getAllVillages();

}
