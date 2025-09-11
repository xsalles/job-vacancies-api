package br.com.jobvacancies.main.job_vacancies.common.exceptions;

public class EntityWrongPasswordException extends RuntimeException {
    public EntityWrongPasswordException() {
        super("Incorrect password.");
    }
}
