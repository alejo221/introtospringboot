package com.springlearning.intro.exception;

import com.springlearning.intro.dto.error.FieldErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails{
    private int status;
    private String error;
    private String message;
    private LocalDateTime date;
    private List<FieldErrorDTO> errors;

    public ErrorDetails(int status, String error, String message, LocalDateTime date, List<FieldErrorDTO> errors) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.date = date;
        this.errors = errors;
    }

    public static ErrorDetails withOutFieldErrors(int status, String error, String message, LocalDateTime date
                                                 ){
        return new ErrorDetails(status, error, message, date, List.of());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<FieldErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldErrorDTO> errors) {
        this.errors = errors;
    }
}
