package com.springlearning.intro.exception;

import com.springlearning.intro.dto.error.FieldErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleValidationException(MethodArgumentNotValidException ex){
       return  ResponseEntity.badRequest().body(new ErrorDetails(HttpStatus.BAD_REQUEST.value(),
               HttpStatus.BAD_REQUEST.toString(),"ERROR",
               LocalDateTime.now(), listValidationError(ex.getFieldErrors())));
    }

    public List<FieldErrorDTO> listValidationError(List<FieldError> fieldErrors){
        return fieldErrors.stream()
                .map(fieldError -> {
                    return new FieldErrorDTO(fieldError.getField(),fieldError.getDefaultMessage());
                }).collect(Collectors.toList());
    }

   @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        return null;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllUncaughtException(Exception exception,
                                                                   WebRequest request){
        LOGGER.error(exception.getMessage(),exception);
        ErrorDetails errorDetails = ErrorDetails.withOutFieldErrors(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),"An unexpected error ocurred ",
                LocalDateTime.now());

        return ResponseEntity.internalServerError().body(errorDetails);
    }



}

