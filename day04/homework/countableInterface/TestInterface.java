package homework.countableInterface;

public class TestInterface {
    public static void main(String[] args) {

        Animal[] list = {
            new Bird("뻐꾸기", 5),
            new Bird("독수리", 2),
            new Tree("사과나무", 10),
            new Tree("밤나무", 7)
        };

        // 1. count() 실행
        for (Animal obj : list) {
            obj.count();
        }

        System.out.println();

        for (Animal obj : list) {
            if (obj instanceof Bird) {
                ((Bird) obj).fly();
            } else if (obj instanceof Tree) {
                ((Tree) obj).ripen();
            }
        }
    }
}
