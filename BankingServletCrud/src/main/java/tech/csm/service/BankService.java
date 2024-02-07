package tech.csm.service;

import java.util.List;

import tech.csm.entity.Bank;
import tech.csm.entity.BankVO;

public interface BankService {

	List<BankVO> getAllBlocks();

	Bank convertBankVOToBank(BankVO bankVO);

	BankVO convertBankToBankVO(Bank bank);

}
