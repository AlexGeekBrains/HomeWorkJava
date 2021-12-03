package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isHungry;
    private boolean isSatiety;

    //3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.

    public Cat(String name) {
        this.name = name;
        this.appetite = 5;
        this.isHungry = true;
        this.isSatiety = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public void info() {
        System.out.println("Name: " + name + ", hungry: " + isHungry + " satiety: " + isSatiety);
    }

    //4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).

    public void eat(Plate plate) {
        if (appetite <= plate.getFood()) {
            plate.decreaseFood(appetite);
            isHungry = false;
            isSatiety = true;
            System.out.println(name + " поел из тарелки");
        } else {
            System.out.println("Кот " + name + " посмотрел на количество еды в миске и дал понять, что ее необходимо наполнить или тапкам хана");
        }
    }
}
