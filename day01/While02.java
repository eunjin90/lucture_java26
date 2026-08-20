package Task;

import java.util.Scanner;

public class While02 {

	public static void main(String[] args) {
		
		/**
		 * [While02] 숫자를 입력 받아 짝수인지 홀수인지 판단하고, 계속 할 것인지 묻는다. 0을 입력하면 멈추고, 1이면 계속 한다.
		 */

		Scanner sc = new Scanner(System.in);
		int choice = 1;
		
		while(choice == 1) {
			System.out.print("숫자를 입력하세요 : ");
			int num = sc.nextInt();
			
			if(num % 2 == 0) {
				System.out.println(">> 짝수입니다.");
			} else {
				System.out.println(">> 홀수입니다.");
			}

			while(true) {
                System.out.print("계속 하시겠습니까? (0-멈춤/1-계속) : ");
                choice = sc.nextInt();
                
                if(choice == 0 || choice == 1) {
                	System.out.println();
                    break;
                }
                System.out.println("0또는 1만 입력해라");
			}
		}
		
		System.out.println("종료");

	}

}
