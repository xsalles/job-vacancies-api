package br.com.jobvacancies.main.job_vacancies.modules.candidates.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.jobvacancies.main.job_vacancies.common.dto.ApiResponse;
import br.com.jobvacancies.main.job_vacancies.modules.candidates.exceptions.UserAlreadyExistsExcepetion;

@RestControllerAdvice
public class UserAlreadyExistsHandler {

    @ExceptionHandler(UserAlreadyExistsExcepetion.class)
    public ResponseEntity<ApiResponse> handleUserAlreadyExistsException(UserAlreadyExistsExcepetion ex) {
        return ResponseEntity.status(409).body(new ApiResponse(ex.getMessage(), 409));
    }
}
