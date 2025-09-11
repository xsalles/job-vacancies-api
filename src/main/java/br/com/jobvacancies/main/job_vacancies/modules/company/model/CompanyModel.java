package br.com.jobvacancies.main.job_vacancies.modules.company.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.jobvacancies.main.job_vacancies.modules.jobs.models.JobsModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "companies")
public class CompanyModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @NotBlank(message = "The field (name) is required")
    private String name;

    @Pattern( regexp = "(\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})", message = "The field (CNPJ) must have 14 digits or in the format 00.000.000/0000-00." )
    @NotBlank(message = "The field (CNPJ) is required")
    private String cnpj;
    
    @Pattern( regexp = "\\S+", message = "The field (username) should'nt contain spaces." )
    @NotBlank(message = "The field (username) is required")
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "The field (email) is required")
    private String email;

    @NotBlank(message = "The field (password) is required")
    private String password;

    private String website;

    @NotBlank(message = "The field (description) is required")
    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobsModel> jobs;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
