package br.com.jobvacancies.main.job_vacancies.common.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityWrongPasswordException;

@ControllerAdvice
public class EntityWrongPasswordHandler {

    @ExceptionHandler(EntityWrongPasswordException.class)
    public ResponseEntity<ApiResponseDto> handleEntityWrongPassword(EntityWrongPasswordException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponseDto(ex.getMessage(), HttpStatus.UNAUTHORIZED.value()));
    }

}
