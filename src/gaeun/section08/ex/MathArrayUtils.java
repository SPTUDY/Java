package gaeun.section08.ex;

public class MathArrayUtils {
    private MathArrayUtils() {} // 인스턴스 생성 방지

    static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    static double average(int[] values) {
        return sum(values) / values.length;
    }

    static int min(int[] values) {
        int min = values[0];
        for (int value : values) {
            min = Math.min(min, value);
        }
        return min;
    }

    static int max(int[] values) {
        int max = values[0];
        for (int value : values) {
            max = Math.max(max, value);
        }
        return max;
    }
}
