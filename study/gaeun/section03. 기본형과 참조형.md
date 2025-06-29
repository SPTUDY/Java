# Section03 기본형과 참조형

## 01. 변수의 데이터 타입

- **기본형 (Primitive Type)**
    - 변수에 사용할 값을 직접 넣을 수 있는 데이터 타입니다.
    - ex. `int`, `long`, `double`, `boolean`
    - 기본형 변수에는 직접 사용할 수 있는 값이 들어있다.
    - `10`, `20`은 기본형으로, 값을 변수에 담고 해당 값을 바로 사용할 수 있다.
        - cf. 참조형은 실제 사용하는 값을 변수에 담는 것이 아니다.
    - 값을 그대로 계산에 사용할 수 있다.
- **참조형 (Reference Type)**
    - 데이터에 접근하기 위한 참조(주소)를 저장하는 데이터 타입이다.
    - 객체 또는 배열에 사용된다.
        - 객체: `. (dot)` 을 통해서 메모리 상에 생성된 객체를 찾아가야 사용할 수 있다.
        - 배열: `[ ]` 를 통해서 메모리 상에 생성된 배열을 찾아가야 사용할 수 있다.
    - ex. `Student student1`,  `int[] students`
    - 참조형 변수에는 위치(참조값)가 들어있다.
        - 참조형 변수를 통해서 무언가를 하려면 결국 참조값을 통해 해당 위치로 이동해야 한다.
    - 실제 객체의 위치(참조, 주소)를 저장한다.
    - 참조값으로 계산이 불가능하다. ⇒ 참조값(주소지)에 가야 실체가 있다.
        - `.`을 통해 기본형 멤버 변수에 접근한 경우에는 연산할 수 있다.

        ```java
        
        Student s1 = new Student(); 
        Student s2 = new Student(); 
        s1 + s2 //오류 발생
        
        s1.grade = 100;
        s2.grade = 90;
        int sum = s1.grade + s2.grade; //연산 가능
        ```

- **🔎 쉽게 이해하는 팁**
    - 기본형을 제외한 나머지는 모두 참조형이다.
    - 기본형은 소문자로 시작한다.
        - `int`, `long`, `double`, `boolean`
    - 기본형은 자바가 기본으로 제공하는 데이터 타입이다.
        - 이러한 기본형은 개발자가 새로 정의할 수 없다.
    - 클래스는 대문자로 시작한다.
        - 클래스는 모두 참조형이다.
        - 개발자는 참조형인 클래스만 직접 정의할 수 있다.
- 💡`String`
    - `String`은 사실 클래스로, 참조형이다. 그런데 기본형처럼 문자 값을 바로 대입할 수 있다.
    - 문자는 매우 자주 다루기 때문에 자바에서 특별하게 편의 기능을 제공한다.
      <br/>
      <br/>
      <br/>

---

## 02. 기본형과 참조형 - 변수 대입

***🌟 자바는 항상 변수의 값을 복사해서 대입한다.***

- 기본형, 참조형 모두 항상 변수에 있는 값을 복사해서 대입한다.
    - 기본형이면 변수에 들어 있는 실제 사용하는 값을 복사해서 대입한다.
    - 참조형이면 변수에 들어 있는 참조값을 복사해서 대입한다.
- **기본형 대입**

    ```java
    int a = 10;
    int b = a; // a, b 둘 다 각각 다른 10을 갖고 있는 것이다.
    
    a = 20; // a = 20, b = 10 이다.
    ```

    - 기본형은 변수에 값을 대입하더라도 실제 사용하는 값이 변수에 바로 들어있기 때문에 해당 값만 복사해서 대입한다고 생각하면 쉽게 이해할 수 있다.
- **참조형 대입**

    ```java
    Student s1 = new Student(); // 참조값 x001
    Student s2 = s1; // s2 = x001
    ```

    - 참조형의 경우 실제 사용하는 객체가 아니라 **객체의 위치를 가리키는 참조값만 복사**된다.
        - 건물이 복사되는 것이 아니라 건물의 주소만 복사되는 것과 같다.

### 1️⃣ 기본형과 변수 대입

```java
int a = 10;
int b = a;

// a = 10, b = 10
```

- 변수의 대입은 들어있는 값을 복사해서 대입한다. 변수 a 자체를 b에 대입하는 것이 아니다.
- 변수 a에 들어있는 10이라는 값을 복사해서 변수 b에 대입한 것이다.

