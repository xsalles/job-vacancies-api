package br.com.jobvacancies.main.job_vacancies.common.exceptions;

public class EntityWrongInformationsException extends RuntimeException {
    public EntityWrongInformationsException() {
        super("Incorrect password or email.");
    }
}
