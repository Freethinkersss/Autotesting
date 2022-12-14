/*•Создать класс Person
•В нём: объявить три строковых поля name, middleName, familyName
•Описать конструктор, при помощи которого заполняются поля
•Реализовать геттеры и сеттеры для полей
•Добавить метод toString
•После этого написать небольшую программу с использованием этого класса
•В класс Person добавить поле age
•Реализовать геттер и сеттер для поля age
•Сделать метод для получения года рождения человека
•В классе Main создать объект класса Person, установить ему значение поля age и вывести на экран год рождения человека*/

package OOP;

import java.time.LocalDate;

public class Person {
    private String name;
    private String middleName;
    private String familyName;
    private int age;

    public Person (String name, String middleName, String familyName, int age) {
        this.name = name;
        this.middleName = middleName;
        this.familyName = familyName;
        this.age = age;
    }

    public String getName () {
        return name;
    }

    public String getMiddleName () {
        return middleName;
    }

    public String getFamilyName () {
        return familyName;
    }

    public int getAge () {
      return age;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setMiddleName (String middleName) {
        this.middleName = middleName;
    }

    public void setFamilyName (String familyName) {
        this.familyName = familyName;
    }

    public void setAge (int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "[" + familyName + " " + name + " " + middleName + ". Возраст - " + age + "]";
    }

    public int getBirthYear() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        return year - age;
    }
}
