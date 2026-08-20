package Task;

import java.util.Scanner;

public class Star02 {

	public static void main(String[] args) {
		
		/**
		 * Star02
		 */
		
		System.out.print("숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = num; i >= 1; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		

	}

}
