package day02;

import java.util.Scanner;

public class Gugudan {
	
	void gugudan(int num) {
		
		
		for(int i = 1; i <=9; i++) {
			System.out.println(num + "x" + i + " = " + (num*i));
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.print("단 입력 : ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		Gugudan g = new Gugudan();
		System.out.println();
		System.out.println("--- " + num + "단 ---");
		System.out.println();
		g.gugudan(num);
		System.out.println();
		
	}
}
