package Task;

public class Array01 {

	public static void main(String[] args) {
		
		/**
		 * [Array01] 배열에 들어있는 값의 합과 평균 구하기
		 */
		
		double[] gradeArr = {90, 70, 80, 79, 82, 50, 70, 90, 89, 89};
		
		double sum = 0;
		
		for (int i = 0; i <gradeArr.length; i++) {
			sum += gradeArr[i];
		}
		
		double average = sum / gradeArr.length;
		
		System.out.println(">> 합계: " + sum);
		System.out.println(">> 합계: " + average);

	}

}
