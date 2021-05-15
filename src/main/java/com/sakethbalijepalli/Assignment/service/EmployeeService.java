package com.sakethbalijepalli.Assignment.service;

import com.sakethbalijepalli.Assignment.Models.Employee;
import com.sakethbalijepalli.Assignment.Models.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(EmployeeDto employee);

    Boolean removeEmployee(Long id);

    Optional<Employee> updateEmployee(EmployeeDto employee, Long id);

    Optional<Employee> getEmployeeDetails(Long id);

    List<Employee> listEmployees();

    void increasePayByXPercent(int x);
}
