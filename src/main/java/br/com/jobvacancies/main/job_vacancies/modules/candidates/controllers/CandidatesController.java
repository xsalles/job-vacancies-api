package br.com.jobvacancies.main.job_vacancies.modules.candidates.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobvacancies.main.job_vacancies.modules.candidates.model.CandidateModel;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidates")
public class CandidatesController {
    
    @PostMapping("/create")
    public void create(@Valid @RequestBody CandidateModel candidateModel) {  
       System.out.println(candidateModel.getEmail()); 
    }
    
}
