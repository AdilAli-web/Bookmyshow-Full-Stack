package com.cfs.BookMyShowBE.GlobalException;

public class SeatNotAvailable extends RuntimeException{
    public SeatNotAvailable(String message){
        super(message);
    }
}
