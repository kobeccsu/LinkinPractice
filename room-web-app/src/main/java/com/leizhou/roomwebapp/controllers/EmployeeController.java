package com.leizhou.roomwebapp.controllers;

import com.leizhou.roomwebapp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public  String getAllEmployee(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }
}
