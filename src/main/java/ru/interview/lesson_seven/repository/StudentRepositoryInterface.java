package ru.interview.lesson_seven.repository;

import ru.interview.lesson_seven.entity.Student;

import java.util.List;

/**
 * Created by GVG on 01.11.2018.
 */
public interface StudentRepositoryInterface {
    void addStudent(Student student);
    void updateStudent(Student student, int id);
    void removeStudent(int id);
    List<Student> getAll();
}
