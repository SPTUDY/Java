package hyerim.section03;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        System.out.println("dataA 참조값 = " + dataA);
        System.out.println("dataB 참조값 = " + dataB);
        System.out.println("dataA = " + dataA.value);
        System.out.println("dataB = " + dataB.value);

        dataA.value = 20;
        System.out.println("dataA 변경");
        System.out.println("dataA = " + dataA.value);
        System.out.println("dataB = " + dataB.value);

        dataB.value = 30;
        System.out.println("dataB 변경");
        System.out.println("dataA = " + dataA.value);
        System.out.println("dataB = " + dataB.value);
    }
}
