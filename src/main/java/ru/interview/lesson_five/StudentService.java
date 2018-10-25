package ru.interview.lesson_five;

import java.util.List;

/**
 * Created by GVG on 25.10.2018.
 */
public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public StudentService() {
    }

    public Student findStudent(int id) {
        return studentDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentDao.persist(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    public void close(){
        studentDao.closeCurrentSession();
    }
}
