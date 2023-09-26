package top.hyzhu.utils;

import top.hyzhu.entity.Student;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: zhy
 */
public class DataUtil {

    public static List<Student> getStudents() {
        List<Student> studentList;
        Student student1 = new Student(1, "李四", "../images/a1.jpg", LocalDate.of(2004, 2, 8), "上善若水");
        Student student2 = new Student(2, "李五", "../images/a2.jpg", LocalDate.of(2005, 6, 3), "上善若水11");
        Student student3 = new Student(3, "李六", "../images/a3.jpg", LocalDate.of(2006, 7, 11), "上善若水3435");
        Student student4 = new Student(4, "李七", "../images/a4.jpg", LocalDate.of(2007, 8, 13), "上善若水2332");
        studentList = List.of(student1, student2, student3, student4);
        return studentList;
    }
}
