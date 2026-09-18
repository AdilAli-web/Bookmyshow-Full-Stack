package com.cfs.BookMyShowBE.GlobalException;

public class ShowNotFound extends RuntimeException{
    public ShowNotFound(String message){
        super(message);
    }
}
