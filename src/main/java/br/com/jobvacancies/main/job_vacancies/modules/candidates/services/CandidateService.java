package br.com.jobvacancies.main.job_vacancies.modules.candidates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jobvacancies.main.job_vacancies.modules.candidates.dto.ApiResponse;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.model.CandidateModel;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.repository.CandidateRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public ResponseEntity<ApiResponse> createCandidate(CandidateModel candidateModel) {
        if (candidateRepository.existsByEmail(candidateModel.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse("The user already exists", HttpStatus.CONFLICT.value()));
        }

        candidateRepository.save(candidateModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Candidate created successfully", HttpStatus.CREATED.value()));
    }
    
}
