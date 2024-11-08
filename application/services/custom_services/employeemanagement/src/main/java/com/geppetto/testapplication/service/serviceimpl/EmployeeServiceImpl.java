package com.geppetto.testapplication.service.serviceimpl;

import com.geppetto.testapplication.dao.EmployeeDao;
import com.geppetto.testapplication.dto.EmployeeDto;
import com.geppetto.testapplication.exception.EntityNotFoundException;
import com.geppetto.testapplication.model.Employee;
import com.geppetto.testapplication.service.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
* Implementation of the {@link EmployeeService} interface.
* Provides services related to Employee, including CRUD operations and file uploads/downloads.
*/

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {


    /**
     * Constructs a {@code EmployeeServiceImpl} with the specified DAO and MongoTemplate.
     *
     * @param employeeDao The DAO for accessing the data.
     * @param mongoTemplate The MongoTemplate for interacting with MongoDB.
     */
  private final EmployeeDao employeeDao;
  private final MongoTemplate mongoTemplate;

  public EmployeeServiceImpl(EmployeeDao  employeeDao, MongoTemplate mongoTemplate) {
    this. employeeDao =  employeeDao;
    this.mongoTemplate = mongoTemplate;
  }
    
    /**
     * Retrieves employee by its ID.
     *
     * @param id The ID of the employee to retrieve. Must not be {@code null}.
     * @return The employee data transfer object associated with the specified ID.
     * @throws EntityNotFoundException If no employee with the specified ID is found.
     */
  @Override
  public EmployeeDto  getEmployeeById(String id) {
    log.info("Enter into getEmployeeById method");
    return employeeDao.getEmployeeById(id)
    .map(employee -> {
      EmployeeDto employeeDto = new EmployeeDto();
      BeanUtils.copyProperties(employee, employeeDto);
      log.info("Exit from getEmployeeById method");
      return employeeDto;
    })
        .orElseThrow(() -> new EntityNotFoundException("Data not found for ID: " + id));
  }
    
    /**
     * Retrieves all employee.
     *
     * @return A list of {@link EmployeeDto} representing all employee.
     */
  @Override
  public Page<EmployeeDto>  getAllEmployee(int page, int size) {
    log.info("Enter into getAllEmployee method");
    Pageable pageable = (Pageable) PageRequest.of(page, size);
    Page<Employee> employeePage =employeeDao.getAllEmployee(pageable);
    Page<EmployeeDto>employeeDtoPage = employeePage.map(employee -> {
    EmployeeDto employeeDto = EmployeeDto.builder().build();
    BeanUtils.copyProperties(employee, employeeDto);
    return employeeDto;
    });
    log.info("Exit from getAllemployeemethod");
    return employeeDtoPage;
  }
    
    /**
     * Creates new employee.
     *
     * @param employeeDto The {@link EmployeeDto} to be created.
     * @return The created {@link EmployeeDto}.
     */
  @Override
  public EmployeeDto  createEmployee(EmployeeDto employeeDto) {
    log.info("Enter into createEmployee method");
    Employee employee = new Employee();
  BeanUtils.copyProperties(employeeDto, employee);
  Employee createdEmployee= employeeDao.createEmployee(employee);
  BeanUtils.copyProperties(createdEmployee, employeeDto);
  log.info("Exit from createEmployee method");
  return employeeDto;
  }
    
    /**
     * Deletes employee by ID.
     *
     * @param id The ID of the employee to delete.
     * @return A message indicating the result of the deletion.
     * @throws EntityNotFoundException If no employee with the specified ID is found.
     */
  @Override
  public String  deleteEmployee(String id) {
    log.info("Enter into deleteEmployee method");
    return employeeDao.getEmployeeById(id)
     .map(employee -> {
     employeeDao.deleteEmployee(id);
  log.info("Exit from deleteEmployee method");
  return "Data Deleted Successfully";
  })
  .orElseThrow(() -> new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete."));

  }
    
    /**
     * Updates existing employee.
     *
     * @param employeeDto The {@link EmployeeDto} containing updated information.
     * @return The updated {@link EmployeeDto}.
     * @throws EntityNotFoundException If no employee with the specified ID is found.
     */
  @Override
  public EmployeeDto  updateEmployee(EmployeeDto employeeDto) {
    log.info("Enter into updateEmployee method");
    return employeeDao.getEmployeeById(employeeDto.getId())
    .map(existingEmployee -> {
      BeanUtils.copyProperties(employeeDto, existingEmployee);
      employeeDao.createEmployee(existingEmployee);
      log.info("Exit from updateEmployee method");
      return employeeDto;
  })
  .orElseThrow(() -> new EntityNotFoundException("Data not found for update with ID: " + employeeDto.getId()));
  }
    

}
