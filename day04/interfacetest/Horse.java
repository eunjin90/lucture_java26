package interfacetest;

public class Horse implements Animal {

	private String meal;
	
	public Horse(String meal) {
		this.meal = meal;
	}
	
	@Override
	public void move() {
		System.out.println("뛰어다닌다.");
		
	}
	
	@Override
	public void sleep() {
		System.out.println("서서 잠을 잔다.");
	}

	@Override
	public void eat() {
		System.out.println("먹이로 " + meal + "을(를) 먹는다.");
		
	}
	
}
