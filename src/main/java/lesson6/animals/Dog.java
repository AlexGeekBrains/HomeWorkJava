package lesson6.animals;

import lesson6.animals.Animal;

public class Dog extends Animal {
    private static int countDog;

    public static int getCountAnimal() {
        return countDog;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        countDog++;
        countAnimal++;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength >= 0 && obstacleLength <= 500) {
            System.out.println(name + " пробежал " + obstacleLength + " метров");
        } else if (obstacleLength < 0) {
            System.out.println("Вы ввели неверное значение");
        } else {
            System.out.println("Собака не может пробежать более 500 метров");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        if (obstacleLength >= 0 && obstacleLength <= 10) {
            System.out.println(name + " проплыл " + obstacleLength + " метров");
        } else if (obstacleLength < 0) {
            System.out.println("Вы ввели неверное значение");
        } else {
            System.out.println("Собака не может пробежать более 10 метров");
        }

    }
}
