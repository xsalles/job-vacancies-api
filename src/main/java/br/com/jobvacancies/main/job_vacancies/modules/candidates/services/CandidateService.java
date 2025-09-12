package br.com.jobvacancies.main.job_vacancies.modules.candidates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.dto.AuthEntityDto;
import br.com.jobvacancies.main.job_vacancies.common.dto.AuthResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityAlreadyExistsException;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityNotFoundException;
import br.com.jobvacancies.main.job_vacancies.common.exceptions.EntityWrongInformationsException;
import br.com.jobvacancies.main.job_vacancies.common.provider.JwtProvider;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.model.CandidateModel;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.repository.CandidateRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider JWTProvider;

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

    public ResponseEntity<AuthResponseDto> loginCandidate(AuthEntityDto authEntityDto) {
        var candidate = candidateRepository.findByEmail(authEntityDto.getEmail());

        if (!candidate.isPresent()) {
            throw new EntityNotFoundException("Candidate with this email does not exist.");
        }

        var passwordMatches = passwordEncoder.matches(authEntityDto.getPassword(),
                candidateRepository.findByEmail(authEntityDto.getEmail()).get().getPassword());

        if (!passwordMatches) {
            throw new EntityWrongInformationsException();
        }

        var token = JWTProvider.generateToken(candidate.get().getId(), candidate.get().getName(), candidate.get().getEmail());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new AuthResponseDto("Candidate logged in successfully", HttpStatus.OK.value(), token));
    }

}