```java
a = 20;

// a = 20, b = 10
```

- 변수 b에 아무런 영향이 가지 않는다.

```java
b = 30
// a = 20, b= 30
```

- 변수 a도 마찬가지다.

**📌 `핵심` :**  int b = a 의 경우 변수에 들어 있는 값을 복사해서 전달한다는 점이다. 그래서 a, b에 변수에 다른 값을 대입해도 본인의 값만 변경된다.

### 2️⃣ 참조형과 변수 대입

```java
Data dataA = new Data();
dataA.value = 10;

Data dataB = dataA;
// dataA = ref.Data@x001
// dataB = ref.Data@x001
 
//dataA 변경
dataA.value = 20;
// dataB.value = 20

//dataB 변경
dataB.value = 30;
// dataA.value = 30
```

- `dataA`에 들어있는 참조값 `x001` 을 복사해서 `dataB`에 대입하는 것이다.
    - 변수 dataA가 가리키는 인스턴스를 복사하는 것이 아니다.
    - dataA와 dataB에 들어있는 참조값이 같게 되므로, 둘 다 x001 Data 인스턴스를 가리킨다.

**📌 `핵심` :**  `Data dataB = dataA` 라고 했을 때 변수에 들어있는 값을 복사해서 사용한다는 점이다. 두 변수는 같은 참조값을 가지게 되며, 같은 객체 인스턴스를 참조하게 된다.

<br/>
<br/>
<br/>

---

## 03. 기본형과 참조형 - 메서드 호출

***🌟 자바는 항상 변수의 값을 복사해서 대입한다.***

- 메서드를 호출할 때 사용하는 매개변수(파라미터)도 결국 변수일 뿐이다. 따라서 메서드를 호출할 때 매개변수에 값을 전달하는 것도 값을 복사해서 전달한다.
- 예제

    ```java
    public class MethodChange1 {
        public static void main(String[] args) {
            int a = 10;
            System.out.println("메서드 호출 전: a = " + a); 
            changePrimitive(a); 
            System.out.println("메서드 호출 후: a = " + a);
        }
        static void changePrimitive(int x) {
            x = 20;
        }
    }
    
    ```

    - 과정
        1. 메서드를 호출할 때 매개변수 x에 변수 a의 값을 전달한다. a, x는 각각 숫자 10을 갖게 된다.

            ```java
            int x = a; 
            // x = 10
            ```

        2. 메서드 안에 x = 20으로 새로운 값을 대입한다. x의 값만 20으로 변경되고, a의 값은 10으로 유지된다.

            ```java
            x = 20;
            ```

        3. 메서드 종료 후 값을 확인하면 a는 10으로 출력된다. (메서드가 종료되면 매개변수 x는 제거된다.)

### 참조형과 메서드 호출

```java
public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value);
        changeReference(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value);
    }

    static void changeReference(Data dataX) {
        dataX.value = 20;
    }
}

// 메서드 호출 전: dataA.value = 10 
// 메서드 호출 후: dataA.value = 20

```

- 과정
    1. 메서드 호출시 매개변수 `dataX`에 변수 `dataA`의 값(참조값)을 전달한다. 따라서 변수 `dataA`, `dataX`는 같은 참조값인 x001을 갖게된다.
    2. `dataA`와 `dataX` 모두 같은 x001 인스턴스를 참조하기 때문에 메서드 안에 `dataX.value = 20` 으로 새로운 값을 대입하면 `dataA.value`와 `dataX.value`는 둘 다 20이 된다.

### 기본형과 참조형의 메서드 호출

자바에서 메서드의 매개변수(파라미터) 값이 실제 값인지 참조값인지에 따라 동작이 달라진다.

- 매개변수
    - 기본형
        - 해당 값이 복사되어 전달된다. 메서드 내부에서 매개변수 값 변경해도 호출자의 변수 값에는 영향이 없다.
    - 참조형
        - 참조값이 복사되어 전달된다. 메서드 내부에서 매개변수로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다.
- 활용

    ```java
    package gaeun.section03.ref;
    
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
    ```

    ```c
    student=gaeun.section03.ref.Student@30f39991
    student1gaeun.section03.ref.Student@30f39991
    student=gaeun.section03.ref.Student@452b3a41
    student2gaeun.section03.ref.Student@452b3a41
    이름:student1 나이:18 성적:90
    이름:student2 나이:16 성적:19
    ```
