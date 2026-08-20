package Task;

import java.util.Scanner;

public class Switch02 {

	public static void main(String[] args) {
		
		/**
		 * [Switch02] 등급을 입력 받아서 그에 맞는 평가 문장을 출력
		 */
		

		System.out.print("등급을 입력하세요 : ");
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();
		
		switch (number) {
			case "A":
			case "B":
				System.out.println(">> 아주 열심히 하셨군요~~!!");
				break;
			case "C":
				System.out.println(">> 남들만큼 하셨네요~~~");
				break;
			case "D":
				System.out.println(">> 조금 더 노력이 필요합니다.");
				break;
			case "F":
				System.out.println(">> 교수실로 찾아오세요");
				break;
			default:
				System.out.println(">> A,B,C,D,F로 입력해라");
		}

	}

}
