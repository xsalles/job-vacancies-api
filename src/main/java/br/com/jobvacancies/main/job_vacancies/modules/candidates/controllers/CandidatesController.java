package br.com.jobvacancies.main.job_vacancies.modules.candidates.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.dto.AuthEntityDto;
import br.com.jobvacancies.main.job_vacancies.common.dto.AuthResponseDto;
import br.com.jobvacancies.main.job_vacancies.common.provider.JwtProvider;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.model.CandidateModel;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.services.CandidateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/candidates")
public class CandidatesController {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private JwtProvider JWTProvider;
    
    @PostMapping("/auth/register")
    public ResponseEntity<ApiResponseDto<String>> registerCandidate(@Valid @RequestBody CandidateModel candidateModel) {  
        return candidateService.registerCandidate(candidateModel);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponseDto> loginCandidate(@Valid @RequestBody AuthEntityDto authEntityDto) {  
        return candidateService.loginCandidate(authEntityDto);
    }

    @GetMapping("/profile")
    public ResponseEntity<ApiResponseDto<CandidateModel>> getProfileCandidate(UUID id, HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        
        if (header != null) {
            var subjectToken = this.JWTProvider.validateToken(header);

            if (subjectToken.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new ApiResponseDto<CandidateModel>("Invalid or expired token", HttpStatus.UNAUTHORIZED.value(), null));
            }

            request.setAttribute("candidate_id", subjectToken);
        }        

        return candidateService.getProfileCandidate(UUID.fromString(request.getAttribute("candidate_id").toString()));
    }
    
    
}
