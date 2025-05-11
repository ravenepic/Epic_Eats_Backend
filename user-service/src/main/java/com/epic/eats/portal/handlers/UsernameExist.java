package com.epic.eats.portal.handlers;


public class UsernameExist extends Exception{
    private String message;
    public UsernameExist(String message){
        super(message);
    }
}
