package HW5;

import java.util.Scanner;

public class Student {
    // Создать класс, спецификация которого приведена ниже.
// Определить конструкторы и методы setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль.
// В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
//Student: id, Фамилия, Имя, Отчество, Год рождения, Адрес, Телефон, Факультет, Курс, Группа.
//Создать массив из 10 объектов.
//Вывести:
//a) список студентов заданного факультета; - Факульет
//b) списки студентов для каждого факультета и курса; - Факультет, Группа
//c) список студентов, родившихся после заданного года; - Год рождения
//d) список учебной группы. - Группа
    int studentId;
    String firstName;
    String lastName;
    String patronym;
    int birthYear;
    String address;
    String telephoneNumber;
    String faculty;
    String major;
    String group;

    public Student() {

    }

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public Student(int studentId, String firstName, String lastName, String patronym, int birthYear, String address, String telephoneNumber, String faculty, String major, String group) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronym = patronym;
        this.birthYear = birthYear;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.faculty = faculty;
        this.major = major;
        this.group = group;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return
                "studentId: " + studentId +
                        ", firstName: " + firstName +
                        ", lastName: " + lastName +
                        ", patronym: " + patronym +
                        ", birthYear: " + birthYear +
                        ", address: " + address +
                        ", telephoneNumber: " + telephoneNumber +
                        ", faculty: " + faculty +
                        ", major: " + major +
                        ", group: " + group;
    }


}