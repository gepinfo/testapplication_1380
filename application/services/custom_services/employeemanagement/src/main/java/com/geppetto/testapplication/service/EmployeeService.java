package com.geppetto.testapplication.service;

import com.geppetto.testapplication.dto.EmployeeDto;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    EmployeeDto  getEmployeeById(String id);

    Page<EmployeeDto>  getAllEmployee(int page, int size);

    EmployeeDto  createEmployee(EmployeeDto employeeDto);

    String  deleteEmployee(String id);

    EmployeeDto  updateEmployee(EmployeeDto employeeDto);

}
