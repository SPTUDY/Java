# Section 02. 클래스와 데이터

## 클래스가 필요한 이유

<aside>
💡요구사항

1. 첫 번째 학생의 이름은 "학생1", 나이는 15, 성적은 90입니다.
2. 두 번째 학생의 이름은 "학생2", 나이는 16, 성적은 80입니다.

3. 각 학생의 정보를 다음과 같은 형식으로 출력해야 합니다: `"이름: [이름] 나이: [나이] 성적: [성적]"`
4. 변수를 사용해서 학생 정보를 저장하고 변수를 사용해서 학생 정보를 출력해야 합니다.

</aside>

1. `변수`로 관리

   학생이 늘어날 때마다 변수를 추가로 선언해야 하고 출력하는 코드도 추가해야 한다.

2. `배열`로 관리

   이름, 나이, 성적을 따로 배열로 정의하여 관리하는 경우 배열 요소들의 인덱스 순서를 정확하게 맞춰야 한다.

3. `클래스`로 관리
    - 각각의 학생 별로 본인의 이름, 나이, 성적을 관리한다.

    ```java
    public class Student {
          String name;
          int age;
          int grade;
    }
    ```

    - 클래스에 정의한 변수들을 `변수` 또는 `필드`라 한다.
        - 멤버 변수 (Member Variable)
        - 필드 (Field)
            - 데이터 항목을 가리키는 전통적인 용어
        - 자바에서 멤버 변수와 필드는 동의어로 클래스에 소속되는 변수를 뜻한다.
    - 클래스를 통한 학생 관리

        ```java
        public class ClassStart3 {
          public static void main(String[] args) {
            Student student1;
            student1 = new Student();
            student1.name = "학생1";
            student1.age = 15;
            student1.grade = 90;
            Student student2 = new Student();
            student2.name = "학생2";
            student2.age = 16;
            student2.grade = 80;
            System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성적:" + student1.grade);
            System.out.println("이름:" + student2.name + " 나이:" + student2.age + "성적:" + student2.grade);
          }
        }
        ```

        - 클래스를 통해 학생(Student)이란 사용자 정의 타입을 만든 것이다.
            - `클래스`는 사용자가 직접 정의하는 사용자 타입을 만들기 위한 `설계도`이다.
            - 클래스를 사용해서 실제 메모리에 만들어진 실체를 `객체` 또는 `인스턴스`라 한다.
- 용어 정리
    - `클래스`는 설계도이다.
    - `인스턴스` 또는 `객체`는 클래스를 기반으로 실제 메모리에 만들어진 실체이다.
    - 위 코드에서 `학생 (Student) 클래스`를 기반으로 `학생1 (student1), 학생2 (student2) 객체 또는 인스턴스`를 만들었다.

---

## 클래스 코드 분석

```java
public class ClassStart3 {
  public static void main(String[] args) {
    Student student1;  // Student 타입을 받을 수 있는 변수를 선언
    student1 = new Student(); // #L4 객체 생성
    student1.name = "학생1"; // #L5~7 객체에 값 대입
    student1.age = 15;
    student1.grade = 90;
    Student student2 = new Student();
    student2.name = "학생2";
    student2.age = 16;
    student2.grade = 80;
    System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성적:" + student1.grade); // #L12 객체 값 사용
    System.out.println("이름:" + student2.name + " 나이:" + student2.age + "성적:" + student2.grade);
  }
}
```

- #L4 객체 생성
    - 객체를 사용하기 위해서는 클래스르 기반으로 객체(인스턴스)를 생성해야 한다.
    - `new Student()` : Student 클래스 정보를 기반으로 새로운 객체를 생성하라는 뜻이다.
        - 이를 통해 메모리에 실제 Student 객체(인스턴스)를 생성한다.
    - Student 클래스는 `String name`, `int age`, `int grade` 멤버 변수를 가지고 있다. 이 변수를 사용하는데 필요한 메모리 공간도 함께 확보한다.
