package br.com.jobvacancies.main.job_vacancies.modules.jobs.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import br.com.jobvacancies.main.job_vacancies.modules.company.model.CompanyModel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JobsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(min = 10, max = 200, message = "The field (title) must contain between 2 and 100 characters")
    @NotBlank(message = "The field (title) is required")
    private String title;

    private String description;

    private List<String> benefits;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false, updatable = false)
    private CompanyModel company;
}
