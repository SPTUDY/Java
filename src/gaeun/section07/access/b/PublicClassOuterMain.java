package gaeun.section07.access.b;

import gaeun.section07.access.a.PublicClass;

public class PublicClassOuterMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();

        // 다른 패키지 접근 불가
        // DefaultClass1 defaultClass1 = new DefaultClass1();
    }
}
