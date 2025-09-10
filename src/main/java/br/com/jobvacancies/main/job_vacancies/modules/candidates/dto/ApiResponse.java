package br.com.jobvacancies.main.job_vacancies.modules.candidates.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
   private String message;
   private int status;
}
