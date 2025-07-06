# Section05. 생성자

## this

- this는 인스턴스 자신을 가리킨다.
- 매개변수의 이름과 맴버 변수의 이름이 같은 경우 `this` 를 사용해서 둘을 명확하게 구분해야 한다.
- this는 생략 가능하다.
    - 지역변수(매개변수)에서 같은 이름이 있는지 찾고 없으면 멤버 변수에 찾으므로, 지역변수(매개변수)와 멤버 변수 이름이 같지 않으면 this로 구분할 필요가 없다.
    - IDE가 멤버변수와 지역변수를 구분해주므로 필요한 경우에만 사용해도 충분하다.

```java
package gaeun.section05;

public class MemberInit {
    String name;
    int age;
    int grade;

    void initMember(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

```

## 생성자

프로그래밍을 하다보면 객체를 생성하고 이후에 바로 초기값을 할당해야 하는 경우가 많다. 생성자를 사용하면 객체를 생성하는 시점에 즉시 필요한 기능을 수행할 수 있다.


```java
package gaeun.section05;

public class MemberConstructor  {
    String name;
    int age;
    int grade;

    MemberConstructor(String name, int age, int grade) {
        System.out.println("생성자 호출 name=" + name + " ,age=" + age + " ,grade=" + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

```

- `MemberConstructor(String name, int age, int grade){}`이 부분이 생성자다.
- 생성자의 이름은 클래스 이름과 같아야 한다. 따라서 첫 글자도 대문자로 시작한다.
- 생성자는 반환 타입이 없다.
- 생성자는 인스턴스를 생성하고 나서 즉시 호출된다.
    - 호출하는 방법

        ```java
        new 생성자이름(생성자에 맞는 인수 목록)
        new MemberConstruct("user1", 15, 90) ```
        ```

- 생성자를 사용하면 필수값 입력을 보장할 수 있다.
    - 객체를 생성할 때 직접 정의한 생성자가 있다면 **직접 정의한 생성자를 반드시 호출**해야 한다. 그렇지 않으면 컴파일 오류가 발생한다.

## 기본 생성자

- 매개변수가 없는 생성자이다.
- 생성자는 반드시 호출되어야 하므로, 클래스에 생성자가 하나도 없으면 자바 컴파일러는 매개변수가 없고, 작동하는 코드가 없는 기본 생성자를 자동으로 만들어준다.
    - 하나라도 있으면 기본 생성자를 만들어주지 않는다.
    - 자바가 자동으로 생성해주시는 기본 생성자는 클래스와 같은 접근 제어자를 가진다.

```java
package gaeun.section05;

public class MemberDefault {
    String name;
 // public MemberDefault() {
 // }; 자바에서 자동 생성
}

```

## 생성자 - 오버로딩과 this

```java
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

```

- 생성자도 메서드 오버라이딩 방식으로 여러 생성자를 제공할 수 있다.
- `this()`
    - 생성자 내부에서 자신의 생성자를 호출한다.
    - 생성자들의 코드가 중복되는 경우 유용하게 쓰인다.
    - 생성자 코드의 첫줄에만 작성할 수 있다.
