package Task;

import java.util.Scanner;

public class For06 {

	public static void main(String[] args) {
		
		/**
		 * [For06] 2단부터 9단까지의 구구단을 모두 출력
		 */
		
		for(int g = 2; g <= 9; g++) {
			
			System.out.println("[ 구구단 " + g + "단 ]");
			for(int i = 1; i <= 9; i++) {
				System.out.println(g + " x " + i + " = " + (i*g));
			}
			System.out.println();
		}

	}

}
