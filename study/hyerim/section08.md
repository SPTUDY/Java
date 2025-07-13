## 자바 메모리 구조

### 자바 메모리 구조 개념

`메서드` / `스택` / `힙` 영역으로 나뉨
- **메서드 영역**: 클래스 정보를 보관
- **스택 영역**: 실제 프로그램이 실행되는 영역
  - 메서드가 실행될 때마다 쌓임
- **힙 영역**: 객체(인스턴스)가 생성되는 영역
  - `new`명령어를 사용하면 이 영역 사용
  - **배열**도 이 영역을 사용

### 자바 메모리 구조 실제

- **메서드 영역**: 프로그램 실행 시 필요한 공통 데이터 관리
  - 프로그램의 모든 영역에서 공유
  - 클래스 정보: 클래스 실행 코드(바이트 코드), 메서드와 생성자 코드 등 ...
  - static 영역: static 변수
  - 런타임 상수 풀: 공통 리터럴 상수 (문자열, 숫자 등)
- **스택 영역**
  - 지역변수, 중간 연산 결과, 메서드 호출 정보 등 ...
  - 스택 프레임: 스택 영역에 쌓이는 네모 박스
    - 메서드를 호출할 때마다 하나의 스택 프레임이 쌓이고, 메서드가 종료되면 해당 스택 프레임 제거
- **힙 영역**: 객체(인스턴스)와 배열이 생성되는 영역
  - 가비지 컬렉션이 이루어지는 주요 영역
  - 더이상 참조되지 않는 객체는 GC에 의해 제거
- 스택 영역은 각 스레드별로 실행 스택 생성 → 즉, 스레드 수 만큼 스택 영역이 생성됨

**메서드 코드는 메서드 영역에**

자바에서 특정 클래스로 n개의 인스턴스 생성 → 힙 메모리에 n개의 인스턴스 생성됨  
각각의 인스턴스는 변수와 메서드를 가짐 → 각 인스턴스는 **동일한 메서드 코드를 공유**하지만 **다른 변수**를 가짐  
따라서 인스턴스 변수에는 메모리 할당되지만 **메서드에 대한 새로운 메모리 할당은 없음**

## 스택과 큐 자료 구조

**스택 구조**

**LIFO: Last In First Out**
- **후입선출**: 마지막에 넣은게 처음으로 나옴
- **메서드 호출**에 적합한 구조

**큐 구조**

**FIFO: First In First Out**
- **선입선출**: 처음에 넣은게 처음으로 나옴
---
### 스택 영역

```java
public class JavaMemoryMain1 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(10);
        System.out.println("main end");
    }

    static void method1(int m1) {
        System.out.println("method1 start");
        int cal = m1 * 2;
        method2(cal);
        System.out.println("method1 end");
    }

    static void method2(int m2) {
        System.out.println("method2 start");
        System.out.println("method2 end");
    }
}
```
**실행 결과**
> main start  
> method1 start  
> method2 start  
> method2 end  
> method1 end  
> main end

- 메인 시작 > 메서드1 시작 > 메서드2 시작 > 메서드2 종료 > 메서드1 종료 > 메인 종료
- 먼저 실행된게 가장 나중에 종료됨 = **LIFO**
- 스택 구조와 동일: main이 제일 아래에 쌓이고, 그 위에 method1, method2가 차례로 쌓임
  
main 스택프레임  
- args[] 변수를 갖고 있음  

method1 스택프레임  
- m1, cal 지역 변수를 갖고 있음  

method2 스택프레임  
- m2 지역 변수를 갖고 있음  

자바는 스택 영역을 사용하여 **메서드 호출과 지역변수(매개변수 포함)를 관리**  
메서드를 계속 호출하면 스택 프레임이 계속 쌓임  
지역변수는 스택에서 관리 → 스택프레임 종료 시, 지역변수도 함께 제거  
스택프레임 종료 시, 프로그램도 종료  

## 스택 영역과 힙 영역

