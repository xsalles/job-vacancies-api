package br.com.jobvacancies.main.job_vacancies.modules.company.exceptions;

public class CompanyAlreadyExistsExcepetion extends RuntimeException {
    public CompanyAlreadyExistsExcepetion() {
        super("Company already exists with a specific of these informations");
    }
}
