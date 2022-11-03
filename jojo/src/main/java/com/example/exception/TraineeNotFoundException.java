package com.example.exception;

public class TraineeNotFoundException extends RuntimeException{
    public TraineeNotFoundException(Integer id){
        super("Trainee with id=" + id + " was not found");
    }
}
