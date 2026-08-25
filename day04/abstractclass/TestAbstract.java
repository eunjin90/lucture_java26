package abstractclass;

public class TestAbstract {

	public static void main(String[] args) {
		System.out.println(">>>>> 독수리");
		Eagle e = new Eagle("고기");
		printDayLife(e);
//		
//		System.out.println(">>>>> 호랑이");
//		Tiger t = new Tiger();
//		printDayLife(t);
//		
		System.out.println(">>>>> 금붕어");
		Goldfish g = new Goldfish("플랑크톤");
		printDayLife(g);
		
		System.out.println(">>>>> 말");
		Horse h = new Horse("당근");
		printDayLife(h);

	}
	static void printDayLife(Animal a) {
		a.eat();
		a.move();
		a.sleep();
	}

}
