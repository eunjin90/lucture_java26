package homework.circle;

//공통 필드와 메서드를 정의하는 추상 클래스
public abstract class CircleTemplate {

    public static double PI = 3.14;	// 원주율 정적 변수
    protected double radius; // 자식 클래스에서 직접 접근 가능한 반지름 필드

    // 생성자: 객체 생성 시 반지름을 초기화
    public CircleTemplate(double radius) {
        this.radius = radius;
    }

    // 반지름 값을 반환하는 Getter 메서드
    public double getRadius() {
        return radius;
    }

    // 반지름 값을 설정하는 Setter 메서드
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 자식 클래스에서 반드시 구현해야 하는 추상 메서드
    public abstract double getArea();
}
