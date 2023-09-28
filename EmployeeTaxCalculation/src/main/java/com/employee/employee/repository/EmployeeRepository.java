package com.employee.employee.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT EmployeeID, FirstName, LastName, Salary, CASE WHEN Salary <= 250000 THEN 0 WHEN Salary <= 500000 THEN Salary * 0.05 WHEN Salary <= 1000000 THEN Salary * 0.10 ELSE Salary * 0.20 END AS TaxAmount, CASE WHEN Salary <= 2500000 THEN 0 ELSE Salary * 0.02 END AS CessAmount FROM (SELECT EmployeeID, FirstName, LastName, CASE WHEN MONTH(DOJ) <=3 THEN (MONTH(DOJ) * Salary) - (Salary / 30) * (DAY(DOJ) - 1) ELSE (((12 - MONTH(DOJ))+4) * Salary) - (Salary / 30) * (DAY(DOJ) - 1) END AS Salary FROM employee) AS emp", nativeQuery = true)
    List<Map<String, Object>> getTaxDeductionDetail();
}
