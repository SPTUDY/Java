# Section 10. 상속

## 상속

- 기존 클래스의 필드와 메서드를 새로운 클래스에서 재사용하게 해준다.
- 기존 클래스의 속성과 기능을 그대로 물려받는 것이다.
- `extends` 키워드를 사용하면 된다.
    - `extends` 대상은 하나만 선택할 수 있다.
- 용어
    - 부모 클래스 (슈퍼 클래스)
        - 상속을 통해 자신의 필드와 메서드를 다른 클래스에 제공하는 클래스
    - 자식 클래스 (서브 클래스)
        - 부모 클래스로부터 필드와 메서드를 상속받는 클래스

## 상속과 메모리 구조

- 상속 관계를 사용하면 부모 클래스도 함께 포함해서 생성된다.
    - 내부에서 부모와 자식이 모두 생성되고 공간이 구분된다.
- 상속 관계의 객체를 호출 할 때  대상 타입을 정해야 한다.
- 변수의 타입(클래스)을 기준으로 호출한다.
    - 해당 기능이 없으면 부모 타입으로 올라가서 찾는다.
        - 그래도 없으면 컴파일 오류가 발생한다.

## 상속과 메서드 오버라이딩

- **오버라이딩**
    - 부모에게 상속받은 기능을 자식이 재정의하는 것이다.

        ```java
        public class ElectricCar extends Car {
        	@Override
        	public void move() {
        		System.out.println("전기차를 빠르게 이동합니다.");
        	}
        	public void charge() {
        		System.out.println("충전합니다.");
        	}
        }
        ```

    - `@Override`
        - `@` : 애노테이션, 프로그램이 읽을 수 있는 특별한 주석
        - 상위 클래스의 메서드를 오버라이드 하는 것임을 나타낸다.
        - 메서드 위에 애노테이션을 작성한다.
        - 오버라이딩 조건을 만족하지 않으면 컴파일 에러를 발생하므로 실수로 오버라이딩을 못 하는 경우를 방지한다.
        - 코드의 명확성을 위해 작성하는 것이 좋다.
- **(+) 오버로딩과 오버라이딩**
    - **메서드 오버로딩**
        - 메서드 이름이 같고 매개변수(파라미터)가 다른 메서드를 여러 개 정의하는 것이다.
    - **메서드 오버라이딩**
        - 하위 클래스에서 상위 클래스의 메서드를 재정의하는 과정을 의미한다.
- **메서드 오버라이딩 조건**
    - 메서드 이름이 같아야 한다.
    - 매개변수(파라미터) 타입, 순서, 개수가 같아야 한다.
    - 반환 타입이 같아야 한다.
        - 반환 타입이 하위 클래스 타입일 수 있다.

            ```java
            // 반환 타입 예외: 공변 반환 타입
            
            class Animal {}
            
            class Dog extends Animal {}
            
            class Parent {
                Animal getPet() {
                    return new Animal();
                }
            }
            
            class Child extends Parent {
                @Override
                Dog getPet() {
                    return new Dog(); // ✅ 가능: Dog는 Animal의 하위 타입
                }
            }
            ```

    - 오버라이딩 메서드의 접근 제어자는 상위 클래스의 메서드보다 더 제한적이어서는 안된다.
        - 상위 클래스 메서드가 `protected`로 선언된 경우, `public`이나 `protected`로 오버라이드할 수 있지만, `private`이나 `default`로는 오버라이드할 수 없다.
    - 오버라이딩 메서드는 상위 클래스의 메서드보다 더 많은 체크 예외를 throws로 선언할 수 없다.
        - 하지만 더 적거나 같은 수의 예외, 또는 하위 타입의 예외는 선언할 수 있다.
    - `static`, `final`, `private` 키워드가 붙은 메서드는 오버라이딩 될 수 없다.
        - static은 클래스 레벨에서 작동하므로 인스턴스 레벨에서 사용하는 오버라이딩은 의미가 없다.
        - final 메서드는 재정의를 금지한다.
        - private 메서드는 해당 클래스에서만 접근 가능하기 때문에 오버라이딩 할 수 없다.
    - 생성자는 오버라이딩 할 수 없다.

## super

- `super` 키워드를 사용하면 부모를 참조할 수 있다.

    ```java
    public class Child extends Parent {
        public String value;
    
        @Override
        public void hello() {
            System.out.println( "Child.hello");
        }
    
        public void call(){
            System.out.println("this value = " + this.value);
            System.out.println("super value = " + super.value);
    
            this.hello(); // this 생략 가능
            super.hello();
        }
    }
    
    ```


### 생성자

- 상속 관계를 사용하면 자식 클래스의 생성자에서 부모 클래스의 생성자를 반드시 호출해야 한다.
    - 부모의 생성자 호출: `super(…)`
    - 자식은 생성자 첫 줄에 `super(…)` 을 사용해서 부모 클래스의 생성자를 호출해야 한다.
        - `this(…)`를 사용할 수 있다.
            - `super(…)` 은 자식의 생성자에서 반드시 호출해야 한다.
    - 부모 클래스의 생성자가 기본 생성자인 경우는 `super()`을 생략할 수 있다.

