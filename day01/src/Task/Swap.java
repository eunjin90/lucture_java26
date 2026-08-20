package Task;

public class Swap {

	public static void main(String[] args) {
		
		/**
		 * [Swap] 2개의 변수에 있는 숫자를 입력 받아, swapping 한 결과 출력
		 */
		
		int a = 10;
		System.out.println("변수 a에 넣을 숫자 입력 : " + a);
		int b = 25;
		System.out.println("변수 b에 넣을 숫자 입력 : " + b);
		
		int temp = a;
		a = b;
		b = temp;
		System.out.println();
		System.out.println("Swapping 결과 >");
		System.out.println("변수 a의 값 = " + a);
		System.out.println("변수 b의 값 = " + b);
		System.out.println();

	}

}
