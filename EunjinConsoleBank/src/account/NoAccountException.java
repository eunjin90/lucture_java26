package account;

public class NoAccountException extends Exception {
	public NoAccountException() {
		
	}
	
	public NoAccountException(int accountNo) {
		super("없는 계좌 번호 (" + accountNo + ")");
	}
}
