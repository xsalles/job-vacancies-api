package br.com.jobvacancies.main.job_vacancies.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponse;
import br.com.jobvacancies.main.job_vacancies.modules.company.exceptions.CompanyAlreadyExistsException;
import br.com.jobvacancies.main.job_vacancies.modules.company.model.CompanyModel;
import br.com.jobvacancies.main.job_vacancies.modules.company.repository.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public ResponseEntity<ApiResponse> createCompany(CompanyModel companyModel) {
        if (companyRepository.existsByEmailOrCnpj(companyModel.getEmail(), companyModel.getCnpj())) {
            throw new CompanyAlreadyExistsException();
        }

        companyRepository.save(companyModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Company created successfully", HttpStatus.CREATED.value()));
    }
}
