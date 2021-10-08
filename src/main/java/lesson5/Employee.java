package lesson5;

/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 */
public class Employee {
    private String name;
    private String surname;
    private String post;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    /*
    2. Конструктор класса должен заполнять эти поля при создании объекта.
     */
    public Employee(String name, String surname, String post, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    /*3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.*/

    public void employeeInfo() {
        System.out.println("Имя " + name + " Фамилия " + surname + " должность " + post + " Email " + email + " телефон "
                + phoneNumber + " зарплата " + salary + " возраст " + age);
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public void setAge(int age) {
        if (age > 18 && age < 99) {
            this.age = age;
        } else {
            System.out.println("Введен некорректный возраст");
        }

    }
}
