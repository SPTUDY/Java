package hyerim.section03;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println(bigData.count);
        System.out.println(bigData.data);

        // NullPointerException 예외 발생
        // System.out.println(bigData.data.value);
    }
}
