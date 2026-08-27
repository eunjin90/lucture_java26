package homework.circle;

//Circle 클래스를 상속받아 3차원 구(Ball)를 표현하는 클래스
public class Ball extends Circle {

	public Ball(double radius) {
        super(radius);
    }

	// 구의 겉넓이 공식 (4 * PI * r^2) 구현
    @Override
    public double getArea() {
        return 4 * PI * radius * radius;
    }
}