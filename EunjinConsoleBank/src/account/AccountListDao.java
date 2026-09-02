package account;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountListDao implements AccountDao {

	private List<Account> accountDB = new ArrayList<Account>();
	
	@Override
	public boolean insertAccount(Account ac) {
		accountDB.add(ac);
		return true;
	}

	@Override
	public List<Account> selectAll() {
		List<Account> accountList = new ArrayList<Account>();
		
//		for (int i = 0; i < accountDB.size(); i++)
//			accountList.add(accountDB.get(i));;
		
//		Iterator<Account> iter = accountDB.iterator();
//		while (iter.hasNext()) {
//			accountList.add(iter.next());
//		}
		
		for (Account ac : accountDB) {
			accountList.add(ac);
		}
		return accountList;
	}

	@Override
	public Account selectByNo(int accountNo) {
		for (Account ac: accountDB) {
			if (ac.getNo() == accountNo)
				return ac;
		}
		return null;
	}

	@Override
	public List<Account> selectByMemberId(String memberId) {
		List<Account> accountList = new ArrayList<Account>();
		for (Account ac : accountDB) {
			if (ac.getMemberId().equals(memberId))
				accountList.add(ac);
		}
		return accountList;
	}

	@Override
	public boolean updateAccount(Account ac) {
		Account orgAccount = selectByNo(ac.getNo());
		if (orgAccount != null) {
			accountDB.set(accountDB.indexOf(orgAccount), ac);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAccount(int accountNo) {
		Account ac = selectByNo(accountNo);
		if (ac != null) {
			accountDB.remove(ac);
			return true;
		}
		return false;
	}

}