package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        if (food > 0) {
            this.food = food;
        } else {
            System.out.println("введено не верное значение");
        }
    }

    //2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).

    public void decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
        } else {
            System.out.println("Еды слишком мало, досыпьте");
        }
    }

    // 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку. (добавление еды завязал на кошачий аппетит)
    public void increaseFood(Cat cat) {
        food += cat.getAppetite();
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.printf("Plate [ Food: %d ]\n", food);
    }
}
