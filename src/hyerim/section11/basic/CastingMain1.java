package hyerim.section11.basic;

public class CastingMain1 {

    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조
        Parent poly = new Child();
        //단 자식의 기능은 호출할 수 없음
        //poly.childMethod(); //컴파일 오류

        //다운 캐스팅(부모 타입 → 자식 타입)
        //Parent를 Child에 담을 수 없음, 컴파일 오류
        //Child child = poly;
        //강제로 타입 변경 가능, (괄호)를 이용
        Child child = (Child) poly;
        child.childMethod();
    }
}
