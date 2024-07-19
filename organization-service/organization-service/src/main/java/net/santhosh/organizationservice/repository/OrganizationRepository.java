package net.santhosh.organizationservice.repository;

import net.santhosh.organizationservice.dto.OrganizationDto;
import net.santhosh.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}
