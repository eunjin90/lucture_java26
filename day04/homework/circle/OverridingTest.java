package homework.circle;

public class OverridingTest {
    public static void main(String[] args) {
    	// Circle 객체 생성 및 출력
        Circle circle = new Circle(5.0);
        System.out.println(">>> 원 : ");
        System.out.println("반지름 : " + circle.getRadius());
        System.out.println("면적 : " + circle.getArea());

        // Ball 객체 생성 및 출력
        Ball ball = new Ball(5.0);
        System.out.println("\n>>> 공 : ");
        System.out.println("반지름 : " + ball.getRadius());
        System.out.println("면적 : " + ball.getArea());

        // Cylinder 객체 생성 및 출력
        Cylinder cyl = new Cylinder(5.0, 7.0);
        System.out.println("\n>>> 원기둥 : ");
        System.out.println("반지름 : " + cyl.getRadius());
        System.out.println("높이 : " + cyl.getHeight());
        System.out.println("면적 : " + cyl.getArea());
    }
}