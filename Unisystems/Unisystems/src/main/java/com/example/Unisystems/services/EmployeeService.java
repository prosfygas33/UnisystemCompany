package com.example.Unisystems.services;

import com.example.Unisystems.SearchEmployeeStrategy;
import com.example.Unisystems.SearchEmployeeStrategyFactory;
import com.example.Unisystems.mappers.EmployeeMapper;
import com.example.Unisystems.model.Employee;
import com.example.Unisystems.model.EmployeeResponse;
import com.example.Unisystems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SearchEmployeeStrategyFactory searchEmployeeStrategyFactory;

    public List<EmployeeResponse> getEmployees(){
        Iterable<Employee> retrievedEmployees = employeeRepository.findAll();
        List<EmployeeResponse> employees = new ArrayList<>();

        for ( Employee employee : retrievedEmployees ){
            employees.add(employeeMapper.mapEmployeeResponseFromEmployee(employee));
        }

        return employees;
    }

    public List<EmployeeResponse> getEmployeesById(String searchCriteria, long id){
        Iterable<Employee> retrievedEmployees = employeeRepository.findAll();
        List<EmployeeResponse> employees; //= new ArrayList<>();

        SearchEmployeeStrategy strategy = searchEmployeeStrategyFactory.makeStrategyForCriteria(searchCriteria);
        employees = employeeMapper.mapAllEmployees(strategy.execute( id,retrievedEmployees));

        return employees;
    }
}
