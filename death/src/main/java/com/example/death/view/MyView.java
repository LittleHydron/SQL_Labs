package com.example.death.view;

import com.example.death.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyView {
    @Autowired
    private ExcerciseController excerciseController;

    @Autowired
    private ProgramController programController;

    @Autowired
    private SetOfExcercisesController setOfExcercisesController;

    @Autowired
    private ProgramContainsController programContainsController;

    @Autowired
    private GymController gymController;

    @Autowired
    private TrainerController trainerController;

    @Autowired
    private TraineeController traineeController;

    @Autowired
    private TrainerWorksInController trainerWorksInController;

    Scanner scanner = new Scanner(System.in);
    private void displayMainMenu(){
        System.out.println("Please, select table to work with:");
        System.out.println("0 - Excercise\n1 - Gym\n2 - Program\n3 - ProgramContains\n4 - SetOfExcercises\n5 - Trainee\n6 - Trainer\n7 - TrainerWorksIn\n8 - Quit");
    }

    private void displayCommonFunctions(){
        System.out.println("Please, select action to perform on selected table:\n");
        System.out.println("0 - get all entries\n1 - get entry by id\n2 - insert a new value\n3 - update entry\n4 - delete entry\n");
    }
    public void show(){
        while(true) {
            displayMainMenu();
            try {
                int option = scanner.nextInt();
                if (option == 8){
                    System.out.println("Bye!");
                    break;
                }
                displayCommonFunctions();

            } catch (Exception e){
                System.err.println("You have to insert number from 0 to 8");
                break;
            }
        }
    }
}
