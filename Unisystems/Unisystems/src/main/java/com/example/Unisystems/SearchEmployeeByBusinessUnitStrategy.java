package com.example.Unisystems;

import com.example.Unisystems.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class SearchEmployeeByBusinessUnitStrategy implements SearchEmployeeStrategy {
    @Override
    public List<Employee> execute(Long criteriaId, Iterable<Employee> allEmployees) {

        List<Employee> employees = new ArrayList<>();

        for( Employee employee : allEmployees ) {
            if ( employee.getUnit().getDepartment().getBusinessUnit().getId() == criteriaId ){
                employees.add(employee);
            }
        }

        return employees;
    }
}
