package lesson6.animals;

import lesson6.animals.Animal;

public class Cat extends Animal {
    private static int countCat;

    public static int getCountAnimal() {
        return countCat;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        countCat++;
        countAnimal++;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength >= 0 && obstacleLength <= 200) {
            System.out.println(name + " пробежал " + obstacleLength + " метров");
        } else if (obstacleLength < 0) {
            System.out.println("Вы ввели неверное значение");
        } else {
            System.out.println("Кот не может пробежать более 200 метров");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println("Кот не умеет плавать");
    }
}
