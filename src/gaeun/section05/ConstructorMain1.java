package gaeun.section05;

public class ConstructorMain1 {
    public static void main(String[] args) {
        MemberConstructor member1 = new MemberConstructor("user1", 15, 90);
        MemberConstructor member2 = new MemberConstructor("user2", 16, 80);

        MemberConstructor[] members = {member1, member2};

        for (MemberConstructor s : members) {
            System.out.println("이름: " + s.name + " 나이: " + s.age + " 성적: " + s.grade);
        }
    }
}
