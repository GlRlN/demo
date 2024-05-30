package com.example.demo.app;

import com.example.demo.domain.model.dto.StudentRequest;
import com.example.demo.domain.model.entity.Store;
import com.example.demo.domain.model.entity.Student;
import com.example.demo.domain.repository.StudentRepository;
import com.example.demo.domain.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class IndexController {
    private final HttpServletRequest httpServletRequest;
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public IndexController(HttpServletRequest httpServletRequest, StudentService studentService, StudentRepository studentRepository) {
        this.httpServletRequest = httpServletRequest;
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String doGet2() {
        return "index.html";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String doPost2(Model model) {
        String name = httpServletRequest.getParameter("name");
        model.addAttribute("name", name);
        return "output.html";
    }

    @GetMapping("/index2")
    public String doGet(Model model) {
        model.addAttribute("sr", new StudentRequest());
        return "index.html";
    }

    @PostMapping("/index2")
    public String doPost(Model model, @ModelAttribute("sr") StudentRequest sr) {
        if (sr.name == null) {
            System.out.println("sr is null");
        } else {
            studentService.saveStudent(sr);
            model.addAttribute("name", sr.name);
        }
        return "output.html";
    }

    @GetMapping("/student")
    public String getStudents(Model model, @RequestParam Map<String, Object> params) {
        List<Student> students = studentRepository.findAll();

        if (params.get("grade") != null) {
            int grade = Integer.parseInt(params.get("grade").toString());

            students = studentRepository.findByGrade(grade);
        }

        model.addAttribute("students", students);
        return "student.html";
    }
}
//, method = RequestMethod.GET