`메인 실행`: 메소드1 실행 → 메소드1 스택프레임 생성  
`메소드1 실행`: Heap 영역에 **Data 인스턴스** 생성 / 참조값 x001 data1(Stack)에 보관  
`메소드2 실행`: data2에 data1의 참조값 x001 넘겨줌 / 두 메소드는 같은 인스턴스 x001를 참조하고 있음  
`메소드2 종료`: 메소드2의 스택프레임 사라지면서 data2 사라짐  
`메소드1 종료`: 메소드1의 스택프레임 사라지면서 data1 사라짐 / x001를 참조하는 곳이 없음 → GC 대상이므로 메모리에서 제거  
`메인 종료`

> 지역변수 **Heap**  
> 객체(인스턴스) **Stack**

## static 변수

주로 멤버변수와 메서드에서 사용

예제
```java
public class DataCountMain1 {

    public static void main(String[] args) {
        Data1 data1 = new Data1("A");
        System.out.println("A count = " + data1.count);

        Data1 data2 = new Data1("B");
        System.out.println("B count = " + data2.count);
        
        Data1 data3 = new Data1("C");
        System.out.println("C count = " + data3.count);
    }
}
```
결과: 기대한 대로 나오지 않음
> 1  
> 1  
> 1  

객체를 생성할 때마다 Data1 인스턴스가 새로 만들어지고, count 변수 또한 새로 만들어짐
- count 값은 인스턴스끼리 공유되지 않음
- 서로 공유하는 변수를 만들면 됨
```java
public class Data2 {
    public String name;

    public Data2(String name, Counter counter) {
        this.name = name;
        counter.count++;
    }
}
```
```java
public class DataCountMain2 {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Data2 data1 = new Data2("A", counter);
        System.out.println("A count = " + counter.count);

        Data2 data2 = new Data2("B", counter);
        System.out.println("B count = " + counter.count);

        Data2 data3 = new Data2("C", counter);
        System.out.println("C count = " + counter.count);
    }
}
```
결과
> 1  
> 2  
> 3  

각 인스턴스가 count 값을 공유하고 있기 때문에 원하는 대로 결과가 출력됨
- 최종적으로 Counter, Data2 "A", Data2 "B", Data "C" 네개의 인스턴스가 생성됨
- 그러나 Data2가 몇개 생성되었는지만 알고 싶은데..  
- 바깥에서 counter을 별도로 만들어야 된다는 불편함  
- 생성자에 counter 매개변수가 따로 받아줘야 하는 불편함
- 공용 변수를 만드는 방법??? → **static 변수**

### static 변수 사용

클래스에서 공용으로 사용할 수 있는 변수를 만들기 = **static 변수**
```java
public class Data3 {
    public String name;
    public static int count;

    public Data3(String name) {
        this.name = name;
        count++;
    }
}
```
멤버변수에 `static`을 붙이게 되면 정적변수, 클래스변수가 됨  
객체가 생성되면 생성자에서 정적변수 count의 값을 하나 증가  

```java
public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count = " + Data3.count);

        Data3 data2 = new Data3("B");
        System.out.println("B count = " + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("C count = " + Data3.count);
    }
}
```
결과
> 1  
> 2  
> 3 
- static 변수로 선언하니 원하는대로 결과가 출력됨
- 즉, counter가 인스턴스가 생성될때마다 하나씩 증가됨

### 설명

`static`이 붙은 멤버변수는 **메서드**영역에서 관리
- 인스턴스 영역(힙 영역)에 생성되지 않음
- 각 인스턴스는 힙 영역에 생성되지만, count 변수는 메서드 영역에 생성됨
- 따라서 count 변수를 증가시키면 메서드 영역에서의 count 값을 증가시킴  

count 변수에 접근할 때 클래스 명에 `.`(dot)을 붙여 멤버변수 접근하듯이 접근
- 공용 변수를 사용하여 편리하게 문제를 해결

static 변수는 붕어빵 틀(메서드 영역)에서 관리한다.
- 붕어빵 틀은 한개이므로 클래스 변수도 하나만 생성됨
- 인스턴스가 여러개 생성되어도 클래스 변수는 "하나만" 생성

### 용어 정리

```java
public class Data3 {
    public String name;
    public static int count; //static
}
```
예제 코드에서 `name`, `count` 모두 멤버변수  
멤버변수는 `static`이 붙은것 / 아닌 것으로 나뉨

**멤버변수 종류**

