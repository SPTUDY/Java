package gaeun.section11.basic;

// 다운캐스팅을 자동으로 하지 않는 이유
public class CastingMain4 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod(); // 문제없음 (원래 Child였으므로)

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2; // 런타임 오류 - ClassCastException
        child2.parentMethod(); // 실행 불가
    }
}
