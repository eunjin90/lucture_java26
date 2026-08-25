package tesk.countableAbstractclass;

public abstract class Animal {
    String name;
    int num;

    public Animal(String name, int num) {
        this.name = name;
        this.num = num;
    }

    // 추상 메서드 (자식 클래스가 필수로 구현해야 함)
    public abstract void count();
}
