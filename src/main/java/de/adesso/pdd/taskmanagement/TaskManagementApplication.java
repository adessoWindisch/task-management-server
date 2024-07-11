package de.adesso.pdd.taskmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("de.adesso.pdd.taskmanagement.repository")
@EntityScan("de.adesso.pdd.taskmanagement.entity")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info =  @Info(
				title = "Task Management API",
				version = "1.0",
				description = "Task Management API",
				contact = @io.swagger.v3.oas.annotations.info.Contact(
						name = "Sascha Windisch",
						email = "sascha.windisch@adesso.de",
						url = "https://www.adesso.de"
				)
		),
		externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
				description = "Task Management API",
				url = "https://www.adesso.de"
		)
)
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}
}
