## 다형성 활용

**예제**
```java
public class AnimalSoundMain {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        System.out.println("동물 소리 테스트 시작");
        dog.sound();
        System.out.println("동물 소리 테스트 종료");

        System.out.println("동물 소리 테스트 시작");
        cat.sound();
        System.out.println("동물 소리 테스트 종료");

        System.out.println("동물 소리 테스트 시작");
        cow.sound();
        System.out.println("동물 소리 테스트 종료");
    }

}
```
- 코드 중복이 너무 많음 → 동물 소리 테스트 시작 / 종료 출력 문구
- 메서드나 배열(for문)을 통해 해결..? 동물마다 타입이 다르기 때문에 해결되지 않음
- 다형적 참조와 메서드 오버라이딩을 이용하여 해결!

**중복 문제 해결 코드**
```java
public class AnimalPolyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);
    }

    public static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
```
- 각 동물이 Animal을 상속받도록 하여 sound() 메서드를 오버라이딩
- `메서드 오버라이딩`: 오버라이딩된 메서드는 항상 우선권을 가짐
  - 만약 오버라이딩이 없었다면, Animal.sound()가 실행되었을 것임
- `다형적 참조`: Animal 클래스는 Dog, Cat, Cow 클래스를 모두 담을 수 있음
  - Animal은 부모 클래스이기 때문
  - 겉으로 보기엔 Animal이지만 사실 다양한 모습을 갖고 있음
- 다형성 덕분에 새로운 동물을 추가하더라도 기존 코드(soundAnimal)를 재사용할 수 있음

**배열 이용하여 중복 제거**
```java
public class AnimalPolyMain2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        Animal[] animalsArr = {dog, cat, cow};

        for (Animal animal : animalsArr) {
            System.out.println("동물 소리 테스트 시작");
            animal.sound();
            System.out.println("동물 소리 테스트 종료");
        }
    }
}
```
- Dog, Cat, Cow 모두 Animal 타입에 해당
- 따라서 Animal 타입으로 배열 만들어서 이용 가능

**조금 더 개선**
```java
public class AnimalPolyMain3 {
  public static void main(String[] args) {
    Animal[] animalsArr = {new Dog(), new Cat(), new Cow()};

    for (Animal animal : animalsArr) {
      soundAnimal(animal);
    }
  }

  private static void soundAnimal(Animal animal) {
    System.out.println("동물 소리 테스트 시작");
    animal.sound();
    System.out.println("동물 소리 테스트 종료");
  }
}

```
- 변수에 담는 과정 없이 바로 생성하여 배열에 넣음
- 새로운 배열 요소가 추가되어도 soundAnimal(메서드) 부분은 변하지 않음
  - 새로운 동물이 추가되면 변하는 부분은 배열 요소 추가하는 부분
  - 변하지 않는 부분은 soundAnimal 메서드 부분

### 문제점

1. Animal 클래스를 생성할 수 있는 문제
- 부모 클래스는 다형성을 위한 것이기 때문에 실제로 생성되는 인스턴스는 아님
- 부모 클래스는 직접 생성되지 않고 자식 클래스만 생성되어 사용됨

2. Animal 클래스를 상속받는 곳에서 sound() 메서드 오버라이딩을 하지 않을 가능성
- 상속 받았는데 메서드 오버라이딩 하지 않으면 부모 클래스의 메서드가 호출됨

**추상 클래스**와 **추상 메서드**를 이용하여 해결 가능

## 추상 클래스

추상적인 개념을 제공하는 클래스  
실체인 인스턴스가 존재하지 않음  
상속을 목적으로 사용, 부모 클래스 역할 담당  
```java
abstract class AbstractAnimal {...}
```
- 추상 클래스는 클래스를 선언할 때 `abstract` 키워드를 붙여주면 됨  
- 추상 클래스는 기존 클래스와 완전히 동일하지만 **직접 인스턴스를 생성하지 못함**  

### 추상 메서드

