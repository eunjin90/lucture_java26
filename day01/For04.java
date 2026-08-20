package Task;

import java.util.Scanner;

public class For04 {

	public static void main(String[] args) {
		
		/**
		 * [For04] 입력받은 숫자의 팩토리얼 값을 출력
		 */
		
		System.out.print("숫자를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);		
		int num = sc.nextInt();
		
		int result = 1;
		
		for(int i = 1; i <= num; i++) {
			result *= i;
		}
		
		System.out.println(num + "! = " + result);

	}

}
