package com.example.exception;

public class ProgramNotFoundException extends RuntimeException{
    public ProgramNotFoundException(Integer id){
        super("Program with id=" + id + " was not found");
    }
}
