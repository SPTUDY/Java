## 패키지

많은 기능이 있어서 다양한 클래스가 존재하는 프로그램
- 분류해서 관리 필요
- 파일을 분류하기 위해 **폴더 기능**을 제공
- `패키지`라고 함  

코드 첫줄에 파일이 위치한 package 위치를 작성해야 함
```java
package hyerim.section06;
```  

생성자에 `public` 사용하면 다른 패키지에서 해당 파일의 생성자 호출 가능
- 접근 제어자 관련 내용
```java
package hyerim.section06;

public class PackageMain1 {
    public static void main(String[] args) {
        Data data = new Data();
        hyerim.section06.a.User user = new hyerim.section06.a.User();
    }
}
```
- 사용자와 같은 패키지에 소속: 패키지 경로 생략 가능
- 사용자와 다른 위치: **패키지 전체 경로를 포함**하여 클래스 적어주어야 함

## import

```java
package hyerim.section06;
import hyerim.section06.a.User;

public class PackageMain2 {
    public static void main(String[] args) {
        Data data = new Data();
        User user = new User();
    }
}
```
- 패키지 전체 경로 적을 필요 없이 import를 통해 간단하게 작성할 수 있음
- 하나의 패키지 안에 여러 클래스를 import하고자 할 때...
```java
import hyerim.section06.a.*;
```
- `*`을 통해 패키지 안의 모든 클래스를 패키지명 생략하고 사용 가능
- hyerim.section06.a 안의 모든 클래스를 import

### 클래스 이름 중복

클래스 이름이 같더라도 **패키지 이름**으로 구분하여 같은 이름의 클래스 사용 가능
```java
package hyerim.section06;

public class PackageMain3 {
    public static void main(String[] args) {
        hyerim.section06.a.User userA = new hyerim.section06.a.User();
        hyerim.section06.b.User userB = new hyerim.section06.b.User();
    }
}
```
- 만약 실제 코드에서 이름이 겹치는 경우
  - 자주 사용하는 클래스를 import
  - 자주 사용하지 않는 클래스르 **경로로 명시**
```java
package hyerim.section06;

import hyerim.section06.a.User;

public class PackageMain3 {
    public static void main(String[] args) {
        User userA = new User();
        hyerim.section06.b.User UserB = new hyerim.section06.b.User();
    }
}
```
- a.User을 자주 사용하고 b.User을 가끔 사용하는 경우 위와 같이 작성

## 패키지 규칙

- 패키지의 이름과 위치는 폴더(디렉토리) 위치와 같아야 함
- **소문자** 사용
- 회사의 도메인 이름을 거꾸로 사용
  - 예를 들어 `com.company.myapp`: com의 company의 myapp → 점점 세부개념

### 패키지와 계층 구조
- a
  - b
  - c  
  
`a`,`a.b`,`a.c` 세개의 패키지 존재
- 세개의 패키지는 서로 완전히 다른 패키지
- 만약 `a` 패키지에서 `a.b` 패키지의 클래스가 필요하다면 **import**해서 사용 → 반대도 마찬가지
  
패키지를 구성할 때 관련된 `패키지` or `클래스`끼리 묶기