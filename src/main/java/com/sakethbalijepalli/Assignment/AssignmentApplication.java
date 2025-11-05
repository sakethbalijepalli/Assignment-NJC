package com.sakethbalijepalli.Assignment;

import com.sakethbalijepalli.Assignment.Models.EmployeeDto;
import com.sakethbalijepalli.Assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var e = new EmployeeDto("saketh", "hyd", "9193291", "IT");
        employeeService.addEmployee(e);
        e = new EmployeeDto("rohan", "hyd", "9193291", "IT");
        employeeService.addEmployee(e);
        e = new EmployeeDto("medhu", "hyd", "9193291", "IT");
        employeeService.addEmployee(e);
        e = new EmployeeDto("sravya", "hyd", "9193291", "IT");
        employeeService.addEmployee(e);
        e = new EmployeeDto("Ravi","Hyderabad","9213231","Ece");
        employeeService.addEmployee(e);
    }

}
