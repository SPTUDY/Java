# Section 11. 다형성 (1)

## 다형성

- `다양한 형태`, `여러 형태`를 뜻한다.
- 한 객체가 여러 타입의 객체로 취급될 수 있는 능력을 뜻한다.
    - 다형성을 사용하면 하나의 객체가 다른 타입으로 사용될 수 있다.

## 다형성을 이해하기 위한 2가지 핵심 이론

### 1. 다형적 참조

### 2. 메서드 오버라이딩

---

## 1. 다형적 참조

```java
// 부모 변수가 자식 인스턴스 참조 (다형적 참조)
Parent poly = new Child();
poly.parentMethod();

// 자식의 기능은 호출할 수 없다. (컴파일 오류 발생)
// poly.childMethod();

// 자식은 부모를 담을 수 없다
// Child child1 = new Parent();

```

- 예제 설명
    - 부모 타입의 변수가 자식 인스턴스를 참조하는 경우이다.
    - `Parent poly = new Child()`
        - Child 인스턴스를 만들었으므로 메모리 상에 `Child`와 `Parent`가 모두 생성된다.
        - 생성된 참조값을 `Parent` 타입의 변수인 `poly`에 담아둔다.

**💡부모는 자식을 담을 수 있다.**

- 자식 타입은 부모 타입을 담을 수 없다.
- 자바에서 부모 타입은 자신을 기준으로 모든 자식 타입을 참조할 수 있다.
    - 다양한 형태를 참조하므로 이를 **`다형적 참조`**라 한다.

## 다형성과 캐스팅

`poly`는 `Parent` 타입이므로 `poly.childMehtod()`를 호출시 `childMethod()`를 참조할 수 없어 컴파일 오류가 발생한다.

`childMethod`를 호출하려면 **`캐스팅`**이 필요하다.

- 호출하는 타입을 `Child` 타입으로 변경하면 `childMethod()`를 호출할 수 있다.
    - ‼️ 그러나 자식은 부모를 담을 수 없다.
        - `Child child = poly`  (x)
            - poly는 Parent 타입이므로 child 변수에 담을 수 없다.
    - 💡 다운캐스팅을 통해 부모 타입을 잠깐 자식 타입으로 변경하면 된다.
        - `Child child = (Child) poly`

```java
Parent poly = new Child();

// 자식의 기능은 호출할 수 없다. (컴파일 오류 발생)
// poly.childMethod();

// 다운캐스팅 (부모타입 -> 자식타입)
Child child = (Child) poly;
child.childMethod();

```

## 캐스팅

- 형식 : `(Type) target`
- 하나의 데이터 타입을 다른 데이터 타입으로 변경하는 것이다.
- 캐스팅한 참조값의 기존 타입은 유지된다.
- 종류
    - `업캐스팅` : 부모 타입으로 변경
    - `다운캐스팅` : 자식 타입으로 변경

### 일시적 다운 캐스팅

- 다운캐스팅 결과를 변수에 담아두는 과정을 생략하고 일시적으로 다운 캐스팅을 해서 인스턴스에 있는 하위 클래스의 기능을 바로 호출할 수 있게 한다.

```java
Parent poly = new Child();
((Child) poly).childMethod();
```

### 업캐스팅

- 업캐스팅은 생략 가능하다. (권장)

```java
Child child = new Child();
// child를 Parent 타입으로 업캐스팅
Parent parent1 = (Parent) child;
Parent parent2 = child; // 업캐스팅 생략 가능
```

### 다운캐스팅

- 잘못하면 심각한 러타임 오류가 발생할 수 있다.

```java
Parent parent1 = new Child();
Child child1 = (Child) parent1;
child1.childMethod(); // 문제 없음

Parent parent2 = new Parent();
Child child2 = (Child) parent2; // 런타임 오류 - ClassCastException
child2.childMethod(); // 실행 불가
```

