package app;

import java.util.Scanner;

import account.AccountListDao;
import account.AccountService;
import account.NoAccountException;
import member.Member;
import member.MemberMapDao;
import member.MemberService;

public class ConsoleBank {
	Scanner sc = new Scanner(System.in);
	AccountService as;
	MemberService ms;
	String[] startMenu = {"종료", "로그인", "회원가입"};
	String[] adminMenu = {"로그아웃", "회원관리", "계좌관리"};
	String[] bankingMenu = {"로그아웃", "계좌목록", "입금", "출금", "계좌생성", "계좌해지", "내정보"};
	String[] myinfoMenu = {"돌아가기", "비밀번호수정", "회원탈퇴"};
	String[] adminMemberMenu = {"돌아가기", "회원목록", "회원강퇴"};
	String[] adminAccountMenu = {"돌아가기", "전체계좌목록", "회원별계좌목록"};

	public ConsoleBank(AccountService as, MemberService ms) {
		this.as = as;
		this.ms = ms;
	}

	public static void main(String[] args) throws NoAccountException {
		// 첨부한 image_270ad6.png 패키지 구조에 맞춰 소문자 패키지 및 MemberMapDao로 수정
		AccountService as = new AccountService(new AccountListDao());
		MemberService ms = new MemberService(new MemberMapDao());
		ConsoleBank consoleBank = new ConsoleBank(as, ms);
		consoleBank.welcomeMessage();
		consoleBank.runStartMenu();
		consoleBank.sayGoodbye();
	}

	private void welcomeMessage() {
		System.out.println("+------------------------------------+");
		System.out.println("  Welcome to EunJin's Console Bank ");
		System.out.println("+------------------------------------+");
	}

	private void sayGoodbye() {
		System.out.println(">> EunJin's Console Bank를 이용해 주셔서 감사합니다.");
	}

