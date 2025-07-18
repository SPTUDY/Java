## final 변수와 상수

`final`: 끝이라는 뜻, 변수에 final 키워드가 붙으면 **더이상 값 변경 불가능**
- 클래스와 메서드, 변수에 붙일 수 있음
  
### final 지역 변수

- 최초 한번만 값 할당 가능: 한번 더 변수 값을 바꾸게 되면 (즉, 대입) **컴파일 오류 발생**
- 메서드의 매개변수에도 final이 붙게 되면, 메서드 내부에서 값을 변경할 수 없음
  - 메서드 호출 시점부터 사용이 끝날 때까지 같은 값으로 사용됨

### final 필드 (멤버 변수)

- 쿨래스 안에 멤버변수를 파이널로 선언하면 **생성자**를 통해 값을 넣어줘야 함
- 초기값을 이미 넣은 경우에는 생성자에서 파이널 멤버변수 값 변경하는 것이 불가능
- 이미 할당된 값이기 때문에 생성자 내부에서 값을 변경할 수 없음 → 컴파일 오류

### final 지역 변수 vs. 멤버 변수

**지역 변수**   
  
**멤버 변수**  
- 필드에서 초기화 하는 것은 어떤 짓을 해도 바뀌지 않음
- 모든 인스턴스마다 동일한 값을 가짐
- 생성자 코드와 달리 이미 코드에 어떤 값인지 박혀있음 → 인스턴스마다 동일한 값
- 같은 값이 중복되어 사용됨 → static 영역(공유하는 영역)으로 해결
  - `static final`로 중복과 메모리 비효율 문제 해결 

## 상수

상수: 변하지 않고 항상 일정한 값을 가짐
- static final 키워드 사용
- 대문자
- 언더바로 변수명 적음  

상수는 기능이 아닌 숫자 자체를 사용하려는 목적이 대부분  
- 필드에 직접 접근하더라도 상수 변경이 불가능 → 자바 컴파일러에서 막음

자주 사용하는 상수(수학, 시간 등..)는 상수로 셋팅해두고 사용
- 코드의 중복을 줄일 수 있음
- 주로 애플리케이션에서 전반에서 사용되기 때문에 접근제어자 public
- 상수는 실행되는 도중에 변경 불가능

상수 값을 숫자로 쓰지 않고 클래스의 멤버변수로 주어 사용하면
- 이름이 있기 때문에 개발자 입장에서 이해하기 쉬움: 변수명으로 코드 이해 쉬워짐
- 상수 값을 변경(프로그램이 실행되지 않을 때)할 때, 한군데만 변경하면 됨

## final 변수와 참조

- final은 변수의 값을 변경 불가능
- 기본형 변수: 값 변경 불가능
- 참조형 변수: 참조값 변경 불가능
  - 참조 대상의 값은 변경 가능
  - 참조값 자체를 final로 선언했기 때문

### final을 사용하는 경우

- 아이디와 같이 절대 변하지 않는 값
- 값을 변경하고자 하면 **컴파일 오류** 발생하여 변경을 막아줌