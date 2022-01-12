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

    public static Student[] createStudents() {
        Student[] students = new Student[10];
        students[0] = new Student(1, "Nadja", "Halenkova", "Olegovna", 1995, "Hovorova Street", "0661747173", "Entrepreneurial Management", "Management", "M131");
        students[1] = new Student(2, "Lisa", "Schevchenko", "Denisovna", 1997, "Klenovaya Street", "06612341423", "Arts and Sciences", "Archaeology", "A150");
        students[2] = new Student(3, "Kristina", "Holdireva", "Vladimirovna", 1994, "Marazlievskaya Street", "06689056743", "Arts and Sciences", "Archaeology", "A120");
        students[3] = new Student(4, "Maksym", "Trybunski", "Vladimirovich", 1994, "Leontovicha Street", "09723456780", "Entrepreneurial Management", "Management", "M131");
        students[4] = new Student(5, "Kyryl", "Horalevich", "Bogdanov", 1987, "Deribasovskaya Street", "0934567870", "Accounting Management", "Accounting", "M010");
        students[5] = new Student(6, "Katja", "Romanovich", "Pavlovna", 1998, "Akademicheskaya Street", "06789096745", "Entrepreneurial Management", "Management", "M131");
        students[6] = new Student(7, "Natasha", "Bondarenko", "Romanovna", 1993, "Pushkinskaya Street", "099785645091", "Design", "Architecture", "A145");
        students[7] = new Student(8, "Nina", "Starovoitova", "Vladimirovna", 1996, "Akademicheskaya Street", "0660987654", "Arts and Sciences", "Archaeology", "A120");
        students[8] = new Student(9, "Maksym", "Trybunski", "Vladimirovich", 1994, "Leontovicha Street", "0974561239", "Design", "Landscape", "L121");
        students[9] = new Student(10, "Vova", "Sukhobokov", "Petrov", 1990, "Klubnichnaya Street", "09356679065", "Accounting Management", "Accounting", "A120");
        return students;
    }

    public static void main(String[] args) {
        Student[] students = Student.createStudents();
        Scanner input = new Scanner(System.in);


        System.out.println("Enter you faculty");
        String myFaculty = input.nextLine();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFaculty().equals(myFaculty)) {
                System.out.println(students[i].toString());
            }
        }
        System.out.println("Enter you faculty, then your group");
        myFaculty = input.nextLine();
        String myGroup = input.nextLine();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFaculty().equals(myFaculty) && students[i].getGroup().equals(myGroup)) {
                System.out.println(students[i].toString());
            }
        }
        System.out.println("Enter your group");
        myGroup = input.nextLine();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGroup().equals(myGroup)) {
                System.out.println(students[i].toString());
            }
        }
        System.out.println();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getBirthYear() > 1990) {
                System.out.println("Was born after 1990: " + students[i].toString());
            }
        }
    }
}