- 예제 설명
    - `parent2`는 `new Parent()` 부모 타입으로 객체를 생성하므로 메모리 상에 자식 타입이 전혀 존재하지 않는다. 그러므로 `parent2`를 Child 타입으로 다운캐스팅하는 경우 `Child` 타입 자체를 사용할 수 없으므로 `ClassCastException` 오류가 발생한다.
- 업캐스팅의 경우 상위 부모 타입으로 변경되는 것이므로 메모리 상에 부모 타입이 존재하기 때문에 항상 안전하지만, 다운캐스팅의 경우 인스턴스 존재하지 않는 하위타입으로 캐스팅하면 문제가 발생하므로, 이 문제를 인지하고 사용한다는 의미로 명시적으로 캐스팅을 해주어야 한다.
- 클래스 A, B, C가 A > B > C 의 상속 관계를 지니는 경우
    - `A a = new B()` : A로 업캐스팅
    - `B b = new B()` : 자신과 같은 타입
    - `C c = new B()` : 하위 타입은 대입 불가능 (컴파일 오류 발생)
    - `C c = (C) new B()` : 하위 타입으로 강제 다운캐스팅 (런타임 오류 발생)

(+) **컴파일 오류 vs 런타임 오류**

- **컴파일 오류**
    - 변수명 오타, 잘못된 클래스 이름 사용 등 자바 프로그램을 실행하기 전에 ㅂ라생하는 오류이다.
    - IDE에서 즉시 확인할 수 있기 때문에 안전하고 좋은 오류이다.
- **런타임 오류**
    - 프로그램이 실행되고 있는 시점에 발생하는 오류이다.
    - 고객이 해당 프로그램을 실행하는 도중에 발생하기 때문에 매우 안 좋은 오류이다.

## instanceof

변수가 참조하는 인스턴스의 타입을 확인하고 싶은 경우 사용한다.

```java
Parent parent1 = new Parent();
call(parent1); // childMethod 호출 X

Parent parent2 = new Child();
call(parent2); //childMethod 호출 O

private static void call(Parent parent) {
	if (parent instanceof Child) {
		System.out.println("Child 인스턴스 맞음");
		Child child = (Child) parent;
		child.childMethod();
	}
}
```

```java
new Parent() instanceof Parent // true
new Child() instanceof Parent // true
new Parent() instanceof Child // false
new Child() instanceof Child // true

Parent parent = new Child
parent instanceof Child // true
```

### Java16 - Pattern Matching for instanceof

- `instanceof`을 사용하는 동시에 변수를 선언할 수 있다.

    ```java
    Parent parent1 = new Parent();
    call(parent1);
    
    Parent parent2 = new Child();
    call(parent2);
    
    private static void call(Parent parent) {
    	if (parent instanceof Child child) { // 변수 선언
    		System.out.println("Child 인스턴스 맞음");
    		// Child child = (Child) parent; 생략
    		child.childMethod();
    	}
    ```


---

## 2. 다형성과 메서드 오버라이딩

***오버라이딩 된 메서드는 항상 우선권을 가진다.***

```java
// Child 클래스가 Parent의 method 메서드를 오버라이딩

Parent poly new Child();
System.out.println(poly.value); // 변수는 오버라이딩 X
poly.method(); // 메서드 오버라이딩
```

- `poly` 변수는 `Parent` 타입으로, `poly.value`, `poly.method()`를 호출하면 Parent 타입에서 기능을 찾아서 실행한다.
    - `poly.value`
        - `Parent` 타입에 있는 `value` 값을 읽는다.
    - `poly.method()`
        - `Parent` 타입에 있는 `method()`를 실행하려 하지만 `Child.method()`가 오버라이딩 되어 있으므로 `Child.method()`가 실행된다.
        - ‼️ 오버라이딩 된 메서드는 항상 우선권을 가진다.

---

# 정리

다형성의 핵심 이론

- **다형적 참조**
    - 하나의 변수 타입으로 다양한 자식 인스턴스를 참조할 수 있는 기능
- **메서드 오버라이딩**
    - 기존 기능을 하위 타입에서 새로운 기능으로 재정의