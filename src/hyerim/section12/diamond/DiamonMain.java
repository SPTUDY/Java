package hyerim.section12.diamond;

public class DiamonMain {

    public static void main(String[] args) {
        InterfaceA a = new Child();
        a.methodA();
        a.methodCommon();

        InterfaceB b = new Child();
        b.methodB();
        b.methodCommon();

        Child c = new Child();
        c.methodA();
        c.methodB();
        c.methodCommon();
    }
}
