package HW23;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static HW23.StudentUtils.*;

public class Main {


    public static void main(String[] args) throws SQLException {

        getAll();
        Student student = new Student(1, "Katja", "Pavlova", 0, 2015);
        addStudent(student);
        getAll();
        deleteStudent(1);
        getAll();
        getByName("Nadja");
        List<Integer> neededIds = new ArrayList<>();
        neededIds.add(2);
        neededIds.add(4);
        getByIds(neededIds);

    }


}
