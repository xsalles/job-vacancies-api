package br.com.jobvacancies.main.job_vacancies.common.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDto {
   private String message;
   private int status;
}
