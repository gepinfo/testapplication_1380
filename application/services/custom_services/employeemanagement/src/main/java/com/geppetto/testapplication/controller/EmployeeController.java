package com.geppetto.testapplication.controller;

import com.geppetto.testapplication.dto.EmployeeDto;
import com.geppetto.testapplication.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
* REST controller for managing Employee
* Provides endpoints to create, update, delete, retrieve, and search for Employee,
* as well as to handle file uploads and downloads associated with Employee.
*/
@RestController
@RequestMapping("/employeemanagement")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

   private final EmployeeService employeeService; 


@GetMapping("/{id}")
public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String id) {
    log.info("Enter into getEmployeeById method");
    ResponseEntity<EmployeeDto> response =ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    log.info("Exit from getEmployeeById method");
    return response;
}

@GetMapping
public ResponseEntity<Page<EmployeeDto>> getAllEmployee(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
    log.info("Enter into getAllEmployee method");
    Page<EmployeeDto>employeeDtoPage = employeeService.getAllEmployee(page, size);
    log.info("Exit from getAllEmployee method");
    return new ResponseEntity<>(employeeDtoPage, HttpStatus.OK);
}

@PostMapping
public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
    log.info("Enter into createEmployee method");
    ResponseEntity<EmployeeDto> response =  ResponseEntity.status(HttpStatus.OK).body(employeeService.createEmployee(employeeDto));
    log.info("Exit from createEmployee method");
    return response;
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
    log.info("Enter into deleteEmployee method");
     ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployee(id));
    log.info("Exit from deleteEmployee method");
    return response;
}

@PutMapping
public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
    log.info("Enter into updateEmployee method");
    ResponseEntity<EmployeeDto> response = ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employeeDto));
    log.info("Exit from updateEmployee method");
    return response;
}

   
}
