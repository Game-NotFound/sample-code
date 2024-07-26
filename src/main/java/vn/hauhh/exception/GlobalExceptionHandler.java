package vn.hauhh.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {


    public ErrorResponse handleValidation(Exception e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();

        return null;
    }

}
