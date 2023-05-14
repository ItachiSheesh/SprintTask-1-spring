package kz.aldiyar.students.Sprint1.controller;

import kz.aldiyar.students.Sprint1.db.DBManager;
import kz.aldiyar.students.Sprint1.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model){
        ArrayList<Student> studentArray = DBManager.getStudents();
        model.addAttribute("studentter", studentArray);
        return "index";
    }

    @PostMapping(value = "/add-student")
    public String addStudent(Student student){
        DBManager.addStudent(student);
        return "redirect:/";
    }

    @PostMapping(value = "/add-student-v2")
    public String addStudentV2(
            @RequestParam(name = "student-name") String name,
            @RequestParam(name = "student-surname") String surname,
            @RequestParam(name = "student-exam") int exam,
            @RequestParam(name = "student-mark") String mark
    ){
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        student.setMark(mark);
        return "redirect:/";
    }

    @GetMapping(value = "/add-student")
    public String addStudentPage(Model model){
        return "addstudent";
    }
}
