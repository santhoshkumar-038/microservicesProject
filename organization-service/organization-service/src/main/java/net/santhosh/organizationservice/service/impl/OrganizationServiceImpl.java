package net.santhosh.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.santhosh.organizationservice.dto.OrganizationDto;
import net.santhosh.organizationservice.entity.Organization;
import net.santhosh.organizationservice.mapper.OrganizationMapper;
import net.santhosh.organizationservice.repository.OrganizationRepository;
import net.santhosh.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        // convert dto to jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        OrganizationDto savedOrganizationDto = OrganizationMapper.mapToOrganizationDto(savedOrganization);
        return savedOrganizationDto;
    }

    public OrganizationDto getOrganizationByCode(String organizationCode){
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationDto(organization);
        return organizationDto;
    }
}
