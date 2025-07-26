# Section12. 다형성2

- 동물별 클래스가 있을 때 각 동물이 내는 소리를 테스트하는 코드를 작성해보자.
    1. 새로운 동물이 추가할 때마다 중복 코드가 발생하는 문제

        ```java
        public class AnimalSoundMain {
            public static void main(String[] args) {
                Dog dog = new Dog();
                Cat cat = new Cat();
                Cow cow = new Cow();
        
                System.out.println("동물 소리 테스트 시작");
                dog.sound();
                System.out.println("동물 소리 테스트 종료");
        
                soundCat(cat);
        
                soundCow(cow);
            }
            private static void soundCat(Cat cat) {
                System.out.println("동물 소리 테스트 시작");
                cat.sound();
                System.out.println("동물 소리 테스트 종료");
            }
        
            private static void soundCow(Cow cow) {
                System.out.println("동물 소리 테스트 시작");
                cow.sound();
                System.out.println("동물 소리 테스트 종료");
            }
        }
        
        ```

    2. 상속을 통한 다형적 참조와 메서드 오버라이딩 활용
        1. Animal 클래스

            ```java
            public class Animal {
                public void sound () {
                    System.out.println("동물 울음 소리");
                }
            }
            ```

        2. Dog 클래스

            ```java
            public class Dog extends Animal {
                @Override
                public void sound () {
                    System.out.println("멍멍");
                }
            }
            
            ```

        3. Main

            ```java
            public class AnimalPolyMain3 {
                public static void main(String[] args) {
                    Animal[] AnimalArr = {new Dog(), new Cat(), new Cow(), new Pig()};
                    for (Animal animal : AnimalArr) {
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

            - `private static void soundAnimal(Animal animal)`
                - 다형적 참조를 통해 animal 변수는 자식인 Dog, Cat, Cow의 인스턴스를 참조할 수 있다.
                - 메서드 오버라이딩을 통해 animal.sound()를 호출해도 Dog.sound(), Cat.sound(), Cow.sound()와 같이 각 인스턴스의 메서드를 호출할 수 있다.
    3. 추상 클래스 도입
        - 도입 배경
            - Animal 클래스는 추상적인 개념이므로 생성될 필요가 없다.
                - 추상 클래스를 통해 `Animal` 인스턴스를 생성할 문제를 근본적으로 방지한다.
            - Animal 클래스를 상속 받는 곳에서 sound() 메서드를 오버라이딩하도록 제약을 만들 수 있다.
                - 추상 클래스를 통해 새로운 동물의 자식 클래스를 만들때 `sound()` 를 오버라이딩 하지 않을 문제를 근본적으로 방지한다.
        - 개념
            - **추상 클래스**
                - 부모 클래스는 제공하지만, 실제 생성되면 안 되는 클래스이다.
                - 추상적인 개념을 제공하는 클래스이다.
                - 실체인 인스턴스가 존재하지 않는다.
                - 상속을 목적으로 사용되고, 부모 클래스 역할을 담당한다.
                - 클래스 앞에 `abstract` 키워드를 붙인다.
                - 인스턴스를 생성하지 못하는 제약이 추가된다.
            - **추상 메서드**
                - 부모 클래스를 상속 받는 자식 클래스가 반드시 오버라이딩 해야 하는 메서드를 부모 클래스에 정의할 수 있다.
                - 추상적인 개념을 제공하는 메서드이다.
                - 실체가 존재하지 않고 메서드 바디가 없다.
                - 메서드 앞에 `abstract` 키워드를 붙인다.
                - 추상 메서드가 하나라도 있는 클래스는 추상 클래스로 선언해야 한다.
                - 추상 메서드는 상속 받는 클래스가 반드시 오버라이딩해서 사용해야 한다.
        - 예제

            ```java
            public abstract class AbstractAnimal {
                public abstract void sound();
            
                public void move() {
                    System.out.println("동물이 움직입니다.");
                }
            }
            
            ```

            ```java
            public class Dog extends AbstractAnimal {
                @Override
                public void sound() {
                    System.out.println("멍멍");
                }
            }
            
            ```

            ```java
            public class AbstractMain {
                public static void main(String[] args) {
                    // 추상 클래스 생성 불가
                    // AbstractAnimal animal = new AbstractAnimal();
            
                    Dog dog = new Dog();
                    Cat cat = new Cat();
                    Cow cow = new Cow();
            
                    cat.sound();
                    cat.move();
            
                    soundAnimal(dog);
                    soundAnimal(cat);
                    soundAnimal(cow);
                }
            
                // 변하지 않는 부분
                private static void soundAnimal(AbstractAnimal animal) {
                    System.out.println("동물 소리 테스트 시작");
                    animal.sound();
                    System.out.println("동물 소리 테스트 종료");
                }
            }
            
            ```

    4. 순수 추상클래스
        - 순수 추상 클래스란 클래스의 모든 메서드가 추상 메서드인 경우를 말한다.
            - 자식 클래스는 모든 메서드를 구현해야 한다.
            - 어떤 규격을 지켜서 구현해야 하므로 인터페이스(다음 개념)를 떠올릴 수 있다.
        - 예제

            ```java
            public abstract class AbstractAnimal {
                public abstract void sound();
                public abstract void move();
            }
            ```

            ```java
            public class Dog extends AbstractAnimal {
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

            ```java
            public class AbstractMain {
                public static void main(String[] args) {
                    // 추상 클래스 생성 불가
                    // AbstractAnimal animal = new AbstractAnimal();
            
                    Dog dog = new Dog();
                    Cat cat = new Cat();
                    Cow cow = new Cow();
            
                    cat.sound();
                    cat.move();
            
                    soundAnimal(dog);
                    soundAnimal(cat);
                    soundAnimal(cow);
            
                    moveAnimal(dog);
                    moveAnimal(cat);
                    moveAnimal(cow);
                }
            
                // 변하지 않는 부분
                private static void soundAnimal(AbstractAnimal animal) {
                    System.out.println("동물 소리 테스트 시작");
                    animal.sound();
                    System.out.println("동물 소리 테스트 종료");
                }
            
                // 변하지 않는 부분
                private static void moveAnimal(AbstractAnimal animal) {
                    System.out.println("동물 이동 테스트 시작");
                    animal.sound();
                    System.out.println("동물 이동 테스트 종료");
                }
            }
            
            ```

    5. 인터페이스
        - 개념
            - 순수 추상 클래스를 더 편리하게 사용할 수 있는 기능이다.
            - `interface` 키워드를 사용한다.
            - 메서드는 모두 public, abstract 이므로 public, abstract 키워드를 생략할 수 있다.
            - 다중 구현 (다중 상속)을 지원한다.
            - 인터페이스를 구현하는 클래스는 `implements` 키워드를 사용한다.
        - 인터페이스와 멤버 변수
            - 인터페이스에서 멤버 변수는 public, static, final이 모두 포함되었다고 간주된다.
                - final: 변수의 값을 한 번 설정하면 수정할 수 없다는 뜻이다.
            - 상수: `static final` 을 사용해 정적이면서 고칠 수 없는 변수이다.

            ```java
            public interface InterfaceAnimal {
                  double MY_PI = 3.14;
            }
            ```

        - 인터페이스를 사용하는 이유
            - 인터페이스의 메서드를 반드시 구현하라는 규약(제약)을 주는 것이다.
                - 순수 추상 클래스의 경우 실행 가능한 메서드를 임의적으로 추가할 수 있다.
                    - 인터페이스는 모든 메서드가 추상메서드이므로 이런 문제를 원천 차단한다.
            - 다중 구현(다중 상속)이 가능한다.
        - 예제

            ```java
            public interface InterfaceAnimal {
                void sound(); // public abstract
                void move(); // public abstract
            }
            ```

            ```java
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

            ```java
            public class InterfaceMain {
                public static void main(String[] args) {
                    // 인터페이스 생성 불가
                    // InterfaceAnimal interfaceAnimal = new InterfaceAnimal();
            
                    Cat cat = new Cat();
                    Dog dog = new Dog();
                    Cow cow = new Cow();
            
                    soundAnimal(cat);
                    soundAnimal(dog );
                    soundAnimal(cow);
                }
            
                // 변하지 않는 부분
                private static void soundAnimal(InterfaceAnimal animal) {
                    System.out.println("동물 소리 테스트 시작");
                    animal.sound();
                    System.out.println("동물 소리 테스트 종료");
                }
            }
            ```

    6. 인터페이스 다중 구현
        - `extends` 대상은 하나만 가능한 이유
            - 다중 상속이 가능한 경우 같은 이름의 메서드를 호출할 때 어떤 부모의 메서드를 호출해야 할지 애매해지는 다이아몬드 문제가 발생한다.
        - 인터페이스는 다중 구현이 가능한 이유
            - 모두 추상 메서드로 이루어져 있으므로 결국 자식이 구현한 메서드를 호출한다.
            - 예시

                ```java
                public class Bird extends AbstractAnimal implements Fly, Swim 
                ```

        - 예제

            ```java
            public abstract class AbstractAnimal {
                public abstract void sound();
                public void move() {
                    System.out.println("동물이 이동합니다.");
                }
            }
            ```

            ```java
            public interface Fly {
                void fly();
            }
            ```

            ```java
            public class Bird extends AbstractAnimal implements Fly {
                @Override
                public void sound() {
                    System.out.println("짹짹");
                }
            
                @Override
                public void fly() {
                    System.out.println("새 날기");
                }
            }
            ```

            ```java
            public class SoundFlyMain {
                public static void main(String[] args) {
                    Dog dog = new Dog();
                    Bird bird = new Bird();
                    Chicken chicken = new Chicken();
            
                    soundAnimal(dog);
                    soundAnimal(bird);
                    soundAnimal(chicken);
            
                    flyAnimal(bird);
                    flyAnimal(chicken);
                }
            
                // AbstractAnimal 사용 가능
                private static void soundAnimal(AbstractAnimal animal) {
                    System.out.println("동물 소리 테스트 시작");
                    animal.sound();
                    System.out.println("동물 소리 테스트 종료");
                }
            
                // Fly 인터페이스가 있으면 사용 가능
                private static void flyAnimal(Fly fly) {
                    System.out.println("날기 테스트 시작");
                    fly.fly();
                    System.out.println("날기 테스트 종료");
                }
            }
            
            ```