package hyerim.section10.super2;

public class ClassB extends ClassA {

    public ClassB(int a) {
        this(a, 100); //생략 가능
        System.out.println("ClassB 생성자, a = " + a);
    }

    public ClassB(int a, int b) {
        super(); //생략 가능
        System.out.println("ClassB 생성자, a = " + a + ", b = " + b);
    }
}