<br/>
<br/>
<br/>

---

## 04. 변수와 초기화

변수의 종류로는 `멤버 변수(필드)`와 `지역 변수`가 있다.

- **멤버 변수 (필드)**
    - 클래스에 선언한다.

    ```java
    public class Student {
    	String name; // 멤버 변수
    	int age; // 멤버 변수
    	int grade; // 멤버 변수
    }
    ```

- **지역 변수**
    - 메서드에 선언한다.
    - 매개변수도 지역 변수의 한 종류이다.
        - 지역 변수는 특정 지역에서만 사용되는 변수이므로 메서드의 블록에서만 사용되는 매개 변수 또한 지역 변수이다.
    - 지역 변수는 메서드가 끝나면 제거된다.

    ```java
    public class ClassStart3 {
    	public static void main(String[] args) {
    		Student student1; // 지역 변수
    		student1 = new Student(); 
    		Student student2 = new Student(); // 지역 변수
    	}
    }
    ```


### 변수의 값 초기화

- **멤버 변수**는 자동 초기화된다.
    - 인스턴스의 멤버 변수는 인스턴스를 생성할 때 자동으로 초기화된다.
        - 숫자( `int` ) = `0`
        - `boolean` = `false`
        - 참조형 = `null`
            - `null` 값은 참조할 대상이 없다는 뜻으로 사용된다.
    - 개발자가 초기값을 직접 지정할 수 있다.
- **지역 변수**는 수동 초기화된다.
    - 지역 변수는 항상 직접 초기화해야 한다.


<br/>
<br/>
<br/>

---

## 05. Null

- `null` 은 값이 존재하지 않는, 없다는 뜻으로, 참조형 변수에서 아직 가리키는 대상이 없다면 null이라는 특별한 값을 넣어둘 수 있다.

    ```java
    
    public class Data {
        int value;
    }
    
    public class NullMain1 {
        public static void main(String[] args) {
            Data data = null;
            System.out.println("1.data = " + data);
            data = new Data();
            System.out.println("2.data = " + data);
            data = null;
            System.out.println("3.data = " + data);
        }
    }
    ```

    ```java
     1. data = null
     2. data = ref.Data@x001 // 다음 Line에 null 할당하면서 x001 Data 인스턴스를 아무도 참조하지 않게 됨
     3. data = null
    ```

    - **GC (Garbage Collection)**
        - 아무도 참조하지 않는 인스턴스가 있으면 JVM의 GC (Garbage Collection)가 더 이상 사용하지 않는 인스턴스라 판단하고 인스턴스를 자동으로 메모리에서 제거해준다.
        - 앞서 생성한 x001 Data 인스턴스는 아무도 참조하지 않게 되므로 x001 이라는 참조값을 다시 구할 방법이 없다. 즉, 해당 인스턴스에 다시 접근할 방법이 없다.
            - 아무도 참조하지 않는 인스턴스는 사용되지 않고 메모리만 차지하므로 제거가 필요하다.
                - C와 같은 과거 프로그래밍 언어는 개발자가 직접 제거해야 했고, 실수로 삭제를 누락하면 메모리 부족 오류가 발생하게 된다.
                - 자바는 GC를 자동으로 처리한다.
        - 객체는 해당 객체를 참조하는 곳이 있으면, JVM이 종료할 때까지 계속 생존하지만, 중간에 해당 객체를 아무도 참조하지 않으면 JVM은 필요 없는 객체로 판단하고 GC를 사용해서 제거하는 것이다.

<br/>
<br/>
<br/>


---

## 06. NullPointerException

- `NullPointerException`은 주소가 없는 곳을 찾아갈 때 발생하는 예외이다.
    - `. (dot)` 을 사용하여 객체 참조시 해당 객체에 찾아갈 수 있는데 참조값이 `null`이라면 찾아갈 수 있는 객체(인스턴스)가 없으므로, `NullPointerException`이 발생한다.

        ```java
        
          Exception in thread "main" java.lang.NullPointerException: Cannot assign field
          "value" because "data" is null
              at ref.NullMain2.main(NullMain2.java:6)
        
        ```
