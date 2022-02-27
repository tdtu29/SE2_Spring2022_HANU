package com.hanu.hirazy_dev.repository;

import com.hanu.hirazy_dev.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
