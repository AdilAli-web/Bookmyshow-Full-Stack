package com.cfs.BookMyShowBE.GlobalException;

public class BookingException extends RuntimeException{
    public BookingException(String message)
    {
        super(message);
    }
}
