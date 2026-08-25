package account;

public class AccountFileDao  implements AccountDao{

	@Override
	public boolean insertAccount(String owner, String password, int balance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account[] selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectByNo(int accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account[] selectByOwner(String owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBalance(int accountNo, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(int accountNo, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int accountNo, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(int accountNo, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
