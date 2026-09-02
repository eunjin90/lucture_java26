package account;

import java.util.List;

public class AccountService {
	
	public static int noSeq = 111111;
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public boolean createAccount(String memberId, String password, int amount) {
		while (accountDao.selectByNo(noSeq) != null) {
	        noSeq++;
	    }
		Account ac = new Account(noSeq++, memberId, password, amount);
		return accountDao.insertAccount(ac);
	}
	
	public List<Account> getAllAccounts() {
		return accountDao.selectAll();
	}
	
	public List<Account> getAccountsByMemberId(String memberId) {
		return accountDao.selectByMemberId(memberId);
	}
	
	public List<Account> getMembersAccounts() {
		return null;
	}
	
	public boolean deposit(int accountNo, int amount) throws NoAccountException {
		
		Account ac = accountDao.selectByNo(accountNo);
		if (ac != null) {
			// 입금처리
			ac.setBalance(ac.getBalance() + amount);
			accountDao.updateAccount(ac);
			return true;
		}
		
		// 없는 계좌번호임 -> 예외 객체 생성하여 던짐
		throw new NoAccountException(accountNo);
	}
	
	public boolean withdraw(int accountNo, int amount, String password) throws NoAccountException {
		Account ac = accountDao.selectByNo(accountNo); // 계좌 찾기
		if (ac != null) {
			// 비밀번호 확인
			if (password.equals(ac.getPassword())) {
				// 잔액확인
				if (amount <= ac.getBalance()) {
					// 출금처리
					ac.setBalance(ac.getBalance() - amount);
					accountDao.updateAccount(ac);
					return true;
				}
			}
			return false;
		}
		
		// 없는 계좌번호임 -> 예외 객체 생성하여 던짐
		throw new NoAccountException(accountNo);
	}
	
	public boolean deleteAccount(int accountNo, String password) {
		Account ac = accountDao.selectByNo(accountNo);
		if (ac != null && ac.getPassword().equals(password)) {
			if (ac.getBalance() == 0) { // 잔액이 0일 때만 해지 가능하도록 방어 로직 추가
				return accountDao.deleteAccount(accountNo);
			}
		}
		return false;
	}
	
	public void deleteAccountsByMemberId(String memberId) {
		List<Account> list = accountDao.selectByMemberId(memberId);
		for (Account ac : list) {
			accountDao.deleteAccount(ac.getNo());
		}
	}
}