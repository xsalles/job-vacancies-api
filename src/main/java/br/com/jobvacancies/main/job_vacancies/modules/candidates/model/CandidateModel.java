package br.com.jobvacancies.main.job_vacancies.modules.candidates.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateModel {
    
    private UUID id;
    private String name;
    
    @Pattern( regexp = "^(?!\\s*$).+", message = "O campo (username) não deve conter espaços" )
    private String username;

    @Email( message = "O campo (email) deve conter um email válido" )
    private String email;

    @Length( min = 6, max = 100, message = "O campo (password) deve conter entre 6 e 100 caracteres" )
    private String password;
    
    private String description;
    private String curriculum;

}
