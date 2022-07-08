package edu.miu.eregister.controller;

import edu.miu.eregister.model.Student;
import edu.miu.eregister.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/eregister/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ModelAndView listStudents() {
        var students = studentService.getAllStudents();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }

    @GetMapping("/new")
    public String displayNewStudentForm(Model model) {
        var newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "secured/student/new";
    }

    @PostMapping("/new")
    public String addNewStudent(@ModelAttribute("student") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }
        studentService.addNewStudent(student);
        return "redirect:/eregister/student/list";
    }

    @GetMapping("/edit/{studentId}")
    public String displayEditStudentForm(@PathVariable Integer studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "secured/student/edit";
        }
        return "redirect:/eregister/student/list";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/edit";
        }
        studentService.updateStudent(student);
        return "redirect:/eregister/student/list";
    }

    @GetMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregister/student/list";
    }
}
