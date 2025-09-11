package br.com.jobvacancies.main.job_vacancies.modules.company.exceptions;

public class CompanyAlreadyExistsException extends RuntimeException {
    public CompanyAlreadyExistsException() {
        super("Company already exists with a specific of these informations");
    }
}
