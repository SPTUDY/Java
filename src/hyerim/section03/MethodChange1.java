package hyerim.section03;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;

        System.out.println("메서드 호출 전: " + a);
        changePrimitive(a);
        System.out.println("메서드 호출 후: " + a);
    }

    static void changePrimitive(int x) {
        x = 20;
    }
}
