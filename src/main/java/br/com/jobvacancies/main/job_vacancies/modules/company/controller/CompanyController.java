package br.com.jobvacancies.main.job_vacancies.modules.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponse;
import br.com.jobvacancies.main.job_vacancies.modules.company.model.CompanyModel;
import br.com.jobvacancies.main.job_vacancies.modules.company.services.CompanyService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCompany(@Valid @RequestBody CompanyModel companyModel) {
        return companyService.createCompany(companyModel);
    }

}
