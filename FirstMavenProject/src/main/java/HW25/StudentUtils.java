package HW25;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class StudentUtils {
    public static void addStudent(Students student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

    static List<Students> getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Students> students = session.createQuery("from Students").list();
        List<Students> studentsList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(name)) {
                studentsList.add(students.get(i));
            }
        }
        System.out.println(studentsList);
        return studentsList;
    }

    static List<Students> getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Students> students = session.createQuery("from Students").list();
        List<Students> studentsList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id) {
                studentsList.add(students.get(i));
            }
        }
        System.out.println(studentsList);
        return studentsList;
    }
}
