package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Account;

public interface AccountDao {

	List<Account> getAccountByBankId(Integer bankId);

}
