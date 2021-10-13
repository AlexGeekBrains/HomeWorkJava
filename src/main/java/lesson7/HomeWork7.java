package lesson7;

public class HomeWork7 {
    public static void main(String[] args) {

        Plate plate = new Plate(5);

        /*
        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
         и потом вывести информацию о сытости котов в консоль. (сытость котов добавил метод info, в цикле указал,
         если коту не хватает еды, то мы досыпаем в миску порцию еды равную кошачьему аппетиту)
         */

        Cat[] catArr = new Cat[5];

        catArr[0] = new Cat("Barsik");
        catArr[1] = new Cat("Tishka");
        catArr[2] = new Cat("Musya");
        catArr[3] = new Cat("Belka");
        catArr[4] = new Cat("Bob");

        plate.increaseFood(catArr[1]);

        for (int i = 0; i < catArr.length; i++) {
            if (plate.getFood() >= catArr[i].getAppetite()) {
                catArr[i].eat(plate);
                catArr[i].info();
            } else {
                plate.increaseFood(catArr[i]);
                catArr[i].eat(plate);
                catArr[i].info();
            }
        }

    }
}
