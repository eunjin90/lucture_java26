package app;

import java.util.List;
import java.util.Scanner;

import account.Account;
import account.AccountListDao;
import account.AccountService;
import member.MemberFileMapDao;
import member.MemberService;

public class EunJinConsoleBank01 {
	
	static String[] startMenu = {"0.종료", "1.계좌등록", "2.계좌조회", "3.입금", "4.출금"};
	static Scanner sc = new Scanner(System.in);
	static AccountService aservice = new AccountService(new AccountListDao());
	static MemberService mservice = new MemberService(new MemberFileMapDao());
	
	public static void main(String[] args) {
		welcomeMessage();
		startBankMenu();
		sayGoodbye();
	}

	private static void startBankMenu() {

		while (true) {
			int menu;
			try {
				menu = getMenu(startMenu);
			} catch (Exception e) {
				menu = -1;
			}
			switch (menu) {
			case 1: //계좌등록
				menuAccountRegist();
				break;
			case 2: //계좌조회
				menuAccountList();
				break;
			case 3: // 입금
				menuDeposit();
				break;
			case 4: // 출금
				menuWidthdraw();
				break;
			case 0: // 종료
				return;
			default: // 없는 메뉴
				System.out.println("없는 메뉴입니다.");
			}
		}
		
	}
	
	private static void menuAccountRegist() {
		// 계좌 등록 : 계좌주 이름, 비밀번호, 초기입금액
		System.out.println("[계좌 등록]");
		System.out.print("계좌주 : ");
		String owner = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("초기입금액 : ");
		
		int amount = Integer.parseInt(sc.nextLine());
		
		if (aservice.createAccount(owner, password, amount)) {
			System.out.println("계좌를 등록했습니다.");
		} else {
			System.out.println("계좌를 등록할 수 없습니다.");
		}
		
	}

	private static void menuAccountList() {
		System.out.println("[계좌 조회]");
		showAccountList(aservice.getAllAccounts());
	}
	
	private static void showAccountList(List<Account> accountList) {
		for (Account ac : accountList) {
			System.out.println(ac);
		}
	}

	private static void menuDeposit() {
		System.out.println("[입금]");
		showAccountList(aservice.getAllAccounts());
		// 계좌번호, 입금액 입력
		System.out.print("계좌번호 : ");
		int accountNo = sc.nextInt();
		System.out.print("입금액 : ");
		int amount = sc.nextInt();
		sc.nextLine();
		
		// service에게 입금 요청
		try {
			aservice.deposit(accountNo, amount);
			System.out.println("입금하였습니다.");
		} catch (Exception e) {
			System.out.println("입금할 수 없습니다 : " + e.getMessage());
		}
	}

	private static void menuWidthdraw() {
		System.out.println("[출금]");
		showAccountList(aservice.getAllAccounts());
		System.out.print("계좌번호 : ");
		int accountNo = Integer.parseInt(sc.nextLine());
		System.out.print("출금액 : ");
		int amount = Integer.parseInt(sc.nextLine());
		System.out.print("계좌비밀번호 : ");
		String password = sc.nextLine();
		try {
			aservice.withdraw(accountNo, amount, password);
			System.out.println("출금하였습니다.");
		} catch (Exception e) {
			System.out.println("출금을 할 수 없습니다. : " + e.getMessage());
		}
		
	}

	private static int getMenu(String[] menuList) throws Exception {
		// 메뉴 출력
		System.out.println("============================");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(menuList[i]);
		}
		System.out.println(menuList[0]);
		System.out.println("============================");
		System.out.print(">> 메뉴 선택 : ");	
		// 메뉴 선택
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
		
//		
//		try {
//			int menu = Integer.parseInt(sc.nextLine());
//			return menu;
//		} catch (Exception e) {
//			return -1;
//		}
	}

	private static void welcomeMessage() {
		System.out.println("EunJin Console Bank에 오신 것을 환영합니다.");
	}
	
	private static void sayGoodbye() {
		System.out.println("EunJin Console Bank를 이용해 주셔서 감사합니다.");
		
	}


}