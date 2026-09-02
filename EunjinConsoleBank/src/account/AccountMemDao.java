package account;

import java.util.ArrayList;
import java.util.List;

public class AccountMemDao implements AccountDao {
	public static int noSeq = 111111;
	private Account[] accountDB = new Account[100];
	private int numAccount;
	
	// 계좌등록
//	public boolean insertAccount(String owner, String password, int balance) {
//		int no = noSeq++;
//		accountDB[numAccount++] = new Account(no, owner, password, balance);
//		return true;
//	}
	
	@Override
	public boolean insertAccount(Account ac) {
		if (numAccount >= accountDB.length) {
			return false;
		}
		accountDB[numAccount++] = ac;
		return true;
	}
	
	
	// 계좌조회 (계좌 리스트를 return)
//	public Account[] selectAll() {
//		Account[] accountList = new Account[numAccount];
//		for (int i = 0; i < numAccount; i++)
//			accountList[i] = accountDB[i];
//		return accountList;
// 	}
	@Override
	public List<Account> selectAll() {
		List<Account> accountList = new ArrayList<>();
		for (int i = 0; i < numAccount; i++) {
			accountList.add(accountDB[i]);
		}
		return accountList;
 	}
	
	@Override
	public Account selectByNo(int accountNo) {
		for (int i = 0; i < numAccount; i++) {
			if (accountDB[i].getNo() == accountNo) {
				return accountDB[i];
			}
		}
		return null;
	}
	
	@Override
	public List<Account> selectByMemberId(String memberId) {
		List<Account> result = new ArrayList<>();
		for (int i = 0; i < numAccount; i++) {
			if (accountDB[i].getMemberId().equals(memberId)) {
				result.add(accountDB[i]);
			}
		}
		return result;
	}
	
	@Override
	public boolean updateAccount(Account ac) {
		for (int i = 0; i < numAccount; i++) {
			if (accountDB[i].getNo() == ac.getNo()) {
				accountDB[i] = ac;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean deleteAccount(int accountNo) {
		for (int i = 0; i < numAccount; i++) {
			if (accountDB[i].getNo() == accountNo) {
				for (int j = i; j < numAccount - 1; j++) {
					accountDB[j] = accountDB[j + 1];
				}
				accountDB[--numAccount] = null;
				return true;
			}
		}
		return false;
	}
	
	// 입금
	public boolean deposit(int accountNo, int amount) throws NoAccountException {
		for (int i = 0; i < numAccount; i++) {
			if (accountNo == accountDB[i].getNo()) {
				// 입금처리
				accountDB[i].setBalance(accountDB[i].getBalance() + amount);
				return true;
			}
		}
		
		// 없는 계좌번호임 -> 예외 객체 생성하여 던짐
		throw new NoAccountException(accountNo);
		//return false;
	}
	
	// 출급
	public boolean withdraw(int accountNo, int amount) throws NoAccountException {
		for (int i = 0; i < numAccount; i++) {
			if (accountNo == accountDB[i].getNo()) {
				// 출금
				if (amount <= accountDB[i].getBalance()) {
					accountDB[i].setBalance(accountDB[i].getBalance() - amount);
					return true;
				} else {
					return false;
				}
			}
		}
		throw new NoAccountException(accountNo);
	}

}