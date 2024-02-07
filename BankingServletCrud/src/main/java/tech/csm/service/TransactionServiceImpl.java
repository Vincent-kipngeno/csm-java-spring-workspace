package tech.csm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import tech.csm.dao.AccountDaoImpl;
import tech.csm.dao.TransactionDao;
import tech.csm.dao.TransactionDaoImpl;
import tech.csm.entity.BTransaction;
import tech.csm.entity.BTransactionVO;

public class TransactionServiceImpl implements TransactionService {
 
	private TransactionDao  transactionDao;

	private AccountService accountService;
	
	public TransactionServiceImpl() {
		transactionDao=new TransactionDaoImpl();
		accountService = new AccountServiceImpl();
	}
	
	@Override
	public String saveVillage(BTransaction v) {
		
		return transactionDao.saveTransaction(v);
	}
	@Override
	public List<BTransaction> getAllVillages() {
		
		return transactionDao.getAllTransactions();
	}
	
	public BTransactionVO convertEntityToVO(BTransaction t) {
        BTransactionVO tVO = new BTransactionVO();
        tVO.setTransactionId(t.getTransactionId().toString());
        tVO.setTransactionDate(new SimpleDateFormat("YYYY/mm/dd").format(t.getTransactionDate()));
        tVO.setTransactionType(Character.toString(t.getTransactionType()));
        tVO.setAmount(t.getAmount().toString());
        tVO.setAccountVO(accountService.convertAccountToAccountVO(t.getAccount()));
        return tVO;
    }

    public BTransaction convertVOToEntity(BTransactionVO tVO) throws ParseException {
        BTransaction t = new BTransaction();
        t.setTransactionId(Integer.parseInt(tVO.getTransactionId()));
        t.setTransactionDate(new SimpleDateFormat("YYYY/mm/dd").parse(tVO.getTransactionDate()));
        t.setTransactionType(tVO.getTransactionType().charAt(0));
        t.setAmount(Double.parseDouble(tVO.getAmount()));
        t.setAccount(accountService.convertAccountVOToAccount(tVO.getAccountVO()));
        return t;
    }

}
