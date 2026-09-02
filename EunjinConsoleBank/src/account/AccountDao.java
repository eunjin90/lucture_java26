package account;

import java.util.List;

public interface AccountDao {
	boolean insertAccount(Account ac);
	List<Account> selectAll();
	Account selectByNo(int accountNo);
	List<Account> selectByMemberId(String memberId);
	boolean updateAccount(Account ac);
	boolean deleteAccount(int accountNo);
}