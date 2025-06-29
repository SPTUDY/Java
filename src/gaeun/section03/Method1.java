package gaeun.section03;

public class Method1  {
    public static void main(String[] args) {

        Student student1 = new Student();

        Student student2 = new Student();

        initStudent(student1, "학생1", 18, 90);
        initStudent(student2, "학생2", 16, 80);

        printStudent(student1); // 참조값을 매개변수로 전달
        printStudent(student2);
    }

    static void initStudent (Student student, String name, int age, int grade) {
        student.name = name;
        student.age = age;
        student.grade = grade;
    }

    static void printStudent (Student student) {
        System.out.println("이름:" + student.name + " 나이:" + student.age + " 성적:" + student.grade);
    }
}
