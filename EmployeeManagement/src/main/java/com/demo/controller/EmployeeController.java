package com.demo.controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    public EmployeeController() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    @RequestMapping("/")
    public String home(Model model) {
        List<Employee> employees = empService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee emp) {
        empService.addEmployee(emp);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        empService.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchEmployee(@RequestParam("id") int id, Model model) {
        Employee emp = empService.getEmployeeById(id);
        model.addAttribute("emp", emp);
        return "search-result";
    }
}
