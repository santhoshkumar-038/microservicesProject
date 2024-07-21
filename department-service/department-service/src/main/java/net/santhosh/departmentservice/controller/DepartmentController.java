package net.santhosh.departmentservice.controller;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.santhosh.departmentservice.dto.DepartmentDTO;
import net.santhosh.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - Department Controller",
        description = "Department controller exposes Rest APIs for Department Service"
) @RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build Save Department RestAPI
    @PostMapping
    @Operation(
            summary = "Save Department Rest API",
            description = "Save Department Rest API is used to save department object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 created"
    )
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDto){
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // Build Get department rest api
    @GetMapping("{department-code}")
    @Operation(
            summary = "Get Department Rest API",
            description = "Get Department Rest API is used to get department object from database"
    )
    @ApiResponse(
            responseCode = "20",
            description = "Http Status 200 OK"
    )
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
        DepartmentDTO departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
