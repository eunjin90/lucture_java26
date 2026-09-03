package member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import account.FileDB;

public class MemberFileMapDao extends MemberMapDao implements FileDB{
	
	String dbFilename;
	
	public MemberFileMapDao(String dbFilename) {
		this.dbFilename = dbFilename;
		loadDB();
	}
	
	@Override
	public boolean insertMember(Member m) {
		super.insertMember(m);
		saveDB();
		return true;
	}
	
	@Override
	public boolean updateMember(Member m) {
		super.updateMember(m);
		return saveDB();
	}

	public boolean loadDB() {
		
		// 입력 스트림 객체 생성
		try (
			BufferedReader br = new BufferedReader(new FileReader(dbFilename))
		) {
		
		// 데이터 읽어서 memberDB에 저장
			while(true) {
				String id = br.readLine();
				if (id == null) break;
				String nickname = br.readLine();
				if (nickname == null) return false;
				String password = br.readLine();
				if (password == null) return false;
				insertMember(new Member(id, nickname, password));
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean saveDB() {
		
		// 출력 스트림 객체
		try (
			PrintWriter pw = new PrintWriter(new FileWriter(dbFilename))
				
		) {
			for(Member m : memberDB.values()) {
				pw.println(m.id);
				pw.println(m.nickname);
				pw.println(m.password);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// memberDB에 있는 데이터를 텍스트 저장
		return true;
	}
}
