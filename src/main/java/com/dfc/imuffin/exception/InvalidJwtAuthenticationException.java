package com.dfc.imuffin.exception;

import javax.naming.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {
    public InvalidJwtAuthenticationException (String e){
        super(e);
    }
}
