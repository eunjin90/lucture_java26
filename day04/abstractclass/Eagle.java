package abstractclass;

public class Eagle extends Animal {

	public Eagle(String meal) {
		this.meal = meal;
//		super(meal); // 부모생성자를 직접 가져다쓰기
	}

	@Override
	public void move() {
		System.out.println("날아다닌다.");
		
	}

	
}