	private void runStartMenu() throws NoAccountException {
		while (true) {
			System.out.println("[[ 시작 메뉴 ]]");
			int menu = selectMenu(startMenu);
			switch (menu) {
			case 1:
				menuLogin(); break;
			case 2:
				menuJoin(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
	}

	private int selectMenu(String[] menuList) {
		System.out.println("==========================");
		for (int i = 1; i < menuList.length; i++)
			System.out.println(" " + i + ". " + menuList[i]);
		System.out.println(" 0. " + menuList[0]);
		System.out.println("==========================");
		System.out.print(">> 선택 : ");
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private void menuLogin() throws NoAccountException {
		System.out.println("[[ 로그인 ]]");
		System.out.print(">> 아이디 : ");
		String id = sc.nextLine();
		System.out.print(">> 비밀번호 : ");
		String password = sc.nextLine();
		
		if (ms.login(id, password)) {
			Member m = ms.getLoginMember();
			if (m.getId().equals(ms.getADMIN_ID()))
				runAdminMenu();
			else {
				runBankingMenu();
			}
		} else {
			System.out.println(">> 로그인 할 수 없습니다.");
		}
	}

	private void menuJoin() {
		System.out.println("[[ 회원가입 ]]");
		System.out.print(">> 아이디 : ");
		String id = sc.nextLine();
		System.out.print(">> 비밀번호 : ");
		String password = sc.nextLine();
		System.out.print(">> 이름 : ");
		String name = sc.nextLine();
		
		if (ms.registerMember(id, password, name)) {
			System.out.println(">> 회원가입 성공");
		} else {
			System.out.println(">> 회원가입 실패 (중복된 아이디)");
		}
	}

	private void runAdminMenu() {
		while (true) {
			System.out.println("[[ 관리자 메뉴 ]]");
			int menu = selectMenu(adminMenu);
			switch (menu) {
			case 1: 
				runAdminMemberMenu(); break;
			case 2: 
				runAdminAccountMenu(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
	}

	private void runAdminMemberMenu() {
		while (true) {
			System.out.println("[[ 관리자용 회원관리 ]]");
			int menu = selectMenu(adminMemberMenu);
			switch (menu) {
			case 1: 
				menuAdminListMembers(); break;
			case 2: 
				menuAdminDeleteMember(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
	}

	private void menuAdminListMembers() {
		System.out.println("[[ 회원 목록 ]]");
		for (Member m : ms.getMembers()) {
			System.out.println(m.toString());
		}
	}

	private void menuAdminDeleteMember() {
		System.out.println("[[ 회원 강퇴 ]]");
		System.out.print(">> 강퇴할 아이디 : ");
		String id = sc.nextLine();
		
		if (ms.deleteMember(id)) {
			as.deleteAccountsByMemberId(id);
			System.out.println(">> 회원 및 관련 계좌 삭제 완료");
		} else {
			System.out.println(">> 존재하지 않는 아이디");
		}
	}

	private void runAdminAccountMenu() {
		while (true) {
			System.out.println("[[ 관리자용 계좌관리 ]]");
			int menu = selectMenu(adminAccountMenu);
			switch (menu) {
			case 1: 
				menuAdminListAllAccounts(); break;
			case 2: 
				menuAdminListMemberAccounts(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
	}

	private void menuAdminListAllAccounts() {
		System.out.println("[[ 전체 계좌 목록 ]]");
		for (Object acc : as.getAllAccounts()) {
			System.out.println(acc.toString());
		}
	}

	private void menuAdminListMemberAccounts() {
		System.out.println("[[ 회원별 계좌 목록 ]]");
		System.out.print(">> 조회할 아이디 : ");
		String id = sc.nextLine();
		
		for (Object acc : as.getAccountsByMemberId(id)) {
			System.out.println(acc.toString());
		}
	}

	private void runBankingMenu() throws NoAccountException {
		while (true) {
			System.out.println("[[ 은행 메뉴 ]]");
			int menu = selectMenu(bankingMenu);
			switch (menu) {
			case 1: 
				menuListMyAccounts(); break;
			case 2: 
				menuDeposit(); break;
			case 3: 
				menuWithdraw(); break;
			case 4 : 
				menuCreateAccount(); break;
			case 5: 
				menuDeleteAccount(); break;
			case 6: 
				runMyinfoMenu(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
	}

	private void menuListMyAccounts() {
		System.out.println("[[ 내 계좌 목록 ]]");
		String myId = ms.getLoginMember().getId();
		for (Object acc : as.getAccountsByMemberId(myId)) {
			System.out.println(acc.toString());
		}
	}

	private void menuDeposit() throws NoAccountException {
		System.out.println("[[ 입금 ]]");
		System.out.print(">> 계좌번호 : ");
		int accNo;
		int amount;
		try {
			accNo = Integer.parseInt(sc.nextLine());
			System.out.print(">> 입금액 : ");
			amount = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(">> 입력 형식이 올바르지 않습니다. 숫자를 입력해주세요.");
			return;
		}
		
		try {
			if (as.deposit(accNo, amount)) {
				System.out.println(">> 입금 성공");
			}
		} catch (NoAccountException e) {
			System.out.println(">> 입금 실패: 존재하지 않는 계좌번호입니다. 계좌번호를 다시 확인해주세요.");
		} catch (Exception e) {
			System.out.println(">> 입금 실패: " + e.getMessage());
		}
	}

	private void menuWithdraw() throws NoAccountException {
		System.out.println("[[ 출금 ]]");
		System.out.print(">> 계좌번호 : ");
		int accNo;
		int amount;
		try {
			accNo = Integer.parseInt(sc.nextLine());
			System.out.print(">> 출금액 : ");
			amount = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(">> 입력 형식이 올바르지 않습니다. 숫자를 입력해주세요.");
			return;
		}
		
		System.out.print(">> 계좌 비밀번호 : ");
		String password = sc.nextLine();
		
		try {
			if (as.withdraw(accNo, amount, password)) {
				System.out.println(">> 출금 성공");
			} else {
				System.out.println(">> 출금 실패 (비밀번호 불일치 또는 잔액 부족)");
			}
		} catch (NoAccountException e) {
			System.out.println(">> 출금 실패: 존재하지 않는 계좌번호입니다. 계좌번호를 다시 확인해주세요.");
		} catch (Exception e) {
			System.out.println(">> 출금 실패: " + e.getMessage());
		}
	}

	private void menuCreateAccount() {
		System.out.println("[[ 계좌 생성 ]]");
	    System.out.print(">> 계좌 비밀번호 : ");
	    String password = sc.nextLine();
	    System.out.print(">> 초기 입금액 : ");
	    int amount;
	    try {
	        amount = Integer.parseInt(sc.nextLine());
	    } catch (NumberFormatException e) {
	        System.out.println(">> 올바른 금액을 입력해주세요.");
	        return;
	    }
	    String myId = ms.getLoginMember().getId();
		
		if (as.createAccount(myId, password, amount)) {
			System.out.println(">> 계좌 생성 성공");
		} else {
			System.out.println(">> 계좌 생성 실패");
		}
	}

	private void menuDeleteAccount() {
		System.out.println("[[ 계좌 해지 ]]");
		System.out.print(">> 계좌번호 : ");
		int accNo;
		try {
			accNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(">> 올바른 계좌번호를 입력해주세요.");
			return;
		}
		System.out.print(">> 계좌 비밀번호 : ");
		String password = sc.nextLine();
		
		if (as.deleteAccount(accNo, password)) {
			System.out.println(">> 계좌 해지 성공");
		} else {
			System.out.println(">> 계좌 해지 실패 (권한 없음, 비밀번호 불일치 또는 잔액 존재)");
		}
	}

	private void runMyinfoMenu() {
		while (true) {
			System.out.println("[[ 내 정보 메뉴 ]]");
			int menu = selectMenu(myinfoMenu);
			switch (menu) {
			case 1: 
				menuUpdatePassword(); break;
			case 2: 
				menuDeleteMembership(); break;
			case 0:
				return;
			default:
				System.out.println("메뉴에 있는 번호를 입력하세요.");
			}
		}
	}

	private void menuUpdatePassword() {
		System.out.println("[[ 비밀번호 수정 ]]");
		System.out.print(">> 현재 비밀번호 : ");
		String oldPw = sc.nextLine();
		System.out.print(">> 새 비밀번호 : ");
		String newPw = sc.nextLine();
		String myId = ms.getLoginMember().getId();
		
		if (ms.updatePassword(myId, oldPw, newPw)) {
			System.out.println(">> 비밀번호 변경 성공");
		} else {
			System.out.println(">> 비밀번호 변경 실패");
		}
	}

	private void menuDeleteMembership() {
		System.out.println("[[ 회원 탈퇴 ]]");
		System.out.print(">> 비밀번호 확인 : ");
		String pw = sc.nextLine();
		String myId = ms.getLoginMember().getId();
		
		if (ms.deleteMember(myId, pw)) {
			as.deleteAccountsByMemberId(myId);
			System.out.println(">> 회원 탈퇴 성공");
			ms.logout();
		} else {
			System.out.println(">> 탈퇴 실패 (비밀번호 불일치)");
		}
	}
}