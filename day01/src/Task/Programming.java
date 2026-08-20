package Task;

public class Programming {
	public static void main(String[] args) {
		
		/**
		 * [실습] 프로그래밍 연습
		 */
		
		//---------------------------------------
		/* 직사각형의 가로와 세로를 키보드로 하나씩 입력받아 넓이를 구하는 프로그램 */
		double w = 2.2;
		double h = 10.0;
		double a1 = w * h;
		System.out.println("직사각형의 가로 길이 : " + w);
		System.out.println("직사각형의 세로 길이 : " + h);
		System.out.println("직사각형의 넓이는 : "+ a1 +" 입니다.");
		System.out.println();
		
		//---------------------------------------
		/* 입력된 정수가 짝수인지 홀수인지를 조건 연산자를 사용하여 출력 */
		int number = 2;
		String result = number % 2 == 0 ? "짝수" : "홀수";
		
		System.out.println("정수를 입력하세요 : " + number);
		System.out.println(result);
		System.out.println();
		
		//---------------------------------------
		/* 원의 반지름을 입력 받아 원의 넓이를 구하여 출력 */
		final double PI = 3.14;
		double r = 5.0;
		
		double a2 = r * r * PI;
		
		System.out.println("원의 반지름을 입력하세요(cm):" + r);
		System.out.println("원의 넓이는 :" + a2 + "0 입니다.");
		System.out.println();
		
		//---------------------------------------
		/* 주어진 금액을 500원짜리 동전과 100원짜리 동전을 최소한으로 사용하여 줄 때, 500원 짜리 동전 수와 100원 짜리 동전 수 출력 */
        int money = 1400;
        
        int money500 = money / 500;
        int money100 = (money % 500) / 100;
        
        System.out.println("금액 : " + money);
        System.out.println();
        System.out.println("동전의 수 >");
        System.out.println("500원짜리 = " + money500 + "개");
        System.out.println("100원짜리 = " + money100 + "개");

	}
}