부모 클래스를 상속 받는 자식 클래스가 **반드시 오버라이딩 해야하는 메서드**  
추상적인 개념을 제공하는 메서드로, 실체가 존재하지 않고 메서드 바디가 없음  
```java
public abstract void sound();
```
- 추상 메서드는 메서드를 선언할 때 `abstract` 키워드를 붙여주면 됨
- **추상 메서드가 하나라도 있는 클래스는 추상 클래스로 선언**
  - 그렇지 않으면 컴파일 오류
  - 추상 메서드는 바디가 없음 → 불완전한 클래스이므로 인스턴스가 생성되지 않도록 추상 클래스로 선언
  - 추상 메서드는 바디가 없기 때문에 호출되면 안됨
- **추상 메서드는 상속 받는 자식 클래스에서 반드시 오버라이딩**
  - 부모 클래스의 추상 메서드에서 구현하면 컴파일 오류
  - 오버라이딩 하지 않기 위해서는 자식 클래스도 추상 클래스가 되어야 함
- 추상 메서드는 기존 메서드와 완전히 동일
  - 자식 클래스가 해당 메서드를 반드시 오버라이딩 해야한다는 제약 추가

예제
```java
public class AbstractMain {

    public static void main(String[] args) {
        //추상 클래스는 인스턴스 생성 안됨
        //AbstractAnimal animal = new AbstractAnimal();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);
    }

    public static void soundAnimal(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
```
- 추상 클래스는 인스턴스 생성 불가능
- 오버라이딩 하지 않으면 **컴파일 오류** 발생

### 순수 추상 클래스

**모든 메서드가 추상 메서드인 추상 클래스**
- 기능은 하나도 구현되어 있지 않음
- 자식 클래스에서 모두 오버라이딩 해주어야 함

**순수 추상 클래스**는 실행 로직을 전혀 갖고 있지 않음
```java
public abstract class AbstractAnimal {
    public abstract void sound();
    public abstract void move();
}
```
- AbstractAnimal을 상속받는 자식 클래스에서 모두 구현해주어야 함
- 다형성을 위한 부모 타입으로써 껍데기 역할만 제공

**순수 추상 클래스 특징**  
- 인스턴스 생성 불가능
- 상속 시, 자식은 **모든 메서드를 오버라이딩**
- 주로 다형성을 위해 사용
  - 자식 클래스에서 순수 추상 클래스에 있는 메서드가 구현되어 있다는 것이 보장되어 있음

**상속 받는 클래스는 모든 메서드를 오버라이딩**
- 자식 클래스에서 규격을 맞추어 구현
- **인터페이스**와 같은 느낌: 규격을 맞춤
- 자바에서는 인터페이스 기능 제공 (순수 추상 클래스와 동일)

## 인터페이스

**순수 추상 클래스**를 더욱 편리하게 사용  
`interface` 키워드 사용
```java
public interface InterfaceAnimal {
    void sound(); 
    void move();
}
```
- `public abstract` 키워드 생략 가능

**인터페이스 특징**
- 기본적으로 순수 추상 클래스와 동일, 편의 기능 추가
  - 인스턴스 생성 불가능, 상속 시 모든 메서드 오버라이딩, 주로 다형성을 위해 사용
- 인터페이스의 메서드는 모두 **public, static**
- 메서드에 `public static` 생략 가능
- 인터페이스는 다중 구현(다중 상속) 지원

**인터페이스 멤버 변수**
- **public, static, final**이 모두 포함되었다고 간주
  - final은 변수 값을 한번 설정하면 수정 불가능
- **static final**을 이용하여 정적이며 수정 불가능한 변수 = **상수**
  - 상수는 관례상, 대문자에 언더바로 구분 (ex-MY_PI)
```java
public interface InterfaceAnimal {
    //public static final int MY_PI = 3.14;
    int MY_PI = 3.14;
}
```
- 두 MY_PI는 동일하며 아래와 같이 public static final을 생략하는 것을 권장
- 인스턴스와 무관하게 생성된 상수: 값이 변하지도 않고 공유하며 사용 가능한 변수
- 인터페이스는 상속이 아니라 **구현**

