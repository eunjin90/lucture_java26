package member;

import java.util.List;

public class MemberService {
	
	final String ADMIN_ID = "admin";
	final String ADMIN_PASSWORD = "1234";
	
	private MemberDao dao;
	private Member loginMember;
	
	public MemberService(MemberDao dao) {
		this.dao = dao;
	}
	
	public boolean registerMember(String id, String password, String nickname) {
		if (dao.selectById(id) == null) {
			
		Member member = new Member(id, nickname, password);
		dao.insertMember(member);
		return true;
		}
		return false;
	}
	
	public boolean login(String id, String password) {
		if (id.equals(ADMIN_ID)) {
			if (password.equals(ADMIN_PASSWORD)) {
				loginMember = new Member(ADMIN_ID, null, ADMIN_PASSWORD);
				return true;
			}
			return false;
		}
		Member member = dao.selectById(id);
		if(member != null && member.getPassword().equals(password)) {
			loginMember = member;
			return true;
		}
		return false;
	}
	
	public boolean logout() {
		loginMember = null;
		return true;
	}
	
///////////////////////////////////////////////////////////////////
	
	public boolean deleteMember(String id) {
		if (dao.selectById(id) != null) {
			return dao.deleteMember(id);
		}
		return false;
	}

	public boolean deleteMember(String id, String password) {
		Member member = dao.selectById(id);
		if (member != null && member.getPassword().equals(password)) {
			return dao.deleteMember(id);
		}
		return false;
	}

	public boolean updatePassword(String id, String oldPw, String newPw) {
		Member member = dao.selectById(id);
		if (member != null && member.getPassword().equals(oldPw)) {
			member.setPassword(newPw);
			return dao.updateMember(member);
		}
		return false;
	}
	
///////////////////////////////////////////////////////////////////
	
	public List<Member> getMembers() {
		return dao.selectAll();
	}

	public MemberDao getDao() {
		return dao;
	}

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	public Member getLoginMember() {
		return loginMember;
	}

	public void setLoginMember(Member loginMember) {
		this.loginMember = loginMember;
	}

	public String getADMIN_ID() {
		return ADMIN_ID;
	}

	public String getADMIN_PASSWORD() {
		return ADMIN_PASSWORD;
	}

	
}
