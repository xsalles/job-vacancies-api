package br.com.jobvacancies.main.job_vacancies.modules.candidates.exceptions;

public class UserAlreadyExistsExcepetion extends RuntimeException {
    public UserAlreadyExistsExcepetion() {
        super("User already exists with this email");
    }
}
