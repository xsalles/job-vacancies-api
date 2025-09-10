package br.com.jobvacancies.main.job_vacancies.modules.company.model;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CompanyModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;

    @Pattern( regexp = "(\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})", message = "The field (CNPJ) must have 14 digits or in the format 00.000.000/0000-00." )
    private String CNPJ;
    
    @Pattern( regexp = "\\S+", message = "The field (username) should'nt contain spaces." )
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "The field (email) is required")
    private String email;

    @NotBlank(message = "The field (password) is required")
    private String password;

    private String website;

    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
