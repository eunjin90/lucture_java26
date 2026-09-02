package exception;

public class TryCatchTest {

	public static void main(String[] args) {
		System.out.println(">>>> 프로그램 시작");
		
		String[] array = {"100", "2OO", "300"};
		
		
		for (int i = 0; i <= array.length; i++) {
			try {			
				int value = Integer.parseInt(array[i]);
				System.out.printf("array[%d]의 값은 %d입니다.\n", i, value);
			} catch (NumberFormatException e) {
				System.out.println("숫자로 바꿀 수 없는 문자열입니다.");
//			} catch (ArrayIndexOutOfBoundsException e) {
//				System.out.println("인덱스가 범위를 벗어났습니다.");
			} catch (Exception e) {
//				System.out.println(e.getMessage());
				System.out.println(e.toString());
//				e.printStackTrace();
			}
			System.out.println(">>>> 프로그램 종료");
		}
		
	}
}
