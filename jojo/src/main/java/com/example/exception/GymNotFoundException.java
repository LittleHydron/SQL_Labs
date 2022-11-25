package com.example.exception;

public class GymNotFoundException extends RuntimeException{
    public GymNotFoundException(Integer id){
        super("Gym with id=" + id + " was not found");
    }
}
