package net.santhosh.departmentservice.mapper;

import net.santhosh.departmentservice.dto.DepartmentDTO;
import net.santhosh.departmentservice.entity.Department;

public class DepartmentMapper {
    public static DepartmentDTO mapToDepartmentDto(Department department) {
        DepartmentDTO departmentDto = new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
    public static Department mapToDepartment(DepartmentDTO departmentDto){
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