- 참조 값 보관
    - 객체 생성시 자바는 메모리 어딘가에 있는 해당 객체에 접근할 수 있는 `참조값(주소)`을 반환한다.
    - `new` 키워드를 통해 객체가 생성되고 나면 **참조값을 반환**한다.
        - 앞서 선언한 변수인 `Student student1`에 생성된 객체의 `참조값(x001)`을 보관한다.
        - `Student student1` 변수는 이제 메모리에 존재하는 실제 Student 객체 (인스턴스)의 참조값을 가지고 있다.
            - student1 변수는 방금 만든 객체의 참조값을 가지고 있다.
            - 따라서 이 변수를 통해서 객체를 접근(참조)할 수 있다.
            - student1 변수를 통해 메모리에 있는 실제 객체를 접근하고 사용할 수 있다.
    - 참조값을 변수에 보관하는 이유
        - 생성한 객체에 접근할 방법이 필요하기 때문이다.

            ```java
            Student student1 = new Student () = x001
            // 결론 student1 = x001
            ```

    - 이후에 학생2(student2)까지 생성하면 Student 객체(인스턴스)가 메모리에 2개 생성된다.
        - 각각 참조값이 다르므로 서로 구분할 수 있다.
        - 참조값을 확인하고 싶다면 객체를 담고 있는 변수를 출력해보면 된다.

            ```java
            System.out.println(student1);
            System.out.println(student2);
             
            // class1.Student@7a81197d
            // class1.Student@2f2c9b19
            // 패키지.클래스@참조값(16진수)
            ```

- #L5~7 & L12 : 객체에 값 대입 & 사용
    - `.(dot) 키워드`
        - 객체에 접근하기 위해 사용한다.
        - `student1.name=”학생1";`
            - 변수 (`student1`)에 있는 참조값을 읽어서 메모리에 존재하는 객체에 접근한다.
            - `x001` 위치에 있는 `Student` 객체에 접근한다.
            - 해당 객체의 `name` 멤버 변수에 “학생1” 데이터를 저장한다.
    - 객체 값 읽기
        - 이 또한 `. (dot)` 을 통해 참조값을 사용해서 객체에 접근한 다음에 원하는 작업을 하면 된다.

---

## 클래스, 객체, 인스턴스 정리

- **클래스 (Class)**
    - 객체를 생서하기 위한 틀 또는 설계도이다.
    - 객체가 가져야할 속성(변수)과 기능(메서드)를 정의한다.
- **객체 (Object)**
    - 클래스에서 정의한 속성과 기능을 가진 실체이다.
        - student1은 학생 1의 속성을 가지는 객체이고, student2는 학생2의 속성을 가지는 개체로, 두 객체는 같은 클래스에서 만들어졌지만, 서로 다른 객체이다.
- **인스턴스 (Instance)**
    - 특정 클래스로부터 생성된 객체를 의미한다.
    - 주로 객체가 어떤 클래스에 속해 있는지 강조할 때 사용한다.
    - (예) student1 객체는 Student 클래스의 인스턴스다.

> **객체 vs 인스턴스**
둘 다 클래스에서 나온 실체라는 의미에서 비슷하게 사용되지만, 용어상 인스턴스는 객체보다 좀 더 관계에 초점을 맞춘 단어이다.
(예) student1은 객체지만, 이 객체가 Student 클래스로부터 생성된다는 점을 명확히 하기 위해 student1을 Student의 인스턴스라고 부른다.
>

---

## 배열 도입

배열을 사용하면 특정 타입을 연속한 데이터 구조로 묶어서 편리하게 관리할 수 있다.

```java
Student[] students = new Student[2];
students[0] = student1;
students[1] = student2;

// students[0] = x001;
// students[1] = x002;
```

- 🌟 **자바에서 대입은 항상 변수에 들어 있는 값을 복사한다.**
    - 이제 배열은 x001, x002의 참조값을 가지고 있기 때문에 Student 인스턴스에 모두 접근할 수 있다.
- **🌟 자바에서 변수의 대입( `=` )은 모두 변수에 들어있는 값을 복사해서 전달하는 것이다.**
    - 변수에는 인스턴스 자체가 들어있는 것이 아니다. 인스턴스의 위치를 가리키는 참조값이 들어있을 뿐이다. 따라서 대입 ( `=` )시에 인스턴스가 복사되는 것이 아니라 참조값만 복사된다.
- 배열에 들어가 있는 객체 사용

    ```java
    System.out.println(students[0].name);
    System.out.println(x005[0].name); //[0]를 사용해서 x005 배열의 0번 요소에 접근 
    System.out.println(x001.name); //.(dot)을 사용해서 참조값으로 객체에 접근 
    System.out.println("학생1");
    ```

- 리팩토링

    ```java
    // 배열 선언 최적화
    Student[] students = new Student[] {student1, student2};
    
    // 생성과 선언을 동시에
    Student[] students = {student1, student2};
    
    // for문 도입
    for (int i = 0; i < students.length; i++) {
    System.out.println("이름:" + students[i].name + " 나이:" + students[i].age
    + ...); }
    
    // for문 - 반복 요소를 변수에 담아서 처리하기
    for (int i = 0; i < students.length; i++) {
       Student s = students[i];
                System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
    }
    
    // 향상된 for문(Enhanced For Loop)
    for (Student s : students) { // iter 단축키
       System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
    }
    ```