```java
package hyerim.section12.ex5;

public class Dog implements InterfaceAnimal {

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("개 이동");
    }
}
```
- 상속 받을 땐 `extends` 키워드 사용
- 인터페이스 구현 시, `implements` 키워드 사용

**클래스, 추상클래스, 인터페이스는 모두 동일**
- 제약이 추가되는 것
- 자바에서 순수 추상 클래스라는 용어는 없음 → **인터페이스**로 사용

**상속 vs. 구현**
- 상속: 부모 기능을 자식이 물려 받음
- 구현: 인터페이스를 구현
  - 인터페이스는 모든 메서드가 추상 메서드
  - 기능을 물려 받는 것이 아니라 기능을 자식 클래스에서 오버라이딩하여 구현해야 함
  - 인터페이스는 이름만 있는 설계도

**인터페이스를 사용하는 이유**
- 왜 순수 추상 클래스를 사용하지 않고 인터페이스를 사용??
- **제약**: 인터페이스를 구현해야할 곳에서 반드시 구현해야 한다는 규약을 줌
  - 순수 추상 클래스의 경우, 누군가 실행 가능한 메서드를 끼워 넣을 수 있음
    - 자식은 해당 메서드를 물려받게 됨, 더이상 순수 추상 클래스가 아니게 됨
  - 인터페이스는 다른 메서드를 구현할 수 없음, 비어있는 메서드만 선언할 수 있음
- **다중 구현**: 인터페이스는 부모를 여러명 두는 다중 구현 가능
  - 순수 추상 클래스의 경우, 상속 받는 것이기 때문에 하나만 상속받을 수 있음

### 다중 구현

**자바가 다중 상속을 지원하지 않음**  
- 부모를 하나만 선택할 수 있음
- 두개를 상속받는데 각 부모 클래스에 동일한 이름의 메서드가 있는 경우 .. **다이아몬드 문제**

**인터페이스는 다중 상속 가능**
- 모두 추상 메서드로 이루어져 있기 때문에 가능
- 두 인터페이스에 동일한 이름의 메서드가 있더라도 인터페이스에서는 구현되어 있지 않고 자식 클래스에서만 기능이 구현되어 있음
  - 무엇이 실행되더라도 구현 내용은 자식에만 있기 때문에 항상 동일
- 어차피 자식에 있는 메서드가 호출되는 것이기 때문에 다이아몬드 문제가 발생하지 않음
```java
public class Child implements InterfaceA, InterfaceB
```
- 여러개의 인터페이스 구현 가능: 쉼표로 구분
- 동일한 이름의 메서드는 하나만 구현하면 됨
```java
public class DiamonMain {

    public static void main(String[] args) {
        InterfaceA a = new Child();
        a.methodA();
        a.methodCommon();

        InterfaceB b = new Child();
        b.methodB();
        b.methodCommon();

        Child c = new Child();
        c.methodA();
        c.methodB();
        c.methodCommon();
    }
}
```

**메모리 구조**
`InterfaceA a = new Child();`든 `Interface b = new Child();`든  
메모리 상에 Child, InterfaceA, InterfaceB가 모두 생성됨
- 결국 어디서 호출하든 오버라이딩 된 Child의 methodCommon()이 호출됨

### 클래스와 인터페이스 활용

**클래스 상속과 인터페이스 구현을 동시 사용**
```java
public class Bird extends AbstractAnimal implements Fly {
```
- `extends`, `implements`를 동시 사용하는 경우에는 `extends` 먼저 사용
- 인터페이스는 여러개 구현할 수 있음
- Bird의 경우
  - 메모리에 Fly도 있고 AbstractAnimal도 있음
  - 두 클래스 및 인스턴스의 추상 메서드를 Bird에서 구현하여 사용