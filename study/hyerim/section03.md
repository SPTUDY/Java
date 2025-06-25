## 기본형과 참조형

변수의 데이터 타입은 **기본형 (primitive type)** 과 **참조형 (reference type)** 으로 나뉜다.

### 기본형

- 변수에 **값 자체를 저장**함
- 자바가 기본으로 제공하는 타입이며, 개발자가 새로 정의할 수 없음
- 예시 : `int`, `long`, `double`, `boolean`

### 참조형

- 변수에 **메모리 주소(참조값)** 를 저장함
- 참조값을 통해 객체나 배열의 실체에 접근
- 개발자가 정의할 수 있음 (클래스, 배열 등)
- 예시 : `클래스`, `배열`
  - 클래스의 객체는 `.`연산자로, 배열은 `[]`연산자로 접근

### 계산 예시

```java
// 기본형 계산 가능
int a = 10, b = 20;
int sum = a + b;

// 참조형 계산 불가능
Student s1 = new Student();
Student s2 = new Student();
s1 + s2; // 오류 발생
```
- 참조형은 참조값끼리 연산할 수 없음
- 객체의 멤버 변수에 접근한 경우에는 연산 가능
```java
Student s1 = new Student();
s1.grade = 100;
Student s2 = new Student();
s2.grade = 90;
int sum = s1.grade + s2.grade; // 연산 가능
```

### 참고 사항
- 기본형은 모두 **소문자**로 시작
- **String**은 참조형이지만 기본형처럼 사용 가능
- 기본형을 제외한 모든 타입은 참조형

## 변수 대입

> 자바는 항상 변수의 값을 복사해서 대입

**기본형 대입**
```java
int a = 10;
int b = a;
```
- 위 코드에서 a의 값을 복사해서 b에 대입
- a와 b는 다른 10을 가짐

**참조형 대입**
```java
Student s1 = new Studnet();
Student s2 = s1;
```
- 위 코드에서 s1에 담겨있는 참조값을 s2에 대입
- s1과 s2는 동일한 참조값을 가짐
  

- 기본형은 변수에 값을 대입하더라도 **값만 복사** 해서 대입
- 참조형은 **객체 위치를 가리키는 참조값을 복사** 해서 대입
  - 즉 동일한 값(동일한 위치)을 접근하는 방법이 2가지로 늘어나는 것
  - 예를 들어 실제 건물이 복사되는 것이 아니라 건물의 위치만 복사됨

### 기본형과 변수 대입
- a를 b에 대입한 뒤에 a 또는 b의 값을 변경하더라도 서로에게 영향을 주지 않고 독립적으로 변경
- 주소가 동일하지 않고 각각 따로 저장되어 있기 때문

### 참조형과 변수 대입
- a를 b에 대입하면 참조값이 들어가게 됨
- 인스턴스는 실제로 하나만 존재하기 때문에 a 또는 b를 변경하면 동시에 변경됨
- 변수 안의 `참조값`을 복사해서 사용

## 메서드 호출
- 메서드를 호출할 때 사용하는 매개변수(파라미터)도 변수
- 따라서 매개변수 값을 전달할 때도 복사해서 전달
```java
public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;

        System.out.println("메서드 호출 전: " + a);
        changePrimitive(a);
        System.out.println("메서드 호출 후: " + a);
    }

    static void changePrimitive(int x) {
        x = 20;
    }
}
```
- a에 있는 값(10)을 복사해서 x로 전달
- x는 20으로 바뀌고 a는 변경 안됨
- 따라서 a는 메서드 호출 전/후 모두 10
  
### 참조형과 메서드 호출
```java
public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: " + dataA.value);
        changeReference(dataA);
        System.out.println("메서드 호출 후: " + dataA.value);
    }

    static void changeReference(Data dataX) {
        dataX.value = 20;
    }
}
```
- 메서드의 매개변수로 dataA 참조값을 넘기기 때문에 메서드에서 멤버변수를 변경하면 실제 데이터도 변경
- 호출 전 10/호출 후 20

**기본형** : `해당 값`이 복사되어 전달
- 메서드 내에서 파라미터 값을 변경하더라도 호출자의 변수값에는 영향이 없음  

**참조형** : `참조값`이 복사되어 전달
- 메서드 내에서 파라미터 값을 변경하면 호출자의 객체도 변경됨
  
## 변수와 초기화

### 변수의 종류
- 멤버변수 (필드) : 클래스에 선언
- 지역변수 : 메서드에 선언, 매개변수도 지역변수의 한 종류
  - 특정 지역에서만 사용되는 변수
  - 매개변수는 특정 메서드 블록에서만 사용되고, 메서드가 끝나면 제거되기 때문에 지역변수

### 예시
```java
public class Student {
		String name;
		int age;
		int grade;
} // name, age, grade는 멤버변수

public class ClassStart3 {
		public static void main(String[] args) {
				Student student1;
				student1 = new Student();
				Student student2 = new Student();
		}
} // student1, student2는 지역변수
```  
```java
public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;

        System.out.println("메서드 호출 전: " + a);
        changePrimitive(a);
        System.out.println("메서드 호출 후: " + a);
    }

    static void changePrimitive(int x) {
        x = 20;
    }
} // a, x는 지역변수
```  
- x는 changePrimitive가 끝나면 제거
- a는 main이 끝나면 제거

### 변수의 값 초기화  

**멤버변수 자동 초기화**

- 숫자 `0` | boolean `false` | 참조값 `null`
- `null`은 참조할 곳이 없음을 의미
- 개발자가 직접 초기값 지정 가능

**지역변수 수동 초기화**

- 개발자가 항상 직접 초기화

## null
참조형 변수에는 객체의 위치를 가리키는 참조값이 담겨있음

- 참조값을 나중에 입력하고자 할 때, null값을 넣어둘 수 있음
- null은 가리키는 대상이 없음

### gc : garbage collection
아무도 참조하지 않는 인스턴스의 최후

- 특정 인스턴스에 null을 대입하면 해당 인스턴스는 아무도 참조하지 않음
- 즉, 이전의 참조값을 다시 구할 수 없음
  - 이러한 인스턴스는 사용되지 않고 메모리만 차지
  - **메모리 부족 문제**
- JVM의 `GC`에서는 메모리에서 참조되지 않는 인스턴스를 자동으로 메모리에서 제거

## NullPointerException
참조값 없이 객체를 찾아가는 경우.
null을 가리킬 때 발생하는 예외
즉, 주소가 없는 곳을 찾아갈 때 발생하는 예외

- 객체를 참조할 때 `.`을 사용
- 참조값이 `null`이면 값이 없기 때문에 찾아갈 객체가 없음

NullPointerException은 null에 .을 찍었을 때 발생
```java
public class NullMain {
		public static void main(String[] args) {
				Data data = null;
				data.value = 10;
				System.out.println("data = " + data.value);
		}
} // NullPointerException 예외 발생
```
- 지역변수가 null인 경우에는 문제 파악이 어렵지 않음
- 그러나 멤버변수가 null인 경우에는 주의 필요
```java
public class BigData {
  Data data;
  int count;
}


public class NullMain3 {
  public static void main(String[] args) {
    BigData bigData = new BigData();
    System.out.println(bigData.count);
    System.out.println(bigData.data);

    // NullPointerException 예외 발생
    // System.out.println(bigData.data.value);
  }
}
```  
- 참조값 초기화 시, 자동으로 null로 초기화
- BigData의 멤버변수 data는 null로 초기화
  - 참조값은 null로 초기화됨
- bigData.data는 현재 null이므로 bigData.data.value에 접근하고자 할 때 **NullPointerException** 예외 발생