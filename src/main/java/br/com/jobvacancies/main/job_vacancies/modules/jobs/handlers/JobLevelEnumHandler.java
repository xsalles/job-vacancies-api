package br.com.jobvacancies.main.job_vacancies.modules.jobs.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponse;

@RestControllerAdvice
public class JobLevelEnumHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse("Invalid job level provided. Accepted values are: JUNIOR, PLENO, SENIOR.",
                        HttpStatus.BAD_REQUEST.value()));
    }
}
