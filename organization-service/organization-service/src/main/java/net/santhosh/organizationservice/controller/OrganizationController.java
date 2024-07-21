package net.santhosh.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Organization Service - Organization Controller",
        description = "Organization controller exposes Rest APIs for Organization Service"
)

public class OrganizationController {

    private OrganizationService organizationService;

    //  Build Save organization REST API
    @PostMapping
    @Operation(
            summary = "Save Organization Rest API",
            description = "Save Organization Rest API is used to save Organization object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 created"
    )
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    //  Build get organization by code REST API

    @GetMapping("{code}")
    @Operation(
            summary = "Get Organization Rest API",
            description = "Get Organization Rest API is used to get Organization object in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    public ResponseEntity<OrganizationDto> getOrganizaton(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
}
