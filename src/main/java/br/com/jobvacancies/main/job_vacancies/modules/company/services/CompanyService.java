package br.com.jobvacancies.main.job_vacancies.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.dto.AuthEntityDto;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityAlreadyExistsException;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityNotFoundException;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityWrongPasswordException;
import br.com.jobvacancies.main.job_vacancies.modules.company.model.CompanyModel;
import br.com.jobvacancies.main.job_vacancies.modules.company.repository.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<ApiResponseDto> registerCompany(CompanyModel companyModel) {
        if (companyRepository.existsByEmailOrCnpj(companyModel.getEmail(), companyModel.getCnpj())) {
            throw new EntityAlreadyExistsException("Company with this email or CNPJ already exists.");
        }

        var hashedPassword = passwordEncoder.encode(companyModel.getPassword());

        companyModel.setPassword(hashedPassword);

        companyRepository.save(companyModel);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseDto("Company created successfully", HttpStatus.CREATED.value()));
    }

    public ResponseEntity<ApiResponseDto> loginCompany(AuthEntityDto authEntityDto) {
        if (!companyRepository.existsByEmail(authEntityDto.getEmail())) {
            throw new EntityNotFoundException("Company with this email does not exist.");
        }

        if (!passwordEncoder.matches(authEntityDto.getPassword(),
                companyRepository.findByEmail(authEntityDto.getEmail()).get().getPassword())) {
            throw new EntityWrongPasswordException();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponseDto("Company logged in successfully", HttpStatus.OK.value()));
    }
}
