package tech.csm.service;

import java.util.List;

import tech.csm.dao.AccountDao;
import tech.csm.dao.AccountDaoImpl;
import tech.csm.entity.Account;
import tech.csm.entity.AccountVO;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	private BankService bankService;
	
	public AccountServiceImpl() {
		accountDao=new AccountDaoImpl();
		bankService = new BankServiceImpl();
	}
	
	
	@Override
	public List<Account> getAccountByBankId(Integer bankId) {
		
		return accountDao.getAccountByBankId(bankId);
	}
	
	public Account convertAccountVOToAccount(AccountVO aVO) {
        Account a = new Account();
        a.setAccountNo(aVO.getAccountNo());
        a.setName(aVO.getName());
        a.setPhoneNo(aVO.getPhoneNo());
        a.setEmailId(aVO.getEmailId());
        a.setAccountType(aVO.getAccountType());
        a.setBalance(Double.parseDouble(aVO.getBalance()));
        a.setBank(bankService.convertBankVOToBank(aVO.getBankVO()));
        return a;
    }

    public AccountVO convertAccountToAccountVO(Account a) {
    	AccountVO aVO = new AccountVO();
        aVO.setAccountNo(a.getAccountNo());
        aVO.setName(a.getName());
        aVO.setPhoneNo(a.getPhoneNo());
        aVO.setEmailId(a.getEmailId());
        aVO.setAccountType(a.getAccountType());
        aVO.setBalance(a.getBalance().toString());
        aVO.setBankVO(bankService.convertBankToBankVO(a.getBank()));
        return aVO;
    }

}
