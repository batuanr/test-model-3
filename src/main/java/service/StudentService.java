package service;

import connection.ConnectionSingleton;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
    Connection connection = ConnectionSingleton.getConnection();
    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Student where id = ?");
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
    public Student findByName(String name) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Student where name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String classes = resultSet.getString("className");
                student = new Student(id, name, code, classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
