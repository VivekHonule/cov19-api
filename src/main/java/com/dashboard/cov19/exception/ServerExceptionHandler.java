package com.dashboard.cov19.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ServerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    protected ResponseEntity<ApiError> handleRegistrationException(RegistrationException ex) {
        ApiError apiError = new ApiError(NOT_ACCEPTABLE, ex.getMessage(), ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(LoginException.class)
    protected ResponseEntity<ApiError> handleRegistrationException(LoginException ex) {
        ApiError apiError = new ApiError(UNAUTHORIZED, ex.getMessage(), ex);
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
