package org.codeArmy.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.codeArmy.dto.ExceptionResponseDto;
import org.codeArmy.dto.ValidationExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
//@ControllerAdvice
// Only for testing
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest httpServletRequest) {
        ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericException(Exception exception, HttpServletRequest httpServletRequest) {
        ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException runtimeException, HttpServletRequest httpServletRequest) {
        ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), runtimeException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDto> handleRuntimeException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest) {
        Map<String, String> fieldErrors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(fieldError -> fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        ValidationExceptionResponseDto validationExceptionResponseDto = new ValidationExceptionResponseDto(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
                /*methodArgumentNotValidException.getMessage() */
                "validation failed..", httpServletRequest.getRequestURI(), fieldErrors);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(validationExceptionResponseDto);
    }
}
