package com.admin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.crypto.Data;

//@ResponseStatus(reason = "haha" , code = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED)
public class DataNotFindException extends RuntimeException{
    public DataNotFindException(){
        super();
    }

    public DataNotFindException(String message){
        super(message);
    }
}
