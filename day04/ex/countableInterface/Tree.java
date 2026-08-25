package ex.countableInterface;

public class Tree implements Animal {
    String name;
    int num;

    public Tree(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public void count() {
        System.out.println(name + "가 " + num + "그루 있다.");
    }

    public void ripen() {
        System.out.println(num + "그루 " + name + "에 열매가 잘 익었다.");
    }
}