package com.sakethbalijepalli.Assignment.service;

import com.sakethbalijepalli.Assignment.Models.Employee;
import com.sakethbalijepalli.Assignment.Models.EmployeeDto;
import com.sakethbalijepalli.Assignment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = new Employee(employeeDto.getName(),employeeDto.getCity(),employeeDto.getMobileNumber(),employeeDto.getDept());
        newEmployee.setSalary(50000);
        newEmployee.setDateJoining(LocalDate.now());
        newEmployee.setLastEdited(LocalDateTime.now());
        return employeeRepository.saveAndFlush(newEmployee);

    }

    @Override
    public Boolean removeEmployee(Long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Employee> updateEmployee(EmployeeDto employee, Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee e = optionalEmployee.get();
            e.setName(employee.getName());
            e.setCity(employee.getCity());
            e.setMobileNumber(employee.getMobileNumber());
            e.setDept(employee.getDept());
            e.setLastEdited(LocalDateTime.now());
            return Optional.of(employeeRepository.saveAndFlush(e));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Employee> getEmployeeDetails(Long id) {

        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void increasePayByXPercent(int x) {
        List<Employee> employeeList = employeeRepository.findAll();
        for(Employee e : employeeList){
            e.setSalary(e.getSalary() + (e.getSalary()*x)/100);
        }
        employeeRepository.saveAll(employeeList);

//        employeeRepository.saveAll(
//                employeeList.stream().peek(
//                        (Employee e) -> {
//                            e.setSalary(e.getSalary() + (e.getSalary() * x) / 100);
//                        }).collect(Collectors.toList())
//        );

    }
}
