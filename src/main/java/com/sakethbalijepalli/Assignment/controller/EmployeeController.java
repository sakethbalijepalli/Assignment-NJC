package com.sakethbalijepalli.Assignment.controller;

import com.sakethbalijepalli.Assignment.Models.Employee;
import com.sakethbalijepalli.Assignment.Models.EmployeeDto;
import com.sakethbalijepalli.Assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> List(){
        return ResponseEntity.ok(employeeService.listEmployees());
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto){
       return  ResponseEntity.ok(employeeService.addEmployee(employeeDto));
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable Long id){
        if (employeeService.removeEmployee(id)){
           return ResponseEntity.ok("Employee removed");

        }else{
           return ResponseEntity.badRequest().body("Cannot find the employee with the specified id");
        }
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
        Optional<Employee> e = employeeService.updateEmployee(employeeDto,id);
        if(e.isPresent()){
           return ResponseEntity.ok("Employee details updated");
        }else{
           return ResponseEntity.badRequest().body("Employee details not found");
        }
    }
    @GetMapping("/raise/{x}")
    public ResponseEntity<String> increaseByX(@PathVariable int x){
        employeeService.increasePayByXPercent(x);
        return ResponseEntity.ok(String.format("Salaries increased by %d percent.",x));
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable Long id){
        Optional<Employee> e = employeeService.getEmployeeDetails(id);
        return e.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

}
