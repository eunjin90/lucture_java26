package Task;

import java.util.Scanner;

public class For02 {

	public static void main(String[] args) {
		
		/**
		 * [For02] 5개의 숫자를 계속 입력 받아서 모두 더한 값을 출력
		 */
		
		System.out.println("5개의 숫자를 입력하세요 : ");

		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 1; i <= 5; i++) {
			int num = sc.nextInt();
			sum += num;
		}

		System.out.println("5개의 숫자의 합은 " + sum + "입니다.");

	}

}
