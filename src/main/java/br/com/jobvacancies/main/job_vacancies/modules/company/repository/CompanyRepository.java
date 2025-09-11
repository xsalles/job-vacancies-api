package br.com.jobvacancies.main.job_vacancies.modules.company.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jobvacancies.main.job_vacancies.modules.company.model.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, UUID>{
   boolean existsByEmailOrCnpj(String email, String cnpj);
   boolean existsByEmail(String email);

   Optional<CompanyModel> findByEmail(String email);
}
