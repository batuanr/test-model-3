package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Student findById(int id);
    Student findByCode(String code);
}
