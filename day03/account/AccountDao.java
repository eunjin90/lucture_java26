package account;

public interface AccountDao {
	// C : 계좌 추가
	boolean insertAccount(String owner, String password, int balance);
	
	// R : 계좌 읽기 - 계좌번호, 전체, 계좌주
	Account[] selectAll();
	Account selectByNo(int accountNo);
	Account[] selectByOwner(String owner);
	
	// U : 입금, 출금
	boolean updateBalance(int accountNo, int amount);
	boolean withdraw(int accountNo, int amount);

	boolean deleteAccount(int accountNo, String password);

	boolean deposit(int accountNo, int amount);
	
	// D : 계좌 삭제
	
	
}
