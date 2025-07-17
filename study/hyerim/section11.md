## 다형성

**Polymorphism**: 다형성, 다양한 형태, 여러 형태  
- 한 객체가 여러 타입의 객체로 취급될 수 있는 능력

### 다형적 참조

**예시**  
- 부모 → 부모 참조 가능  
- 자식 → 부모 타입으로 참조 가능 (업캐스팅)  
```java
// 부모 변수가 자식 인스턴스를 참조 (다형적 참조)
System.out.println("Parent -> Child");
Parent poly = new Child();
poly.parentMethod();
```
- 위와 같이 생성하면 메모리에 `Child`와 `Parent` 인스턴스가 모두 생성됨
- 이때 자식 인스턴스의 참조값을 부모 타입인 `Parent` 변수에 담는 것 → 업캐스팅

**부모는 자식을 담을 수 있음**  
반대로 **자식은 부모를 담을 수 없음** → 컴파일 오류 발생  
또한 부모 타입으로는 자식의 고유 메서드를 호출할 수 없음
```java
// 부모 타입에서 자식의 기능을 호출하는 경우 에러 발생
//poly.childMethod(); // 컴파일 에러
```
- 자식 타입의 메서드를 호출하려면 **다운캐스팅** 필요
```java
Parent parent = new Parent();
Child child = new Child();
```
- 다형성에서는 부모 클래스 타입이 자식 클래스 인스턴스를 참조할 수 있음
- 만약 `Child` 클래스에 자식(`Grandson`)이 있다면 그 역시 참조 가능
```java
Parent poly1 = new Child();
Parent poly2 = new Grandson();
```
- 이렇게 다양한 형태의 인스턴스를 참조할 수 있는 것을 **다형적 참조**라고 함

**정리**
- 부모 타입으로 자식 타입을 참조 = 업캐스팅
  - 부모 타입의 메서드만 호출 가능
  - 자식 타입의 메서드는 호출 불가능 (정적 타입 기준)
  - 단, **오버라이딩된 메서드**는 실행 시점에 자식 메서드가 호출됨 (동적 바인딩)
- 자식 타입으로 부모 타입을 참조하는 것은 불가능 → 다운캐스팅 필요 (명시적 작성 필요)

---

## 캐스팅

```java
public class CastingMain1 {
  public static void main(String[] args) {
    Parent poly = new Child();
    //poly.childMethod(); // 컴파일 오류

    // 다운 캐스팅
    //Child child = poly; // 컴파일 오류
    Child child = (Child) poly;
    child.childMethod();
  }
}
```
- `poly.childMethod()` 호출 시, `poly`는 `Parent` 타입이라 해당 메서드 찾을 수 없음
- `childMethod()`는 자식 타입에만 존재 → 컴파일 오류
- **다운캐스팅**을 통해 자식 메서드 호출 가능

### 다운캐스팅

- 부모 타입을 자식 타입으로 강제 변환
- 부모는 자식을 담을 수 있지만, 자식은 부모를 담을 수 없음
- 다운캐스팅을 통해 자식 메서드 호출 가능
```java
Child child = (Child) poly;
```
- poly의 참조값을 복사해 Child로 강제 형변환
- poly의 타입 자체는 여전히 Parent

**캐스팅 종류**
- **업캐스팅**: 자식 → 부모 타입 (자동 변환)
- **다운캐스팅**: 부모 → 자식 타입 (명시적 변환 필요)

### 일시적 다운캐스팅

변수 없이 하위 타입 기능 사용 가능
```java
((Child) poly).childMethod();
```
- poly를 잠시 `Child`로 변환하여 기능 호출
- poly 자체의 타입은 변경되지 않음

---

## 업캐스팅

```java
public class CastingMain3 {
  public static void main(String[] args) {
    Child child = new Child();
    Parent parent1 = (Parent) child; // 생략 가능
    Parent parent2 = child;

    parent1.parentMethod();
    parent2.parentMethod();
  }
}
```
- `parent1`, `parent2`는 동일한 참조값
- 업캐스팅은 생략 가능하며, 생략하는 것이 일반적

---

## 다운캐스팅과 주의점

```java
public class CastingMain4 {
  public static void main(String[] args) {
    Parent parent1 = new Child();
    Child child1 = (Child) parent1;
    child1.childMethod();

    Parent parent2 = new Parent();
    //Child child2 = (Child) parent2; // 런타임 오류
    //child2.childMethod();
  }
}
```
- parent1은 실제로 Child 인스턴스를 참조하므로 다운캐스팅 가능
- parent2는 Parent 인스턴스를 참조 → 다운캐스팅 시 런타임 오류 (`ClassCastException`) 발생

**업캐스팅은 안전하고, 다운캐스팅은 위험한 이유**
- 자식 객체를 생성하면 부모 객체도 함께 생성됨 → 업캐스팅 안전
- 부모 객체만 생성하면 자식 객체는 생성되지 않음 → 다운캐스팅 위험 (명시적 필요)

**컴파일 오류 vs 런타임 오류**
- 컴파일 오류: 코드 작성 중 IDE에서 감지, 실행 전 문제
- 런타임 오류: 실행 중 발생, 사용자 실행 환경에서 문제 발생

---

## instanceof

```java
public class CastingMain5 {
  public static void main(String[] args) {
    Parent parent1 = new Parent();
    System.out.println("parent1 호출");
    call(parent1);

    System.out.println();

    Parent parent2 = new Child();
    System.out.println("parent2 호출");
    call(parent2);
  }

  private static void call(Parent parent) {
    parent.parentMethod();
    if (parent instanceof Child) {
      System.out.println("Child 인스턴스 맞음");
      Child child = (Child) parent;
      child.childMethod();
    } else {
      System.out.println("Child 인스턴스 아님");
    }
  }
}
```

**instanceof 판단 기준**
- 왼쪽 클래스가 오른쪽 클래스를 담을 수 있다면 true, 그렇지 않다면 false
- `자식 instanceof 부모`: true
- `부모 instanceof 자식`: false
- `자식 instanceof 자식` / `부모 instanceof 부모`: true

**자바 16 instanceof**
```java
if (parent instanceof Child child) {
  child.childMethod();
}
```
- 조건이 true일 경우, 자동으로 `Child` 타입 변수로 다운캐스팅

---

## 메서드 오버라이딩

**오버라이딩된 메서드가 항상 우선권을 가짐**
- 변수는 오버라이딩되지 않음
- 메서드는 오버라이딩되어 동적 바인딩으로 호출

```java
public class OverridingMain {
  public static void main(String[] args) {
    Parent poly = new Child();
    System.out.println("Parent -> Child");
    System.out.println("value = " + poly.value);
    poly.method();
  }
}
```

**실행 결과**
```
Parent -> Child
value = parent
Child.method
```

- `poly`는 `Parent` 타입이므로 `poly.value`는 Parent의 value
- `poly.method()`는 오버라이딩된 `Child.method()`가 실행됨
- 오버라이딩된 메서드 우선권을 가짐