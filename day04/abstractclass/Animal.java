package abstractclass;

public abstract class Animal {
	String meal;
	
	abstract public void move();
	
	public void eat() {
		System.out.println("먹이로 " + meal + "을(를) 먹는다.");
		
	}
	
	public void sleep() {
		System.out.println("누워서 잠을 잔다.");
	}
}
