package com.cfs.BookMyShowBE.GlobalException;



public class BookingNotFound extends RuntimeException{
    public BookingNotFound(String mess){
        super(mess);
    }
}
