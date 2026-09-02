package account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMapDao implements AccountDao {
	
	Map<Integer, Account> accountDB = new HashMap<>();

	@Override
	public boolean insertAccount(Account ac) {
		accountDB.put(ac.getNo(), ac);
		return true;
	}

	@Override
	public List<Account> selectAll() {
		return new ArrayList<>(accountDB.values());
	}

	@Override
	public Account selectByNo(int accountNo) {
		return accountDB.get(accountNo);
	}

	@Override
	public List<Account> selectByMemberId(String memberId) {
		List<Account> list = new ArrayList<>();
		for (Account ac : accountDB.values()) {
			if (ac.getMemberId().equals(memberId)) {
				list.add(ac);
			}
		}
		return list;
	}

	@Override
	public boolean updateAccount(Account ac) {
		if (accountDB.containsKey(ac.getNo())) {
			accountDB.put(ac.getNo(), ac);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAccount(int accountNo) {
		if (accountDB.containsKey(accountNo)) {
			accountDB.remove(accountNo);
			return true;
		}
		return false;
	}

}