package br.com.jobvacancies.main.job_vacancies.common.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthEntityDto {
    @Email( message = "The field (email) should be valid" )
    private String email;

    @Length( min = 6, max = 100, message = "O campo (password) deve conter entre 6 e 100 caracteres" )
    private String password;
}
