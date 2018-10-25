package ru.interview.lesson_five;

/**
 * Created by GVG on 25.10.2018.
 */
public class MainClass {
    public static void main(String[] args) {
        StudentService service = new StudentService();
//        for (int i = 0; i < 1000; i++) {
//            service.saveStudent(new Student("Student" + Integer.toString(i), "markStudent" + Integer.toString(i)));
//        }
        System.out.println(service.findAllStudents().size());
        Student student = service.findStudent(100);
        System.out.println(student.getName());
        student.setName("StudentNameChanged_100");
        service.updateStudent(student);
        student = service.findStudent(100);
        System.out.println(student.getName());
        service.deleteStudent(student);
        System.out.println(service.findAllStudents().size());

    }
}
