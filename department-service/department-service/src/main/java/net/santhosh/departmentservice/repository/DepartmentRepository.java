package net.santhosh.departmentservice.repository;

import net.santhosh.departmentservice.dto.DepartmentDTO;
import net.santhosh.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.SecureRandom;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
