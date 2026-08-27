package homework.circle;

//CircleTemplate을 상속받아 원기둥을 표현하는 클래스
public class Cylinder extends CircleTemplate {
    private double height;	// 원기둥의 높이 필드

    // 생성자: 부모의 생성자로 반지름을 초기화하고, 높이를 설정
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    // 원기둥의 겉넓이 계산 공식 적용 (밑면*2 + 옆면)
    @Override
    public double getArea() {
        return (2 * PI * radius * radius) + (2 * PI * radius * height);
    }
}