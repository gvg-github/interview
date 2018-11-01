package ru.interview.lesson_seven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.interview.lesson_seven.entity.Student;
import ru.interview.lesson_seven.repository.StudentRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by GVG on 01.11.2018.
 */
@Controller
public class StudentController {

    @Autowired
    StudentRepository repository;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String userList(Map<String, Object> model) {
        List<Student> students = repository.getAll();
        model.put("studentList", students);
        return "default";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addStudent(Map<String, Object> model) {
        repository.addStudent(new Student());
        return "default";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String edit(@ModelAttribute("student") Student student, @RequestParam("studentId") int studentId, Map<String, Object> model) {
        repository.updateStudent(student, studentId);
        return "default";
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public String delete(@RequestParam("studentId") int studentId) {
        repository.removeStudent(studentId);
        return "default";
    }


}
