package gaeun.section09;

public class FinalLocalMain {
    public static void main(String[] args) {
        // final 지역 변수
        final int data1;
        data1 = 10; // 최초 한 번만 할당 가능
        // data1 = 20; // 컴파일 오류

        final int data = 10;
        // data2 = 20; // 컴파일 오류

        method(10);

    }

    static void method(final int parameter) {
         // parameter = 20; 컴파일 오류
    }
}
