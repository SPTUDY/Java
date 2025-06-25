package hyerim.section02;

public class ClassStart2 {
    public static void main(String[] args) {
        String[] studentName = {"학생1", "학생2"};
        int[] studentAge = {15, 16};
        int[] studentGrade = {90, 80};

        for (int i = 0; i < studentName.length; i++) {
            System.out.print("이름: "+studentName[i]);
            System.out.print(", 나이: " +studentAge[i]);
            System.out.print(", 성적: " +studentGrade[i]);
            System.out.println();
        }
    }
}