package br.com.jobvacancies.main.job_vacancies.modules.jobs.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.modules.jobs.dto.CreateJobDto;
import br.com.jobvacancies.main.job_vacancies.modules.jobs.models.JobsModel;
import br.com.jobvacancies.main.job_vacancies.modules.jobs.services.JobsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    private JobsService jobsService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto> createJob(@Valid @RequestBody CreateJobDto createJobDto, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

        JobsModel jobModel = JobsModel.builder()
        .title(createJobDto.getTitle())
        .description(createJobDto.getDescription())
        .level(createJobDto.getLevel())
        .benefits(createJobDto.getBenefits())
        .companyId(UUID.fromString(companyId.toString()))
        .build();

        return jobsService.createJob(jobModel);
    }
}
