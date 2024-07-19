package net.santhosh.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.santhosh.departmentservice.dto.DepartmentDTO;
import net.santhosh.departmentservice.entity.Department;
import net.santhosh.departmentservice.mapper.DepartmentMapper;
import net.santhosh.departmentservice.repository.DepartmentRepository;
import net.santhosh.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDto) {

        // Convert DepartmentDTO to department entity;
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDTO savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDTO departmentDTO = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDTO;
    }
}
