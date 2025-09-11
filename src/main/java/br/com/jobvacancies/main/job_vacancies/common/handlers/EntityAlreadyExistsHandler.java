package br.com.jobvacancies.main.job_vacancies.common.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponse;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityAlreadyExistsException;

@RestControllerAdvice
public class EntityAlreadyExistsHandler {
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleEntityExistsException(EntityAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ApiResponse(ex.getMessage(), 409));
    }
}
