package net.santhosh.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service Rest APIs",
				description = "Organization Service Rest APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Santhosh",
						email = "santhosh@gmail.com",
						url = "https://www.javaguides.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.javaguides.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service doc",
				url = "https://www.javaguides.com"
		)
)

public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
