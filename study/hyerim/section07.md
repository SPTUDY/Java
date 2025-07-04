## 접근 제어자

- `public`, `static`과 같은 접근 제어자 (access modifier)
- 접근 제어자를 통해 해당 클래스 외부로부터 필드나 메서드에 접근하는 것을 허용 또는 제한 가능
- 예제: 스피커 개발 | 스피커 음량 100 넘어가면 안된다는 제약사항
  - 스피커 음량 조절 및 현재 음량 확인 기능 제공
  - 직접 접근하여 100 이상으로 대입할 수 있음
    ```java
    Speaker speaker = new Speaker(90);
    //필드에 직접 접근
    System.out.println("volume 필드 직접 접근");
    speaker.volume = 200;
    speaker.showVolume();
    ```
- Speaker 객체를 사용하는 사용자는 volume 필드와 관련 메서드에 접근할 수 있음
  - 직접 접근해서 수정이 가능
  - Volume 필드의 외부 접근을 막는 방법 필요
  - **private** 이용
      ```java
      private int volume;
      ```
  - private로 선언했는데 외부에서 접근하고자 하면 **컴파일 오류**
  
## 접근 제어자 종류

- `private`: 모든 외부 호출을 막음
- `default`(package-private): 같은 패키지 안에서 호출 허용
  - 아무것도 적지 않으면 `default`
- `protected`: 같은 패키지 호출 허용, 패키지가 달라도 상속 관계 호출 허용
- `public`: 모든 외부 호출 허용
- `private` → `default` → `protected` → `public` 순으로 많이 허용
  - `public`이 가장 많이 허용
  
**package-private**
- 접근 제어자를 명시하지 않는 경우 `default`로 적용됨
  
**접근 제어자 사용 위치**
- 필드, 메서드, 생성자에 사용
- 클래스 레벨에도 사용되기도 함
- **지역변수에는 사용 불가능**
  
**접근 제어자 특성**
- 속성과 기능을 외부로부터 숨김
  
## 접근 제어자 사용 - 필드, 메서드
**패키지 위치** 매우 중요 !!

```java
package hyerim.section07.access.a;

public class AccessData {
    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod() {
        System.out.println("publicMethod 호출: " + publicField);
    }

    void defaultMethod() {
        System.out.println("defaultMethod 호출: " + defaultField);
    }

    private void privateMethod() {
        System.out.println("privateMethod 호출: " + privateField);
    }

    public void innerMethod() {
        publicField = 100;
        defaultField = 200;
        privateField = 300;
        publicMethod();
        defaultMethod();
        privateMethod();
    }
}
```
  - `innerMethod()`: 자기 자신에게 접근
    - `private`을 포함한 모든 접근 제어자에 접근 가능
    

  - 해당 클래스 (AccessData) 외부, 같은 패키지(access.a)에 존재하는 `AccessInnerMain`
    - 같은 패키지에 존재하기 때문에 `default` 호출 가능  
    - AccessInnerMain에서 `innerMethod()`를 호출할 수 있음
      - `innerMethod()`는 public
      - `innerMethod()`를 호출하면 본인 내부에 있는 모든 접근 제어자에 접근 가능
  

  - 해당 클래스 (AccessData) 외부, 다른 패키지(access.b)에 존재하는 `AccessOuterMain`
    - 다른 패키지에 존재하기 때문에 `default` **호출 불가능**
    - `AccessOuterMain`에서 `innerMethod()`를 호출할 수 있음 (public이므로)
  
## 접근 제어자 사용 - 클래스 레벨

### 클래스레벨의 접근 제어자 규칙

- `public`, `default`만 사용할 수 있음
- `public` 클래스는 반드시 **파일명과 동일**해야 함
- 하나의 자바 파일에 `public` 클래스는 하나만 존재
- `default` 클래스는 무한정 만들 수 있음
  

- 같은 패키지에서 → `public` `default` 서로 접근 가능
- 다른 패키지에서 → `public` 접근 가능 / `default` 접근 불가능
  - `public` 다른 패키지에서 접근하려면 **import**
- **패키지 위치를 맞춰줘야 함 !!**

## 캡슐화 encapsulation

속성과 기능을 하나로 묶고 외부에서 접근을 제한
- 데이터의 직접적인 변경을 방지하거나 제한
- 외부에 꼭 필요한 기능만 노출하고 나머지는 내부로 숨김
  
### 데이터를 숨겨라

객체 내부의 데이터를 외부에서 접근하도록 두면, 데이터 다루는 로직을 무시하고 직접 변경 가능해짐
- 예를 들어 Speaker 객체의 볼륨은 100 이하로 유지되어야 하는데, 200으로 직접 변경  

**객체의 데이터는 객체가 제공하는 기능인 *메서드*를 통해 접근해야 함**

### 기능을 숨겨라

외부에서 사용하지 않고 내부에서만 사용하는 기능은 감추는 것이 좋음
- 사용자가 알 필요가 없는 기능은 내부로 숨기기

데이터는 **모두 숨기고**, 기능은 **꼭 필요한 기능만 노출**

**예제** - BankAccount, BankAccountMain
- `private`: balance, isAmountValid()
  - 데이터필드 balance는 외부에 노출하지 않음 → BankAccount가 제공하는 메서드를 통해서만 접근
  - 입력 금액을 검증하는 기능 isAmountValid()는 내부에서말 필요한 기능
- `public`: deposit(), withdraw(), getBalance()  

사용자는 입금, 출금, 잔액확인 기능만 알면 됨
- 만약 isAmountValid()를 외부로 노출하면 매번 검증 여부를 고민하게 됨
- 만약 balance를 외부로 노출하면 외부에서 사용할 수 있다고 판단하여 직접 사용