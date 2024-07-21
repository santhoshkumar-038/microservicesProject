package net.santhosh.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.santhosh.employeeservice.dto.APIResponseDto;
import net.santhosh.employeeservice.dto.EmployeeDto;
import net.santhosh.employeeservice.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
@Tag(
        name = "Employee Service - Employee Controller",
        description = "Employee controller exposes Rest APIs for Employee Service"
)

public class EmployeeController {
    private EmployeeService employeeService;

    // Build Save Employee Rest API
    @PostMapping
    @Operation(
            summary = "Get Employee Rest API",
            description = "Get Employee Rest API is used to save employee object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 created"
    )
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee Rest API
    @GetMapping("{id}")
    @Operation(
            summary = "GET Employee Rest API",
            description = "Get Employee Rest API is used to save Employee object in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
