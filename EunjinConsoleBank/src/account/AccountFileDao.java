package account;

import java.util.List;

public class AccountFileDao  implements AccountDao{

	@Override
	public boolean insertAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectByNo(int accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> selectByOwner(String owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertAccount(String owner, String password, int balance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(Account ac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
