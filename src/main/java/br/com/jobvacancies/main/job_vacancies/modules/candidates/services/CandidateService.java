package br.com.jobvacancies.main.job_vacancies.modules.candidates.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityAlreadyExistsException;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.model.CandidateModel;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.repository.CandidateRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public ResponseEntity<ApiResponseDto> createCandidate(CandidateModel candidateModel) {
        if (candidateRepository.existsByEmail(candidateModel.getEmail())) {
            throw new EntityAlreadyExistsException("Candidate with this email already exists.");
        }

        candidateRepository.save(candidateModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDto("Candidate created successfully", HttpStatus.CREATED.value()));
    }
    
}
