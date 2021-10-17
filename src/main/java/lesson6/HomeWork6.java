package lesson6;

import lesson6.animals.Animal;
import lesson6.animals.Cat;
import lesson6.animals.Dog;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
 */

public class HomeWork6 {
    public static void main(String[] args) {
        Dog dog = new Dog("Bobik", 10);
        Cat cat = new Cat("Barsik", 12);

        cat.run(20);
        cat.swim(100);
        dog.run(450);
        dog.swim(10);

        System.out.println(Dog.getCountAnimal());
        System.out.println(Cat.getCountAnimal());
        System.out.println(Animal.getCountAnimal());
    }
}
