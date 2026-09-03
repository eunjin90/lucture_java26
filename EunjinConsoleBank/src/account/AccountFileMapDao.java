package account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AccountFileMapDao extends AccountMapDao implements FileDB {
	
	String dbFilename;
	
	public AccountFileMapDao(String dbFilename) {
		this.dbFilename = dbFilename;
		loadDB();
	}
	
	@Override
	public boolean insertAccount(Account ac) {
		super.insertAccount(ac);
		saveDB();
		return true;
	}
	
	@Override
	public boolean updateAccount(Account ac) {
		super.updateAccount(ac);
		return saveDB();
	}

	@Override
	public boolean loadDB() {
		
		// 입력 스트림 객체 생성
		try (
			BufferedReader br = new BufferedReader(new FileReader(dbFilename))
		) {
		
		// 데이터 읽어서 accountDB에 저장
			while(true) {
				String noStr = br.readLine();
				if (noStr == null) break;
				String memberId = br.readLine();
				if (memberId == null) return false;
				String password = br.readLine();
				if (password == null) return false;
				String balanceStr = br.readLine();
				if (balanceStr == null) return false;
				
				// 문자열로 읽어온 no와 balance를 int로 변환해서 객체 생성
				insertAccount(new Account(Integer.parseInt(noStr), memberId, password, Integer.parseInt(balanceStr)));
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	@Override
	public boolean saveDB() {
		
		// 출력 스트림 객체
		try (
			PrintWriter pw = new PrintWriter(new FileWriter(dbFilename))
				
		) {
			for(Account ac : accountDB.values()) {
				pw.println(ac.getNo());
				pw.println(ac.getMemberId());
				pw.println(ac.getPassword());
				pw.println(ac.getBalance());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// accountDB에 있는 데이터를 텍스트 저장
		return true;
	}
}