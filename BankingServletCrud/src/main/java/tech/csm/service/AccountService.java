package tech.csm.service;

import java.util.List;

import tech.csm.entity.Account;
import tech.csm.entity.AccountVO;

public interface AccountService {

	List<Account> getAccountByBankId(Integer bankId);

	AccountVO convertAccountToAccountVO(Account account);

	Account convertAccountVOToAccount(AccountVO accountVO);

}
