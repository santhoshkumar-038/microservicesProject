package net.santhosh.employeeservice.service;

import net.santhosh.employeeservice.dto.APIResponseDto;
import net.santhosh.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployee(Long employeeId);
}
