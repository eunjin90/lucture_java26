package exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionTest {
	
	public static void main(String[] args) {
		ExceptionTest t = new ExceptionTest();
		
		System.out.println(">>>> 프로그램 시작.");
//		t.arithmeticException();
//		t.indexException();
//		t.nullPointerException();
		t.numberFormatException();
		
		System.out.println(">>>> 프로그램 종료");
		
	}

	public void arithmeticException() {
		int a = 10, b= 0;
		int c = a/b;
	}

	public void indexException() {
		int[] array = { 00, 11, 12 };
		System.out.println(array[3]);
	}

	public void nullPointerException() {
		String str = null;
		str.charAt(1);
	}

	public void numberFormatException() {
		String str = "123AA";
		int num = Integer.parseInt(str);
	}

	public void classException() {
		//Class.forName("java.lang.String");
		System.out.println("클래스가 있습니다.");
	}
	
	public void ioException() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String str = br.readLine();
	}

}
