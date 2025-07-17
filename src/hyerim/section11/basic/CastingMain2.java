package hyerim.section11.basic;

public class CastingMain2 {

    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조
        Parent poly = new Child();

        Child child = (Child) poly;
        child.childMethod();

        //일시적 다운캐스팅: 해당 메서드를 호출하는 순간만 다운캐스팅
        ((Child) poly).childMethod();
    }
}
