package br.com.jobvacancies.main.job_vacancies.modules.candidates.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class CandidateModel {
    
    private UUID id;
    private String name;
    private String username;

    private String email;

    private String password;
    private String description;
    private String curriculum;

}
