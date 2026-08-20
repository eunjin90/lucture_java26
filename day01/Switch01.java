package Task;

import java.util.Scanner;

public class Switch01 {

	public static void main(String[] args) {
		
		/**
		 * [Switch01] 숫자를 입력 받아 짝수인지 홀수인지 출력
		 */

		System.out.print("숫자를 입력하세요 : ");

		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		
		switch (number % 2) {
			case 0:
				System.out.println("짝수입니다.");
				break;
			default:
				System.out.println("홀수입니다.");
		}
	}

}
