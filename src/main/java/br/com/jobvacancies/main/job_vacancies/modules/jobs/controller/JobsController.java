package br.com.jobvacancies.main.job_vacancies.modules.jobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.modules.jobs.models.JobsModel;
import br.com.jobvacancies.main.job_vacancies.modules.jobs.services.JobsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    private JobsService jobsService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto> createJob(@Valid @RequestBody JobsModel jobModel) {
        return jobsService.createJob(jobModel);
    }
}
