package br.com.jobvacancies.main.job_vacancies.modules.jobs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jobvacancies.main.job_vacancies.modules.jobs.models.JobsModel;

public interface JobsRepository extends JpaRepository<JobsModel, UUID> {
}
