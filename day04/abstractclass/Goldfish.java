package abstractclass;

public class Goldfish extends Animal {
	
	
	public Goldfish(String meal) {
		this.meal = meal;
	}
	
	
	public void eat(String meal) {
		System.out.println("");
	}
	
	@Override
	public void move() {
		System.out.println("헤엄친다.");
		
	}

}
