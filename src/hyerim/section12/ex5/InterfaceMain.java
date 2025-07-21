package hyerim.section12.ex5;

public class InterfaceMain {
    public static void main(String[] args) {
        //인터페이스 인스턴스 생성 불가능
        //InterfaceAnimal interfaceAnimal = new InterfaceAnimal();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);

        System.out.println("----------------");

        moveAnimal(dog);
        moveAnimal(cat);
        moveAnimal(cow);
    }

    public static void soundAnimal(InterfaceAnimal animal) {
        System.out.println("동물 소리 시작");
        animal.sound();
        System.out.println("동물 소리 종료");
    }

    public static void moveAnimal(InterfaceAnimal animal) {
        System.out.println("동물 이동 시작");
        animal.move();
        System.out.println("동물 이동 종료");
    }
}
