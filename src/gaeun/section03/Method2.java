package gaeun.section03;

import javax.xml.namespace.QName;

public class Method2  {
    public static void main(String[] args) {
       Student student1 = createStudent("student1", 18, 90);
       System.out.println("student1" + student1);
       Student student2 = createStudent("student2",  16, 19);
       System.out.println("student2" + student2);

        printStudent(student1); // 참조값을 매개변수로 전달
        printStudent(student2);
    }

    static Student createStudent (String name, int age, int grade ) {
        Student student = new Student();
        System.out.println("student=" + student);
        student.name = name;
        student.age = age;
        student.grade = grade;

        return student;
    }

    static void printStudent (Student student) {
        System.out.println("이름:" + student.name + " 나이:" + student.age + " 성적:" + student.grade);
    }
}
