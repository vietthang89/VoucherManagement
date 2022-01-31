package com.justintu.api;

import com.justintu.api.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(VoucherNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleApiException(
            VoucherNotFoundException ex) {
        ErrorMessage response =
                new ErrorMessage("error-0001",
                        "No Voucher found with code " + ex.getId());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VoucherAlreadyAppliedException.class)
    public ResponseEntity<ErrorMessage> handleApiException(
            VoucherAlreadyAppliedException ex) {
        ErrorMessage response =
                new ErrorMessage("error-0002",
                        "Voucher code " + ex.getId() + " was used");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VoucherAlreadyExpiredException.class)
    public ResponseEntity<ErrorMessage> handleApiException(
            VoucherAlreadyExpiredException ex) {
        ErrorMessage response =
                new ErrorMessage("error-0003",
                        "Voucher code " + ex.getId() + " is expired.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VoucherOutOfUsedException.class)
    public ResponseEntity<ErrorMessage> handleApiException(
            VoucherOutOfUsedException ex) {
        ErrorMessage response =
                new ErrorMessage("error-0004",
                        "Voucher code " + ex.getId() + " is out of uses.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
