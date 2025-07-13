# Section 09. Final

## `final`

- 변수에 final 키워드가 붙으면 더는 값을 변경할 수 ㅇ벗다.
    - `class`,`method` 를 포함한 여러 곳에 붙을 수 있다.

### final 지역변수

- 최초 한 번만 할당 가능하다.
- 선언시 바로 초기화 한 경우 재할당이 불가능하다.
- 매개변수에 final이 붙으면 메서드 내부에서 매개변수의 값을 변경할 수 없다.

```java
public class FinalLocalMain {
    public static void main(String[] args) {
        // final 지역 변수
        final int data1;
        data1 = 10; // 최초 한 번만 할당 가능
        // data1 = 20; // 컴파일 오류

        final int data = 10;
        // data2 = 20; // 컴파일 오류

        method(10);

    }

    static void method(final int parameter) {
         // parameter = 20; 컴파일 오류
    }
}

```

### final 필드 (멤버변수)

- final을 필드에 사용할 경우 해당 필드는 생성자를 통해서 한 번만 초기화될 수 있다.

    ```java
    public class ConstructInit {
        final int value;
    
        public ConstructInit(int value) {
            // 생성자를 통해서 값을 넣어주고 이후에 할당 불가
            this.value = value;
        }
    }
    
    ```

- 이미 final 필드를 초기화했으면 생성자를 통해서 초기화할 수 없다.
    - 이경우 모든 인스턴스가 변경할 수 없는 멤버변수를 갖기 때문에 static을 사용하는 것이 좋다.
        - `static final` : 초기화 값이 변하지 않으며, JVM 상에서 하나만 존재하므로 중복고 ㅏ메모리 비효율 문제를 해결할 수 있다.

            ```java
            public class FieldInit {
                static final int CONST_VALUE = 10;
                final int value = 10; // 생성자로 초기화 불가능
            }
            ```


## 상수

- 변하지 않고 항상 일정한 값을 갖는 수다.
- 단 하나만 존재하는 변하지 않는 고정된 값이다.
- `static final` 키워드를 사용한다.
- 변수명 컨벤션으로 Screaming Snake Case 사용 (ex. `MAX_USERS`)
- 필드로 직접 접근하여 사용된다.
- 보통 애플리케이션 전반에서 사용하므로 `public`을 자주 사용한다.
- 중앙에서 값을 하나로 관리할 수 있다.
- 런타임에 변경할 수 없다.

## final 변수와 참조

- final 변수
    - 기본형 변수
    - 참조형 변수
        - 객체의 참조값을 보관한다.
        - 참조값 최초 초기화시 참조값을 변경할 수 없다.
        - 그러나 참조 대상의 객체 값은 변경할 수 있다.

```java
public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data();
        // data = new Data();

        // 참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
    }
}

```