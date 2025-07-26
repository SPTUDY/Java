# Section13. 다형성과 설계

## 객체 지향

- 특징
    - 추상화
    - 캡슐화
    - 상속
    - 다형성
- 객체 지향 프로그래밍
    - 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러 개의 독립된 단위(객체)들의 모임으로 파악하고자 하는 것이다.
        - 각각의 객체는 메시지를 주고 받고, 데이터를 처리할 수 있다.
    - 프로그램을 유연하고 변경이 용이하게 만들기 때문에 대규모 소프트웨어 개발에 많이 사용된다.
        - 유연하고 변경이 용이하다는 것은 컴포넌트를 쉽고 유연하게 변경 가능한 것을 말한다.

## 다형성

- 다형성을 실세계에 비유하면 세상을 역할과 구현으로 구분한다.
    - 장점
        - 클라이언트는 대상의 역할(인터페이스)만 알면된다.
        - 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
        - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
        - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.
    - `역할 = 인터페이스`, `구현 = 인터페이스를 구현한 클래스, 구현 객체`
        - 객체 설계시 역할과 구현을 명확히 분리한다.
        - 객체 설계시 역할(인터페이스)을 먼저 부여하고, 그 역할을 수행하는 구현 객체를 만든다.
    - 객체의 협력 관계부터 생각해야 한다.
        - 혼자 있는 개체는 없다.
        - 수 많은 객체 클라이언트(요청)와 객체 서버(응답)는 서로 협력 관계를 가진다.
    - 오버라이딩
        - 다형성으로 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.
        - 클래스 상속 관계도 마찬가지다.
- 다형성의 본질
    - 인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다.
    - 다형성의 본질을 이해하려면 협력이라는 개체 사이의 관계에서 시작해야한다.
    - 클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.

## 자동차 예제

```java
public class Driver {
    private K3Car k3Car;
    private Model3Car model3Car;

    public void setK3Car(K3Car k3Car) {
        this.k3Car = k3Car;
    }

    public void setModel3Car(Model3Car model3Car) {
        this.model3Car = model3Car;
    }

    public void drive() {
        System.out.println("자동차를 운전합니다.");
        if (k3Car != null) {
            k3Car.startEngine();
            k3Car.pressAccelerator();
            k3Car.offEngine();
        } else if (model3Car != null) {
            model3Car.startEngine();
            model3Car.pressAccelerator();
            model3Car.offEngine();
        }

    }
}
```

```java
public class K3Car {
    public void startEngine() {
        System.out.println("K3Car.startEngine");
    }
    public void offEngine() {
        System.out.println("K3Car.offEngine");
    }
    public void pressAccelerator() {
        System.out.println("K3Car.pressAccelerator");
    }
}
```

```java
public class Model3Car {
    public void startEngine() {
        System.out.println("Model3Car.startEngine");
    }
    public void offEngine() {
        System.out.println("Model3Car.offEngine");
    }
    public void pressAccelerator() {
        System.out.println("Model3Car.pressAccelerator");
    }
}
```

```java
public class CarMain0 {
    public static void main(String[] args) {
        Driver driver = new Driver();
        K3Car k3Car = new K3Car();

        driver.setK3Car(k3Car);
        driver.drive();

        // 추가
        Model3Car model3Car = new Model3Car();
        driver.setK3Car(null);
        driver.setModel3Car(model3Car);
        driver.drive();
    }
}
```

- 새로운 차량을 추가하려면 기존 Driver 코드를 변경해야 하는 문제점이 있다.
    - Driver는 차 종류에 종속되지 않고, 차를 운전할 수 있어야 한다.

- 다형성을 활용하면 역할과 구현을 분리해서, 클라이언트 코드의 변경 없이 구현 객체를 변경할 수 있다.

```java
public interface Car {
    void startEngine();
    void offEngine();
    void pressAccelerator();
}
```

```java
public class K3Car implements Car {

    @Override
    public void startEngine() {
        System.out.println("K3Car.startEngine");
    }

    @Override
    public void offEngine() {
        System.out.println("K3Car.offEngine");
    }

    @Override
    public void pressAccelerator() {
        System.out.println("K3Car.pressAccelerator");
    }
}

```

```java
public class Driver {
    private Car car;

    public void setCar(Car car) {
        System.out.println("자동차를 설정합니다.");
        this.car = car;
    }

    public void drive() {
        System.out.println("자동차를 운전합니다.");
        car.startEngine();
        car.pressAccelerator();
        car.offEngine();
    }
```

```java
public class Car1Main {
    public static void main(String[] args) {
        Driver driver = new Driver();

        // 차량 선택 (k3)
        K3Car k3Car = new K3Car();
        driver.setCar(k3Car);
        driver.drive();

        // 차량 변경 (k3 -> model3)
        Model3Car model3Car = new Model3Car();
        driver.setCar(model3Car);
        driver.drive();

        // 차량 변경 (model3 -> newCar)
        NewCar newCar = new NewCar();
        driver.setCar(newCar);
        driver.drive();
    }
}

```

- Car을 사용하는 클라이언트 코드인 Driver 코드의 변경없이 새로운 자동차를 확장하였다.

## OCP (Open-Closed Principle) 원칙

- Open for extension
    - 새로운 기능의 추가나 변경 사항이 생겼을 때, 기존 코드는 확장할 수 있어야 한다.
- Closed for modification
    - 기존의 코드는 수정되지 않아야 한다.

## 전략 패턴

- 알고리즘을 클라이언트 코드의 변경 없이 쉽게 교체할 수 있다.
- Car의 인터페이스가 전략을 정의하는 인터페이스가 되고, 각각의 차량이 전략의 구체적인 구현이 된다.
- 전략을 클라이언트 코드(Driver)의 변경 없이 쉽게 교체할 수 있다.