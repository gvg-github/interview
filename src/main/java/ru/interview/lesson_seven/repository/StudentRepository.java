package ru.interview.lesson_seven.repository;

import org.springframework.stereotype.Repository;
import ru.interview.lesson_seven.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GVG on 01.11.2018.
 */
@Repository
public class StudentRepository implements StudentRepositoryInterface {

    List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(Student student, int id) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            students.set(index, student);
        }
    }

    public void removeStudent(int id) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            students.remove(index);
        }
    }

    public List<Student> getAll() {
        return students;
    }
}
