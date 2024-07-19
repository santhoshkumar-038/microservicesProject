package net.santhosh.organizationservice.mapper;

import net.santhosh.organizationservice.dto.OrganizationDto;
import net.santhosh.organizationservice.entity.Organization;

public class OrganizationMapper {
    public static Organization mapToOrganization(OrganizationDto organizationDto){
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate()
        );

        return organization;
    }

    public static OrganizationDto mapToOrganizationDto(Organization organization){
        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );

        return organizationDto;
    }
}
