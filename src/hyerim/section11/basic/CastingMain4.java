package hyerim.section11.basic;

public class CastingMain4 {

    public static void main(String[] args) {

        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod();

        Parent parent2 = new Parent();
        //ClassCastException, 런타임 오류
        //Child child2 = (Child) parent2;
        //child2.childMethod();
    }
}
