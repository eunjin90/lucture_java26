package app;

import java.util.List;

import member.Member;
import member.MemberDao;
import member.MemberMapDao;
import member.MemberService;

public class MemberTest {
	public static void main(String[] args) {
		testService();
	}
	
	static void testService() {
	
		MemberService ms = new MemberService(new MemberMapDao());
		
		ms.registerMember("aaa", "aaa", "1234");
		ms.registerMember("ccc", "1234", "ccc");
		printMemberList(ms.getMembers());
		
		ms.login("aaa", "1234");
		System.out.println(ms.getLoginMember());
	}
	
	static void testDao() {
		
		MemberDao mdao = new MemberMapDao();
		
		// insert
		mdao.insertMember(new Member("aaa", "aaa", "1234"));
		mdao.insertMember(new Member("ccc", "ccc", "1234"));
		
		// select all
		printMemberList(mdao.selectAll());
		
		
		// select by id
		System.out.println(mdao.selectById("aaa"));
		
		// update
		Member m = new Member("aaa", "bbb", "1111");
		mdao.updateMember(m);
		System.out.println(mdao.selectById("aaa"));
		
		mdao.deleteMember("aaa");
		printMemberList(mdao.selectAll());
	}
	
	static void printMemberList(List<Member> mlist) {
		for (Member m2 : mlist)
			System.out.println(m2);
	}
}