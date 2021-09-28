package lesson2;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println(checkNumbers(10, 5));
        checkPositiveNegative(4);
        System.out.println(checkNumberNegative(-2));
        printWord("проверка", 4);
        System.out.println(checkLeapYear(4));
    }
    /*
    Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.
     */
    public static boolean checkNumbers(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }
    /*Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
     */
  public static void checkPositiveNegative(int a) {
        System.out.println(a<0 ? "отрицательное": "положительное" );
    }


    /* Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное,
     и вернуть false если положительное. */
    public static boolean checkNumberNegative(int a) {
        return (a <0);
    }
    /* Написать метод, которому в качестве аргументов передается строка и число,
      метод должен отпечатать в консоль указанную строку, указанное количество раз;*/
    public static void printWord(String word, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(word);
        }
    }
    /* Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
    не високосный - false). Каждый 4-й год является високосным,
     кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean checkLeapYear(int year){
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
    }
}


