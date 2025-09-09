package br.com.jobvacancies.main.job_vacancies.modules.candidates.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobvacancies.main.job_vacancies.modules.candidates.model.CandidateModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidates")
public class CandidatesController {
    
    @PostMapping("/create")
    public CandidateModel create(@RequestBody CandidateModel candidateModel) {  
       return candidateModel; 
    }
    
}
