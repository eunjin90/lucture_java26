package member;

import java.util.List;

public interface MemberDao {

	boolean insertMember (Member m);
	List<Member> selectAll();
	Member selectById(String id);
	boolean updateMember(Member m);
	boolean deleteMember(String memberId);
}
