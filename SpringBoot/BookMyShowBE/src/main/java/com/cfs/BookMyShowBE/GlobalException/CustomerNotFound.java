package com.cfs.BookMyShowBE.GlobalException;

public class CustomerNotFound extends  RuntimeException{
    public CustomerNotFound(String message){
        super(message);
    }
}
