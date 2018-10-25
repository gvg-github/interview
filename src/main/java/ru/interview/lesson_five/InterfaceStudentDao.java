package ru.interview.lesson_five;

import java.util.List;

/**
 * Created by GVG on 25.10.2018.
 */
public interface InterfaceStudentDao {

    public void persist(Student entity);

    public void update(Student entity);

    public Student findById(int id);

    public void delete(Student entity);

    public List<Student> findAll();

    public void deleteAll();
}
