package br.com.jobvacancies.main.job_vacancies.modules.candidates.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.dto.AuthEntityDto;
import br.com.jobvacancies.main.job_vacancies.common.dto.AuthResponseDto;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.model.CandidateModel;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.services.CandidateService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidates")
public class CandidatesController {
    @Autowired
    private CandidateService candidateService;
    
    @PostMapping("/auth/register")
    public ResponseEntity<ApiResponseDto> registerCandidate(@Valid @RequestBody CandidateModel candidateModel) {  
        return candidateService.registerCandidate(candidateModel);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponseDto> loginCandidate(@Valid @RequestBody AuthEntityDto authEntityDto) {  
        return candidateService.loginCandidate(authEntityDto);
    }
    
}
