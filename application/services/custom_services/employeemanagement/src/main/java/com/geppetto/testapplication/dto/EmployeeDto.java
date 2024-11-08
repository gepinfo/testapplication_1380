package com.geppetto.testapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Builder;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @NotBlank(message = "id cannot be null or empty")
    private String id;
     
    @NotBlank(message = "name cannot be null or empty")  
    private String name;
   
    @NotBlank(message = "empid cannot be null or empty")  
    private String empid;
   
    @NotBlank(message = "role cannot be null or empty")  
    private String role;
  
    }
