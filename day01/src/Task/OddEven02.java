package Task;

public class OddEven02 {

	public static void main(String[] args) {
		
		/**
		 * 중첩 조건문 연습
		 */
		
        int num = 15; // -10
        
        System.out.println("숫자를 입력하세요 : " + num);
        
        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println("짝수입니다.");
            } else {
                System.out.println("홀수입니다.");
            }
        } else {
            System.out.println("양수가 아닙니다.");
        }
        System.out.println();

	}

}
