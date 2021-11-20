package service;

import connection.ConnectionSingleton;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
    public static final String SELECT_FROM_STUDENT_WHERE_CODE = "select * from Student where code = ?";
    public static final String SELECT_FROM_STUDENT_WHERE_ID = "select * from Student where id = ?";
    Connection connection = ConnectionSingleton.getConnection();
    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_STUDENT_WHERE_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String code = resultSet.getString("code");
                String classes = resultSet.getString("className");
                student = new Student(id, name, code, classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student findByCode(String code) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_STUDENT_WHERE_CODE);
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String classes = resultSet.getString("className");
                student = new Student(id, name, code, classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
