package HW5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        University harvard = new University();
        harvard.createStudents();


        System.out.println("Enter you faculty");
        String faculty = input.nextLine();
        harvard.getStudentsbyFaculty(faculty);

        System.out.println("Enter you faculty, then your group");
        faculty = input.nextLine();
        String group = input.nextLine();
        harvard.getStudentsbyFacultyandGroup(faculty,group);


        System.out.println("Enter your group");
        group = input.nextLine();
        harvard.getStudentsbyGroup(group);


        System.out.println("Enter your birthYear");
        int birthYear = input.nextInt();
        harvard.getStudentsbyBirthYear(birthYear);

    }


}
