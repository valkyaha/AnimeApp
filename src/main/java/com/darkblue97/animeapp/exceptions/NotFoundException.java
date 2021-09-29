package com.darkblue97.animeapp.exceptions;

public class NotFoundException extends Exception{
    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return ("Exception occurred when fetching data:" + message);
    }
}
