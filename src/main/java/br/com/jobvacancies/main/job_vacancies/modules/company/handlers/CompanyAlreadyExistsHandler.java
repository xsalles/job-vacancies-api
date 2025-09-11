package br.com.jobvacancies.main.job_vacancies.modules.company.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponse;
import br.com.jobvacancies.main.job_vacancies.modules.company.exceptions.CompanyAlreadyExistsException;

@RestControllerAdvice
public class CompanyAlreadyExistsHandler {
    @ExceptionHandler(CompanyAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleCompanyExistsException(CompanyAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ApiResponse(ex.getMessage(), 409));
    }
}
