package net.santhosh.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.santhosh.employeeservice.dto.APIResponseDto;
import net.santhosh.employeeservice.dto.DepartmentDto;
import net.santhosh.employeeservice.dto.EmployeeDto;
import net.santhosh.employeeservice.dto.OrganizationDto;
import net.santhosh.employeeservice.entity.Employee;
import net.santhosh.employeeservice.mapper.EmployeeMapper;
import net.santhosh.employeeservice.repository.EmployeeRepository;
import net.santhosh.employeeservice.service.APIClient;
import net.santhosh.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;

    private WebClient webClient;

    //private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployee(Long employeeId) {
        logger.info("inside getEmployee() method");
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient
                                            .get()
                                            .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                                            .retrieve()
                                            .bodyToMono(DepartmentDto.class)
                                            .block();

        OrganizationDto organizationDto = webClient
                .get()
                .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        //DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception){
        logger.info("inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentDescription("Research and Development Department");

        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrganizationCode("XYZ");
        organizationDto.setOrganizationDescription("XYZ");
        organizationDto.setOrganizationName("XYZ");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto(employeeDto, departmentDto, organizationDto);
        return apiResponseDto;
    }
}
