package lesson6.animals;

public abstract class Animal {
    protected String name;
    protected int age;
    protected static int countAnimal;

    public abstract void run(int obstacleLength);

    public abstract void swim(int obstacleLength);

    public static int getCountAnimal() {
        return countAnimal;
    }
}

