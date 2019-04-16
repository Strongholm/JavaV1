import java.sql.SQLOutput;

/**
 * Домашняя работа к уроку 6 Java 1
 *
 * @author Андрей Семенюк
 * @version 17.04.2019
 */

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу
// передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
//плавание: кот не умеет плавать, собака 10 м.).
//4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
//(Например, dog1.run(150); -> результат: run: true)
//5.* Добавить животным разброс в ограничениях.
// То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.


abstract class Animal {
    private final int MAX_RUN_LENGTH = 0;
    private final int MAX_SWIM_LENGTH = 0;
    private final double MAX_JUMP_HEIGTH = 0;

    abstract void run(int length);

    abstract void swim(int length);

    abstract void jump(double height);
    }
class Cat extends Animal {
    private final int MAX_RUN_LENGTH = 200;
    private final double MAX_JUMP_HEIGTH = 2;
    @Override
    void run(int length) {
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.println("Cat run: true");
        else System.out.println("Cat run: false");
    }

    @Override
    void swim(int length) {
        System.out.println("Cat swim: false");
    }

    @Override
    void jump(double height) {
        if ((height >= 0) && (height <= MAX_JUMP_HEIGTH)) System.out.println("Cat jump: true");
        else System.out.println("Cat jump: false");
    }
}

 class Dog extends Animal {
    private final int MAX_RUN_LENGTH = 500;
    private final int MAX_SWIM_LENGTH = 10;
    private final double MAX_JUMP_HEIGTH = 0.5;

    @Override
    void run(int length) {
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.println("Dog run: true");
    }

    @Override
    void swim(int length) {
        if ((length >= 0) && (length <= MAX_SWIM_LENGTH)) System.out.println("Dog swim: true");
        else System.out.println("Dog swim: false");
    }

    @Override
    void jump(double height) {
        if ((height >= 0) && (height <= MAX_JUMP_HEIGTH)) System.out.println("Dog jump: true");
        else System.out.println("Dog jump: false");
    }
}

public class Homework_6 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.run(201);
        cat.swim(1);
        cat.jump(1.9);

        Dog dog = new Dog();
        dog.run(500);
        dog.swim(10);
        dog.jump(0.4);
    }
}

// задание привести строку к нормальному ввиду

class MainClassString {
    public static void main(String[] args) {
        String s = "Предложение  один     Теперь предложение    два   Предложение   три";
        String s1 = s.replaceAll(" +", " ");
        StringBuilder s2 = new StringBuilder(s1);

        int count=0;
        for (int i = 1; i < s1.length(); i++) {
            if(s1.charAt(i) >= 'А' && s1.charAt(i) <= 'Я') {
                s2.insert(i-1+count, ".");
                count++;
            }
        }
        s2.append('.');
        System.out.println(s2.toString());
    }
}