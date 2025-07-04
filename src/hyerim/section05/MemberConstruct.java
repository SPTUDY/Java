package hyerim.section05;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age) {
        this(name, age, 50);
        System.out.println("생성자 호출 - name, age");
        System.out.println("name: " + name + " | age: " + age);
    }

    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 - name, age, grade");
        System.out.println("name: " + name + " | age: " + age + " | grade: " + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
