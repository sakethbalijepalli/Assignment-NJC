package com.sakethbalijepalli.Assignment.Repository;

import com.sakethbalijepalli.Assignment.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Query(value = "INSERT INTO employee VALUES (2, 'Hyderabad', 'CSFA', '987654345678987', 'Saketh')",
//            nativeQuery = true)
//    public void createRandomEmployee();

}
