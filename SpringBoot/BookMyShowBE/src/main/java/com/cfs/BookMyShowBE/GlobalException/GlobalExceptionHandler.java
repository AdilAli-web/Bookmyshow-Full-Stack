package com.cfs.BookMyShowBE.GlobalException;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookingNotFound.class)
    ResponseEntity<ExceptionResponse> bookingNotFound(
            BookingNotFound exception,
            HttpServletRequest request) {

        return error(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                request
        );
    }

    @ExceptionHandler(CustomerNotFound.class)
    ResponseEntity<ExceptionResponse> customerNotFound(
            CustomerNotFound exception,
            HttpServletRequest request) {

        return error(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                request
        );
    }

    @ExceptionHandler(ShowNotFound.class)
    ResponseEntity<ExceptionResponse> showNotFound(
            ShowNotFound exception,
            HttpServletRequest request) {

        return error(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                request
        );
    }

    @ExceptionHandler(ProfileException.class)
    ResponseEntity<ExceptionResponse> profileException(
            ProfileException exception,
            HttpServletRequest request) {

        return error(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                request
        );
    }

    @ExceptionHandler(SeatNotAvailable.class)
    ResponseEntity<ExceptionResponse> seatNotAvailable(
            SeatNotAvailable exception,
            HttpServletRequest request) {

        return error(
                HttpStatus.CONFLICT,
                exception.getMessage(),
                request
        );
    }

    @ExceptionHandler(BookingException.class)
    ResponseEntity<ExceptionResponse> bookingException(
            BookingException exception,
            HttpServletRequest request) {

        return error(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                request
        );
    }

//    @ExceptionHandler(RuntimeException.class)
//    ResponseEntity<ExceptionResponse> runtimeException(
//            RuntimeException exception,
//            HttpServletRequest request) {
//
//        return error(
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                "Something went wrong",
//                request
//        );
//    }

    private ResponseEntity<ExceptionResponse> error(
            HttpStatus status,
            String msg,
            HttpServletRequest request) {

        return ResponseEntity
                .status(status)
                .body(new ExceptionResponse(
                        Instant.now(),
                        status.value(),
                        status.getReasonPhrase(),
                        msg,
                        request.getRequestURI()
                ));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {

        ex.printStackTrace();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    ResponseEntity<ExceptionResponse> validation(
            Exception exception,
            HttpServletRequest request) {

        return error(
                HttpStatus.BAD_REQUEST,
                "Request validation failed",
                request
        );
    }

}