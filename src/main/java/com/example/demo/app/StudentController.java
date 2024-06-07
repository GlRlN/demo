package com.example.demo.app;

import com.example.demo.domain.model.dto.StudentRequest;
import com.example.demo.domain.model.entity.Student;
import com.example.demo.domain.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentInput")
    public String doGet(Model model) {
        model.addAttribute("sr", new StudentRequest());
        return "studentInput.html";
    }

    @PostMapping("/studentInput")
    public String doPost(Model model, @ModelAttribute("sr") StudentRequest sr) {
        if (sr.name == null) {
            System.out.println("sr is null");
        } else {
            studentService.saveStudent(sr);
            model.addAttribute("name", sr.name);
        }
        return "redirect:/studentList";
    }

    @GetMapping("/studentList")
    public String doListGet(Model model, @RequestParam Map<String, Object> params) {
        List<Student> students = null;
        if (params.get("grade") != null) {
            int grade = Integer.parseInt(params.get("grade").toString());
            students = studentService.getAllStudentsByGrade(grade);
        } else if (params.get("name") != null) {
            String name = params.get("name").toString();
            students = studentService.getAllStudentsByName(name);
        } else {
            students = studentService.getAllStudents();
        } model.addAttribute("students", students);
        return "studentList.html";
    }
}
//, method = RequestMethod.GET
