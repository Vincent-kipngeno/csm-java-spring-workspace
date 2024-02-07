package tech.csm.service;

import java.util.ArrayList;
import java.util.List;

import tech.csm.dao.BankDao;
import tech.csm.dao.BankDaoImpl;
import tech.csm.entity.Bank;
import tech.csm.entity.BankVO;

public class BankServiceImpl implements BankService {

	private BankDao blockDao;
	public BankServiceImpl() {
		blockDao=new BankDaoImpl();
	}
	
	@Override
	public List<BankVO> getAllBlocks() {
		List<BankVO> bankVOList = new ArrayList<>();
		blockDao.getAllBanks().forEach(b -> bankVOList.add(convertBankToBankVO(b)));
		return bankVOList;
	}
	
	public BankVO convertBankToBankVO(Bank b) {
		BankVO bVO = new BankVO();
		bVO.setBankId(b.getBankId().toString());
		bVO.setIfscCode(b.getIfscCode());
		bVO.setName(b.getName());
		return bVO;
	}
	
	public Bank convertBankVOToBank(BankVO bVO) {
	    Bank bank = new Bank();
	    bank.setBankId(Integer.parseInt(bVO.getBankId()));
	    bank.setIfscCode(bVO.getIfscCode());
	    bank.setName(bVO.getName());
	    return bank;
	}

}
