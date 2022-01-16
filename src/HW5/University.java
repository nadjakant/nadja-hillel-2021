package HW5;

public class University {


    public Student[] createStudents() {
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

    Student[] students = createStudents();

    public void getStudentsbyFaculty(String faculty) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFaculty().equals(faculty)) {
                System.out.println(students[i].toString());
            }
        }
    }

    public void getStudentsbyFacultyandGroup(String faculty, String group) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFaculty().equals(faculty) && students[i].getGroup().equals(group)) {
                System.out.println(students[i].toString());
            }
        }
    }

    public void getStudentsbyGroup(String group) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGroup().equals(group)) {
                System.out.println(students[i].toString());
            }
        }
        System.out.println();

    }

    public void getStudentsbyBirthYear(int birthYear) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getBirthYear() > 1990) {
                System.out.println("Was born after 1990: " + students[i].toString());
            }
        }
    }

}

