package gaeun.section02;

public class ClassStart2 {
    public static void main(String[] args) {
     String[] studentName = {"학생1", "학생2"};
     int[] studentAge = {15, 90};
     int[] studentGrade = {16, 80};
     for (int i = 0; i < studentName.length; i++) {
         System.out.println("이름" + studentName[i] + "나이" + studentAge[i] + "성적" + studentGrade[i]);
     }
    }
}
