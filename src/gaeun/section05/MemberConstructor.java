package gaeun.section05;

public class MemberConstructor  {
    String name;
    int age;
    int grade;

    MemberConstructor(String name, int age) {
        this(name, age, 50);
    }

    MemberConstructor(String name, int age, int grade) {
        System.out.println("생성자 호출 name=" + name + " ,age=" + age + " ,grade=" + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
