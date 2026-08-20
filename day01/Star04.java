package Task;

import java.util.Scanner;

public class Star04 {

	public static void main(String[] args) {
		
		/**
		 * Star04
		 */
		
		System.out.print("숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < num - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

	}

}
