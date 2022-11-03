package com.example.controller;

import com.example.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ExerciseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> excerciseHandler(ExerciseNotFoundException ex){
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(GymNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> gymHandler(GymNotFoundException ex){
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(ProgramNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> programHandler(ProgramNotFoundException ex){
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(SetOfExercisesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> setOfExcercisesHandler(SetOfExercisesNotFoundException ex){
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(TraineeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> TraineeHandler(TraineeNotFoundException ex){
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }
    
    @ResponseBody
    @ExceptionHandler(TrainerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> TrainerHandler(TrainerNotFoundException ex){
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }
}
