package OOP;

import java.util.Scanner;

public class MainPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:" );
        String name = scanner.nextLine();

        System.out.println("Введите отчество:" );
        String middleName = scanner.nextLine();

        System.out.println("Введите фамилию:" );
        String familyName = scanner.nextLine();

        System.out.println("Введите возраст:" );
        int age = scanner.nextInt();

        Person person = new Person(name, middleName, familyName, age);

        System.out.println("Год рождения: " + person.getBirthYear());

        System.out.println("Объект класса Person был создан: " + person);

        person.setAge(26);

        System.out.println("Измененный возраст через сеттер - " + person.getAge());
        System.out.println("Новый год рождения: " + person.getBirthYear());
    }
}
