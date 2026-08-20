package Task;

import java.util.Scanner;

public class Stra03 {

	public static void main(String[] args) {
		
		/**
		 * Star03
		 */
		
		System.out.print("숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

	}

}