- **인스턴스 변수**:  `static`이 붙지 않은 멤버변수
  - 예: `name`
  - 인스턴스를 생성해야 사용 가능
  - 인스턴스에 소속

- **클래스 변수**: `static`이 붙은 멤버변수
  - 예: `count`
  - 클래스 변수, 정적 변수, static 변수 라고도 함
  - 인스턴스와 무관하게 바로 접근해서 사용 가능
  - 클래스에 소속
  - 딱 **하나만** 만들어짐 → 여러곳에서 **공용으로 사용**
  - 사용할 때 클래스를 통해 접근 (예: `Data3.count`)

**변수와 생명 주기**
- **지역 변수(매개변수 포함)**
  - **스택 영역**의 스택 프레임에 보관
  - 메서드 종료 시 스택 프레임 제거 → 이때 지역 변수도 함께 제거
  - 생존 주기가 짧음
- **인스턴스 변수**
  - 인스턴스에 있는 멤버 변수
  - **힙 영역** 사용
  - GC가 발생하기 전까지 생존
  - 보통 지역 변수보다 생존 주기가 긺
- **클래스 변수**
  - **메서드 영역**의 static 영역에 보관
  - 메서드 영역은 프로그램 전체에서 사용하는 공용 공간
  - JVM에 로딩 되는 순간 생성 → JVM이 종료될 때까지 생명 주기 이어짐

### 정적 변수 접근법

**클래스**를 통해 접근할 수도 있고, **인스턴스**를 통해서 접근할 수도 있음
```java
public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count = " + Data3.count);

        Data3 data2 = new Data3("B");
        System.out.println("B count = " + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("C count = " + Data3.count);

        Data3 data4 = new Data3("D");
        System.out.println("D count = " + data4.count);
    }
}
```
결과
- A, B, C는 클래스를 통한 접근
- D는 인스턴스를 통한 접근
- count 값은 동일하게 증가됨

그러나 인스턴스를 통한 접근은 **권장하지 않음**
- 인스턴스를 통해 접근하면 해당 변수가 인스턴스 변수인지 클래스 변수인지 바로 알 수 없음
- 그러나 클래스를 통해 접근하면 해당 변수가 클래스 변수임을 단번에 알 수 있음
```java
Data3 data4 = new Data3("D");
System.out.println("D count = " + data4.count);

Data3 data5 = new Data3("E");
System.out.println("E count = " + data5.count);
```
예를 들어 위 코드에서...  
- count가 static 변수임에도 불구하고 인스턴스를 통해 접근하면 인스턴스 변수가 각각 따로 생성된 것처럼 보임  
반면...  
- 클래스를 통해 접근하면 클래스 변수임을 바로 알 수 있음  
- 관례상 클래스를 통해 접근!!

## static 메서드

특정 클래스의 메서드를 호출하기 위해서는 해당 클래스의 인스턴스를 생성해야됨
- 단순히 기능만 제공하는 메서드를 호출하고자 할 때는 굳이 인스턴스를 생성할 필요 없음
  - 객체를 생성하더라도 인스턴스 내부에 멤버변수가 없기 때문에 의미가 없음
- static 메서드로 해결
```java
public class DecoMain2 {
    public static void main(String[] args) {
        String s = "hello java";
        String deco = DecoUtil2.deco(s);

        System.out.println("before: " + s);
        System.out.println("after: " + deco);
    }
}
```
deco 메서드를 static(정적 메서드)으로 만들면 멤버변수 접근하듯이 `.`으로 접근 가능  
인스턴스 생성 없이 클래스를 통해 접근하여 메서드를 바로 부를 수 있음  
`클래스명.메서드명`으로 정적 메서드에 편리하게 접근 가능

**클래스 메서드**  
- 메서드 앞에 static을 붙일 수 있음  
- 정적 메서드라고도 함  

**인스턴스 메서드**  
- static이 붙지 않은 메서드  
- 인스턴스를 생성해야 호출할 수 있음
  
멤버변수 없이 로직만 있는 메서드일 경우 static 메서드로 만들어서 편리하게 사용 가능  
- 즉, 객체 생성이 의미가 없는 경우  
- 클래스를 통해 접근 가능

### 정적 메서드 사용법

