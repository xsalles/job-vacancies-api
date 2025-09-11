package br.com.jobvacancies.main.job_vacancies.modules.company.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthCompanyDto {

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Pass")
    private String password;    
}
