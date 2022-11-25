package com.example.exception;

public class TrainerNotFoundException extends RuntimeException{
    public TrainerNotFoundException(Integer id){
        super("Trainer with id=" + id + " was not found");
    }
}
