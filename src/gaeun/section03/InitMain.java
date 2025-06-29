package gaeun.section03;

public class InitMain {
    public static void main(String[] args) {
        InitData data = new InitData();
        System.out.println("value1=" + data.value1); // 멤버 변수 초기화하지 않으면 0
        System.out.println("value2=" + data.value2);
    }
}
