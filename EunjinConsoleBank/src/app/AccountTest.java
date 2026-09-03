package app;

import java.util.List;

import account.Account;
import account.AccountDao;
import account.AccountFileMapDao;
import account.FileDB;

public class AccountTest {
	public static void main(String[] args) {
		testFileOperation();
	}
	
	static void testFileOperation() {
		String dbFilename = "accountDB.txt";
		
		AccountDao dao = new AccountFileMapDao(dbFilename);
		
//		dao.insertAccount(new Account(1001, "aaa", "1234", 10000));
//		dao.insertAccount(new Account(1002, "ccc", "1234", 50000));
		
		FileDB fdb = (FileDB)dao;
		fdb.loadDB();
		
		printAccountList(dao.selectAll());
	}
	
	static void printAccountList(List<Account> alist) {
		for (Account ac : alist)
			System.out.println(ac);
	}
}