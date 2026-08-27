package homework.circle;

//CircleTemplate을 상속받아 2차원 평면의 원을 표현하는 클래스
public class Circle extends CircleTemplate{

    public Circle(double radius) {
        super(radius);
    }

    // 원의 면적 공식 (PI * r^2) 구현
    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}