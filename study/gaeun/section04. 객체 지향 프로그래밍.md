# Section04 객체 지향 프로그래밍

## 프로래밍 방식

- **절차 지향 프로그래밍**
    - 절차를 지향한다.
    - 실행 순서를 중요하게 생각한다.
    - 흐름을 순차적으로 따르며 처리하는 방식이다.
    - 어떻게를 중심으로 프로그래밍한다.
    - **절차 지향은 데이터와 해당 데이터에 대한 처리 방식이 분리되어 있다.**
- **객체 지향 프로그래밍**
    - 객체를 지향한다.
    - 실제 세계의 사물이나 사건을 객체로 보고, 이러한 객체들 간의 상호작용을 중심으로 프로그래밍한다.
    - 무엇을 중심으로 프로그래밍한다.
    - **객체 지향은 데이터와 그 데이터에 대한 행동이 하나의 객체 안에 함께 포함되어 있따.**

## 모듈화

- 하나의 큰 프로그램을 역할별로 나누어 각각을 독립적인 ‘기능 단위(=모듈)’로 만드는 설계 방식이다. 예를 들어 음악 플레이어에서 `volumeUp()`과 같은 기능을 각각 메서드로 분리하면, 필요한 기능만 호출해서 쉽게 조립하듯 사용하고, 수정 시에도 해당 메서드만 고치면 되어 유지보수가 쉬워진다.

## 절차 지향 프로그래밍의 한계

```java
package gaeun.section04;

public class MusicPlayerMain3 {
    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        // 음악 플레이어 켜기
        on(data);

        // 볼륨 증가
        volumeUp(data);

        // 볼륨 증가
        volumeUp(data);

        // 볼륨 감소
        volumeDown(data);

        // 음악 플레이어 상태
        showStatus(data);

        // 음악 플레이어 끄기
        off(data);
    }

    static void on(MusicPlayerData data) {
        System.out.println("음악 플레이어를 시작합니다");
        data.isOn = true;
    }

    static void off(MusicPlayerData data) {
        data.isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }

    static void volumeUp(MusicPlayerData data) {
        data.volume++;
        System.out.println("음악 플레이어 볼륨: " + data.volume);
    }

    static void volumeDown(MusicPlayerData data) {
        data.volume--;
        System.out.println("음악 플레이어 볼륨: " + data.volume);
    }

    static void showStatus(MusicPlayerData data) {
        System.out.println("음악 플레이어 상태 확인");
        if (data.isOn) {
            System.out.println("음악 플레이어 On, 볼륨: " + data.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}

```

- 클래스를 사용해 관련된 **데이터는 한 곳에**, **기능(메서드)은 다른 곳에** 분리해 작성했다. 이 방식은 코드가 깔끔하고 읽기 쉬우며, 모듈화에도 유리하다. 하지만 **데이터와 기능이 분리되어 있다는 점이 한계**다. 기능 대부분이 특정 데이터를 참조하기 때문에, 데이터가 변경되면 관련 기능도 함께 수정해야 하고, 유지보수 관점에서도 관리 포인트가 늘어난다.
- **객체 지향 프로그래밍(OOP)**은 이 문제를 해결하기 위해, **서로 밀접하게 연관된 데이터와 기능을 하나의 객체로 묶어** 함께 다룰 수 있게 한다. 이를 통해 더 응집력 있는 코드 구조를 만들고, 유지보수성과 재사용성을 높일 수 있다.

## 객체 지향 프로그래밍

```java
package gaeun.section04;

public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;

    void on() {
        System.out.println("음악 플레이어를 시작합니다");
        isOn = true;
    }

    void off() {
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }

    void volumeUp() {
        volume++;
        System.out.println("음악 플레이어 볼륨: " + volume);
    }

    void volumeDown() {
        volume--;
        System.out.println("음악 플레이어 볼륨: " + volume);
    }

    void showStatus() {
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 On, 볼륨: " + volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}

```

- MusicPlayer 객체를 생성하고 필요한 기능(메서드)을 호출하기만 하면 된다.
    - MusicPlayer를 사용하는 입장에서는 MusicPlayer 내부에 어떤 속성(데이터)이 있는지 몰라도 된다.
    - MusicPlayer를 사용하는 입장에서는 단순하게MusicPlayer 가 제공하는 기능 중에 필요한 기능을 호출해서 사용하기만 하면 된다.

## 캡슐화

캡슐화란, 속성과 기능을 하나로 묶고, 필요한 기능만 메서드를 통해 외부에 제공하는 객체지향의 핵심 개념이다. 이를 통해 객체의 내부 구현을 숨기고, 외부에서는 정해진 방식으로만 접근하게 하여 안정성과 유지보수성을 높일 수 있다.

