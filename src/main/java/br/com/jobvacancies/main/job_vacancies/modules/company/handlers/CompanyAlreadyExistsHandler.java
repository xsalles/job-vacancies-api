package br.com.jobvacancies.main.job_vacancies.modules.company.handlers;

import org.springframework.http.ResponseEntity;

import br.com.jobvacancies.main.job_vacancies.modules.candidates.dto.ApiResponse;
import br.com.jobvacancies.main.job_vacancies.modules.company.exceptions.CompanyAlreadyExistsExcepetion;

public class CompanyAlreadyExistsHandler {
    public ResponseEntity<ApiResponse> handleCompanyExistsException(CompanyAlreadyExistsExcepetion ex) {
        return ResponseEntity.status(409).body(new ApiResponse(ex.getMessage(), 409));
    }
}