static 메서드는 static만 사용할 수 있음
- 정적 메서드는 static이 붙은 **정적 메서드나 정적 변수만 사용**
- static은 클래스 소속... 클래스 소속만 사용할 수 있음
- 즉, 인스턴스 변수나 인스턴스 메서드 사용 불가능
반대로 모든 곳에서 static 호출 가능
- 정적 메서드는 공용 기능
- 접근 제어자만 허락한다면 클래스를 통해 static 호출 가능

예제
```java
public class DecoData {

    private int instanceValue;
    private static int staticValue;

    public static void staticCall() {
        //instanceValue++;  //인스턴스 변수 접근 불가능, 컴파일 에러
        //instanceMethod(); //인스턴스 메서드 접근 불가능, 컴파일 에러
        staticValue++;      //정적 변수 접근 가능
        staticMethod();     //정적 변수 접근 가능
    }

    public void instanceCall() {
        instanceValue++;
        instanceMethod();
        staticValue++;
        staticMethod();
    }

    public void instanceMethod() {
        System.out.println("instanceValue in instanceMethod = " + instanceValue);
        System.out.println("staticValue in instanceMethod = " + staticValue);

    }

    public static void staticMethod() {
        //인스턴스 변수 접근 불가능
        //System.out.println("instanceValue in staticMethod = " + instanceValue);
        System.out.println("staticValue in staticMethod = " + staticValue);
    }
}
```
정적 변수는 클래스 소속  
인스턴스는 생성되면 힙 영역에 생성됨  
정적 변수/클래스 입장에서는 힙 영역을 알 수 없음  
따라서 **정적은 정적만 접근 가능**
  
만약 static에서 인스턴스 변수 또는 메서드에 접근하면 **컴파일 오류** 발생  
static은 공용 공간에 있기 때문에 인스턴스에서 접근 가능  

static 변수는 계속해서 증가됨  
instance 변수는 새로운 인스턴스가 생성될 떄마다 같이 새로 생성됨
- instanceCall()을 호출하는 경우에만 증가
  
**정적 메서드가 인스턴스 기능 사용 불가능한 이유**  

정적 메서드는 클래스를 통해 바로 호출 가능 → 인스턴스에서 바로 사용 가능  

그러나 인스턴스는 **참조값**의 개념이 있고,   
정적 메서드(메서드 영역)는 특정 인스턴스의 참조값을 알 수 없기 때문에   
인스턴스 변수 및 메서드를 **사용할 수 없음**  

### static 메서드 정리

**멤버 메서드**
- **인스턴스 메서드**: static이 붙지 않은 멤버 메서드
  - 인스턴스를 생성해야 사용 가능하며 인스턴스에 소속
- **클래스 메서드**: static이 붙은 멤버 메서드
  - 클래스 메서드, 정적 메서드, static 메서드 라고 불림  
  - 클래스에서 바로 접근하여 사용 가능
  - 클래스 자체에 소속

**정적 메서드 활용**  
유틸리티성 메서드, 즉 인스턴스 변수 없이 값을 계산 및 반환하는 메서드

**정적 메서드 접근법**  
인스턴스를 통한 접근: 자주 사용하지 않음
- 인스턴스 메서드를 호출하는 것과 헷갈림
클래스를 통한 접근

### static import

코드 작성 시, 동일한 클래스명을 자주 사용하게 되는 경우
```java
public class DecoDataMain {
  public static void main(String[] args) {
    DecoData.staticCall();
    DecoData.staticCall();
    DecoData.staticCall();
    DecoData.staticCall();
  }
}
```
  
import를 통해 코드를 짧게 만들 수 있음
```java
import static static2.DecoData.*;

public class DecoDataMain {
  public static void main(String[] args) {
    staticCall();
    staticCall();
    staticCall();
    staticCall();
  }
}
```
클래스 명을 적지 않아도 DecoData 클래스 내부의 모든 static 메서드, 변수 사용 가능 (*)

### main() 메서드는 정적 메서드  
인스턴스 생성 없이 실행되는 main 메서드  
main이 정적 메서드이기 때문에 정적 메서드만 호출할 수 있음
- 같은 클래스 내부의 정적 메서드만 호출할 수 있음
- main에서 사용하는 메서드는 정적 메서드로 선언하여 사용해야 함