package br.edu.senaisp.Pastel.web.exception;

import br.edu.senaisp.Pastel.exception.DataInvalidException;
import br.edu.senaisp.Pastel.exception.PastelNotFoundException;
import br.edu.senaisp.Pastel.exception.PastelUniqueViolationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiHandlerException {

    @ExceptionHandler(PastelNotFoundException.class)
    public ResponseEntity<ErrorMessage> pastelNotFoundException(RuntimeException ex, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(PastelUniqueViolationException.class)
    public ResponseEntity<ErrorMessage> pastelUniqueViolationException(RuntimeException ex, HttpServletRequest request){
        return  ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
    }

    @ExceptionHandler(DataInvalidException.class)
    public ResponseEntity<ErrorMessage> dataInvalidException(RuntimeException ex, HttpServletRequest request){
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(RuntimeException ex, HttpServletRequest request, BindingResult result){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), result));
    }

}
