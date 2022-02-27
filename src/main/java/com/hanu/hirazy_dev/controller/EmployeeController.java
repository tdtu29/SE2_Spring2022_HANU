package com.hanu.hirazy_dev.controller;

import com.hanu.hirazy_dev.model.Employee;
import com.hanu.hirazy_dev.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String viewEmployeeList(Model model){
        // Get data from table in database
        List<Employee> employeeList = employeeRepository.findAll();

        // send this data to front-end (view)
        model.addAttribute("employeeList", employeeList);

        // render the view
        return "employeeList";
    }

    @RequestMapping(value = "/detail/{id}")
    public String getEmployeeById(@PathVariable(value = "id") Long id, Model model){
        Employee employee = employeeRepository.getById(id);
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }

}
