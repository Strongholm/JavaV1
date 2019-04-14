/**
 * Домашняя работа к уроку 5 Java 1
 *
 * @author Андрей Семенюк
 * @version 14.04.2019
 */

//* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//* Конструктор класса должен заполнять эти поля при создании объекта;
//* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
//* Создать массив из 5 сотрудников
//  Пример:
//  Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//  persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
//  потом для каждой ячейки массива задаем объект
//  persArray[1] = new Person(...);
//  ...
//  persArray[4] = new Person(...);
//
//* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

public class Homework_5 {

    public static void main(String[] args) {

        Person[] arrPerson = new Person[5];
        arrPerson[0] = new Person("Ivanov Ivan Ivanovich", "Director",
                "ivanovii@mail.ru", "111-111", 100000, 42);

        arrPerson[1] = new Person("Petrov Petr Petrovich", "Storekeeper",
                "petrovpp@mail.ru", "222-222", 50000, 35);

        arrPerson[2] = new Person("Sidorov Sidor Sidorovich", "Manager",
                "sidorovss@mail.ru", "333-333", 35000, 39);

        arrPerson[3] = new Person("Vladimirov Vladimir Vladimirovich", "Manager",
                "vlsdimirovvv@mail.ru", "444-444", 35000, 45);

        arrPerson[4] = new Person("Semenov Semen Semenovich", "Manager",
                "semenovss@mail.ru", "555-555", 35000, 29);

        for (int i = 0; i<arrPerson.length; i++) {
            if (arrPerson[i].getAge() > 40) {
                arrPerson[i].showPerson();
            }
        }
    }

    static class Person {

        private String name;
        private String position;
        private String email;
        private String phone;
        private int salary;
        private int age;

        public Person(String name, String position, String email, String phone, int salary, int age) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        public void showPerson() {
            System.out.println(
                    this.name +
                            "\n Position: " + this.position +
                            "\n Email: " + this.email +
                            "\n Phone: " + this.phone +
                            "\n Salary: " + this.salary +
                            "\n Age: " + this.age);
        }
    }
}