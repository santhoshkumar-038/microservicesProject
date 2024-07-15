package net.santhosh.departmentservice.service;

import net.santhosh.departmentservice.dto.DepartmentDTO;
import net.santhosh.departmentservice.entity.Department;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentByCode(String departmentCode);
}
