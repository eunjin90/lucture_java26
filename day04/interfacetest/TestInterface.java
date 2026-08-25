package interfacetest;

public class TestInterface {

	public static void main(String[] args) {
		System.out.println(">>>>> 말");
		printDayLife(new Horse("당근"));

	}
	
	static void printDayLife(Animal a) {
		a.eat();
		a.move();
		a.sleep();
	}

}
