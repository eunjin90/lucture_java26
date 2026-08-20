package Task;

import java.util.Scanner;

public class For05 {

	public static void main(String[] args) {
		
		/**
		 * [For05] 양수를 입력 받아서 1부터 해당 숫자까지 더하여 출력
		 */
		
		System.out.print("양의 숫자를 입력하세요 : ");
        
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        while(num <= 0) {
            System.out.print("양의 숫자가 아닙니다. 다시 입력하세요 : ");
            num = sc.nextInt();
        }
        
        int sum = 0;
        
        for(int i = 1; i <= num; i++) {
            sum += i;
        }
        
        System.out.println("1부터 " + num + "까지의 합은 " + sum + "입니다.");

	}

}
