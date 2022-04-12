package HW23;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class StudentUtils {
    public static final String serverTimeZone = "UTC";
    public static final String serverName = "localhost";
    public static String databaseName = "HW22";
    public static int portNumber = 3306;
    public static String user = "root";
    public static String password = "rootroot";


    static List<Student> getAll() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPort(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Students");
        return getStudents(connection, resultSet);
    }

    static void addStudent(Student student) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPort(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into Students(id,first_name,last_name,group_id,year) values (?,?,?, ?,?)");
        preparedStatement.setInt(1,student.getId());
        preparedStatement.setString(2,student.getFirstName());
        preparedStatement.setString(3,student.getLastName());
        preparedStatement.setInt(4,student.getGroupId());
        preparedStatement.setInt(5,student.getYear());
        int executeUpdate = preparedStatement.executeUpdate();
        connection.close();
    }
    static void deleteStudent(int row) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPort(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        int executeUpdate = statement.executeUpdate("DELETE FROM Students WHERE id='" + row + "'");
        connection.close();
        }


    static List<Student> getByName(String name) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPort(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * FROM Students WHERE first_name='" + name + "'");
        return getStudents(connection, resultSet);
    }

    private static List<Student> getStudents(Connection connection, ResultSet resultSet) throws SQLException {
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int groupId = resultSet.getInt("group_id");
            int year = resultSet.getInt("year");
            students.add(new Student(id, firstName, lastName, groupId, year));
        }

        System.out.println(students.size());
        for (Student student : students) {
            System.out.println(student);

        }
        connection.close();
        return students;
    }

    static List<Student> getByIds(List<Integer> neededIds) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPort(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");
        ArrayList<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student(resultSet.getInt("id"), resultSet.getString("first_name"),resultSet.getString("last_name"), resultSet.getInt("group_id"), resultSet.getInt("year"));
            for (int i = 0; i < neededIds.size(); i++) {
                if (neededIds.get(i).equals(student.getId())) {
                    students.add(student);
                }
            }
        }
        for (Student student: students) {
            System.out.println(student);
        }
        connection.close();
        return students;
    }

}
