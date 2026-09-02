package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberMapDao implements MemberDao {
	
	Map<String, Member> memberDB = new HashMap<>();

	@Override
	public boolean insertMember(Member m) {
		memberDB.put(m.getId(), m);
		return true;
	}

	@Override
	public List<Member> selectAll() {
		return new ArrayList<>(memberDB.values());
	}

	@Override
	public Member selectById(String id) {
		return memberDB.get(id);
	}

	@Override
	public boolean updateMember(Member m) {
			if (selectById(m.getId()) != null) {		
				memberDB.put(m.getId(), m);
		return true;
		}
		return false;
	}

	@Override
	public boolean deleteMember(String memberId) {
		Member member = selectById(memberId);
		if(member != null) {
			memberDB.remove(memberId);
			return true;
		}
		return false;
	}
}