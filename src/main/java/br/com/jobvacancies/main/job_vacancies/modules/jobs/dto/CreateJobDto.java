package br.com.jobvacancies.main.job_vacancies.modules.jobs.dto;

import java.util.List;

import br.com.jobvacancies.main.job_vacancies.modules.jobs.enums.JobLevelEnum;
import lombok.Data;

@Data
public class CreateJobDto {
    private String title;
    private String description;
    private JobLevelEnum level;
    private List<String> benefits;
}
