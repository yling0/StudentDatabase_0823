package me.yling.studentdatabase0823.controllers;

import me.yling.studentdatabase0823.models.Student;
import me.yling.studentdatabase0823.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    StudentRepo studentRepo;

    @RequestMapping("/")
    public String listContacts(Model model)
    {
        model.addAttribute("students", studentRepo.findAll());
        return "list";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/add")
    public String studentForm(Model model)
    {
        model.addAttribute("student", new Student());
        return "studentform";
    }

    @PostMapping("/process")
    public String processForm (@Valid Student student, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "studentform";
        }
        studentRepo.save(student);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("student", studentRepo.findOne(id));
        return "studentform";
    }

    @RequestMapping("/delete/{id}")
    public String delStudent(@PathVariable("id") long id, Model model)
    {
        studentRepo.delete(id);
        return "redirect:/";
    }


}
