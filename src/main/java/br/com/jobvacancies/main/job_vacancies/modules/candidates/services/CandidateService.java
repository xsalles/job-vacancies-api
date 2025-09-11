package br.com.jobvacancies.main.job_vacancies.modules.candidates.services;

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
import br.com.jobvacancies.main.job_vacancies.modules.candidates.model.CandidateModel;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.repository.CandidateRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<ApiResponseDto> registerCandidate(CandidateModel candidateModel) {
        if (candidateRepository.existsByEmail(candidateModel.getEmail())) {
            throw new EntityAlreadyExistsException("Candidate with this email already exists.");
        }

        var hashedPassword = passwordEncoder.encode(candidateModel.getPassword());

        candidateModel.setPassword(hashedPassword);

        candidateRepository.save(candidateModel);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseDto("Candidate created successfully", HttpStatus.CREATED.value()));
    }

    public ResponseEntity<ApiResponseDto> loginCandidate(AuthEntityDto authEntityDto) {
        if (!candidateRepository.existsByEmail(authEntityDto.getEmail())) {
            throw new EntityNotFoundException("Candidate with this email does not exist.");
        }

        if (!passwordEncoder.matches(authEntityDto.getPassword(),
                candidateRepository.findByEmail(authEntityDto.getEmail()).get().getPassword())) {
            throw new EntityWrongPasswordException();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponseDto("Candidate logged in successfully", HttpStatus.OK.value()));
    }

}
