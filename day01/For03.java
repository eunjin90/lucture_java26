package Task;

import java.util.Scanner;

public class For03 {

	public static void main(String[] args) {
		
		/**
		 * [For03] 입력 받은 숫자에 해당하는 구구단 출력
		 */
		
		System.out.print("숫자를 입력하세요 : ");

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println("[ 구구단 " + num + "단 ]");
		
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(num + " x " + i + " = " + (i*num));
		}

	}

}
