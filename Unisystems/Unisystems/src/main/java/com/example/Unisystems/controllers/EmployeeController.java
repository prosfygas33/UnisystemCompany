package com.example.Unisystems.controllers;

import com.example.Unisystems.model.GetAllEmployees;
import com.example.Unisystems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public GetAllEmployees getAllEmployees(){
        return new GetAllEmployees(employeeService.getEmployees());
    }

    @GetMapping("{searchCriteria}/{id}")
    public GetAllEmployees getEmployeesById(@PathVariable String searchCriteria,@PathVariable long id){
        return new GetAllEmployees(employeeService.getEmployeesById(searchCriteria,id));
    }

}
