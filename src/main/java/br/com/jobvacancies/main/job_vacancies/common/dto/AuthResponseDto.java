package br.com.jobvacancies.main.job_vacancies.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthResponseDto extends ApiResponseDto<String> {
    private String token;

    public AuthResponseDto(String message, int status, String token) {
        super(message, status);
        this.token = token;
    }
}
