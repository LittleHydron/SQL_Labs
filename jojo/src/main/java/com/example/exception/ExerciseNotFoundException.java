package com.example.exception;

public class ExerciseNotFoundException extends RuntimeException{
    public ExerciseNotFoundException(Integer id){
        super("Exercise with id=" + id + " was not found");
    }
}
