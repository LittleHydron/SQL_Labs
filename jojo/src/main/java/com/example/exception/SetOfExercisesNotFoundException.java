package com.example.exception;

public class SetOfExercisesNotFoundException extends RuntimeException{
    public SetOfExercisesNotFoundException(Integer id){
        super("SetOfExcercises with id=" + id + " was not found");
    }
}
