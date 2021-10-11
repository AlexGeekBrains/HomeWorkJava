package lesson5;

public class HomeWork5 {

    /*    4. Создать массив из 5 сотрудников.     */

    public static void main(String[] args) {
        Employee[] employeeArr = new Employee[5];
        employeeArr[0] = new Employee("Viktor", "Rustavili", "Engineer",
                "892@mail.ru", "89161112345", 250000, 36);
        employeeArr[1] = new Employee("Ivan", "Danko", "Driver",
                "14818@mail.ru", "+79164785241", 90000, 45);
        employeeArr[2] = new Employee("Vladimir", "Sidorov", "Security",
                "Sid@mail.ru", "+79166987412", 80000, 39);
        employeeArr[3] = new Employee("Svetlana", "Pushkina", "assistant manager",
                "Sv@mail.ru", "+79163332221", 100000, 28);
        employeeArr[4] = new Employee("Elena", "Fedorova", "accountant",
                "acdc@mail.ru", "+79162369874", 150000, 41);

        employeeArr[2].setAge(49);

/*5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.*/
        for (int i = 0; i < employeeArr.length; i++) {
            if (employeeArr[i].getAge() > 40) {
                employeeArr[i].employeeInfo();
            }
        }
    }

}
