package Task;

import java.util.Scanner;

public class DoWhile01 {

	public static void main(String[] args) {
		
		/**
		 * [DoWhile01] 숫자를 계속 입력 받으면서 더하다가 0을 입력하면 멈추고 지금까지 더한 값을 출력
		 */
		
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.print("숫자를 입력하세요: ");
			num = sc.nextInt();
			sum += num;
		}while(num != 0);
		
		System.out.println("지금까지 입력한 숫자의 합은 "+ sum + "입니다.");

	}

}
