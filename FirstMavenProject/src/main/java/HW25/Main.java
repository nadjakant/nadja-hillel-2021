package HW25;

public class Main {

    public static void main(String[] args) {
        Students student1= new Students(1,"Nadja","Kant",5,2014);
        Students student2= new Students(2,"Vanja","Ivanov",3,2002);
        StudentUtils.addStudent(student1);
        StudentUtils.addStudent(student2);
        StudentUtils.getByName("Nadja");
        StudentUtils.getById(2);

    }
}
