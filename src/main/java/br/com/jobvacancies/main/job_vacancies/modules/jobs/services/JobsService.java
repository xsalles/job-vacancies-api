package br.com.jobvacancies.main.job_vacancies.modules.jobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponseDto;
import br.com.jobvacancies.main.job_vacancies.modules.jobs.models.JobsModel;
import br.com.jobvacancies.main.job_vacancies.modules.jobs.repository.JobsRepository;

@Service
public class JobsService {
    @Autowired
    private JobsRepository jobsRepository;

    public ResponseEntity<ApiResponseDto> createJob(JobsModel jobModel) {
        jobsRepository.save(jobModel);

        return ResponseEntity.ok(new ApiResponseDto("Job created successfully", 200));
    }
}
