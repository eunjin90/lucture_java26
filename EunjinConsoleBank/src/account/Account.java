package account;

public class Account {
	private int no;
	private String memberId;
	private String password;
	private int balance;
	
	Account(int no, String memberId, String password, int balance) {
		this.no = no;
		this.memberId = memberId;
		this.password = password;
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "[no=" + no + ", memberId=" + memberId + ", password=" + password + ", balance=" + balance + "]";
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNo() {
		return no;
	}
	public String getMemberId() {
		return memberId;
	}
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

}