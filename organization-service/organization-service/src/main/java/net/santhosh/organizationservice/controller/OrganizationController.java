package net.santhosh.organizationservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.santhosh.organizationservice.dto.OrganizationDto;
import net.santhosh.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    //  Build Save organization REST API
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    //  Build get organization by code REST API

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizaton(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
}
