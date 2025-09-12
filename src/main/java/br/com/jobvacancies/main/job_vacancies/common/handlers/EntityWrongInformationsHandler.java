package br.com.jobvacancies.main.job_vacancies.common.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityWrongInformationsException;

@ControllerAdvice
public class EntityWrongInformationsHandler {

    @ExceptionHandler(EntityWrongInformationsException.class)
    public ResponseEntity<ApiResponseDto<String>> handleEntityWrongPassword(EntityWrongInformationsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponseDto<String>(ex.getMessage(), HttpStatus.UNAUTHORIZED.value()));
    }

}
