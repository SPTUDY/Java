package hyerim.section08.static2;

public class DecoData {

    private int instanceValue;
    private static int staticValue;

    public static void staticCall() {
        //instanceValue++;  //인스턴스 변수 접근 불가능, 컴파일 에러
        //instanceMethod(); //인스턴스 메서드 접근 불가능, 컴파일 에러
        staticValue++;      //정적 변수 접근 가능
        staticMethod();     //정적 변수 접근 가능
    }

    public void instanceCall() {
        instanceValue++;
        instanceMethod();
        staticValue++;
        staticMethod();
    }

    public void instanceMethod() {
        System.out.println("instanceValue in instanceMethod = " + instanceValue);
        System.out.println("staticValue in instanceMethod = " + staticValue);

    }

    public static void staticMethod() {
        //인스턴스 변수 접근 불가능
        //System.out.println("instanceValue in staticMethod = " + instanceValue);
        System.out.println("staticValue in staticMethod = " + staticValue);
    }
}
