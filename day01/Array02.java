package Task;

import java.util.Scanner;


public class Array02 {

	public static void main(String[] args) {
		
		/**
		 * [Array02] 학생 수와 각 학생의 점수를 입력 받아서 배열에 저장하고, 합계와 평균을 출력
		 */
		
		System.out.println("학생 수 : ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		
		double[] gradeArr = new double[num];
		
		double sum = 0.0;
		
		System.out.println(num + "명의 성적 : ");
		
		// 1. 반복문을 돌며 각 학생의 점수를 입력받아 배열에 저장하고 합계 구하기
        for (int i = 0; i < num; i++) {
            gradeArr[i] = sc.nextDouble(); // 점수 입력받아 배열에 저장
            sum += gradeArr[i];             // 합계에 누적
        }
        
        // 2. 평균 구하기
        double avg = sum / num;
        
        // 3. 합계와 평균 출력 (출력 형태는 문제 예시 참고)
        System.out.println(">> 합계 : " + (int)sum); // 정수형태 출력이면 형변환 또는 그대로 출력
        System.out.println(">> 평균 : " + (int)avg);
		

	}

}
